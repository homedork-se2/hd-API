package homedork.code.hdapi.comm;

import homedork.code.hdapi.model.User;
import homedork.code.hdapi.security.CryptoHandler;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Send in query Strings to this class, then to server(socket)
 */
public class Client {

	public Client() {
		try {
			setUpClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// test
	public static void main(String[] args) throws IOException {
		Client client = new Client();
		User user = new User("Dan", "rihanna@gmail.com", "453242uggg");

		/*String s = String.format("INSERT INTO `users` values('%s','%s','%s')", user.getUuid(), user.getName(),
				user.getEmail());*/


		String query = String.format("SELECT * from devices WHERE deviceId='%s' AND WHERE userId='%s';", "727272", "45343");


		// [D:deviceID:ON or level:userID]   D:2311:OFF:45343
		String hubTestQuery = "D:2311:33:45343";
		client.sendQuery(hubTestQuery);

		System.out.println(client.getResponse());
	}

	public Socket socket;
	public DataInputStream dataInputStream;
	public DataOutputStream dataOutputStream;
	public BufferedReader bufferedReader;
	public CryptoHandler cryptoHandler;


	public Socket setUpSocket() throws IOException {
		return new Socket(InetAddress.getLocalHost(), 1234);
	}

	public DataOutputStream getOutputStream(Socket socket) throws IOException {
		return new DataOutputStream(socket.getOutputStream());
	}

	public DataInputStream getInputStream(Socket socket) throws IOException {
		return new DataInputStream(socket.getInputStream());
	}

	public void setUpClient() throws Exception {
		try {
			socket = setUpSocket();
			dataInputStream = getInputStream(socket);
			dataOutputStream = getOutputStream(socket);
			cryptoHandler = new CryptoHandler(); // crashes on socket fail
			bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
		} catch (IOException e) {
			System.err.println("Error during initial setup: " + e.getMessage());
		}
	}

	/**
	 * Encrypted "response" from DB server via an encrypted stream channel. {@code #{messageFromDbServer}}.
	 * Decrypt with {@link #cryptoHandler} decryption method.
	 * have  logic to map json + response message' from DB server json object to POJO called in @JsonJavaParser.class via @QueryBuilder.class.
	 * only actual json object/array or null should be returned from here, headers/control message code handled here!
	 *
	 * <p>
	 * CONTROL CODE PROTOCOL
	 * <p>
	 * Status code  : 200 "OKAY"
	 * -> every resource operation returns a json object of the toyed model.
	 * Status code  : 300 "invalid ID" - id doesn't exist
	 * -> logically shouldn't happen.
	 * Status code  : 350 "empty"
	 * -> nothing returned, e.g. user has no devices.
	 * Status code  : 770 "Operation not Server supported"
	 *
	 * <p>
	 * Status code in response isn't encrypted  [plain text(status code) - encrypted(body)]
	 *
	 * @return Json String Object/array or null? {@code jsonStuff}
	 * @throws IOException -
	 */
	public String getResponse() throws IOException {

		try {
			String messageFromDbServer;

			messageFromDbServer = bufferedReader.readLine();

			// status code-{json object}/[{},{}]/null
			String[] parts = messageFromDbServer.split("-");

			String controlMessage = parts[0];
			String encryptedJsonStuff = parts[1];

			if(controlMessage.contains("200")) {  // everything is okay
				try {
					return cryptoHandler.aesDecrypt(encryptedJsonStuff.getBytes(StandardCharsets.UTF_8));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// null handles other control codes[300,350,750] - see docs comment
			return null;
		} catch (Exception e) {
			System.err.println("getResponse[ERROR]: " + e.getMessage());
		}
		return null;
	}

	/**
	 * @param query - plain query String from @QueryBuilder.class
	 * @return boolean (followed up boolean)
	 */
	public boolean sendQuery(String query) {
		try {
			// API prefix
			query = "API-" + query;
			dataOutputStream.writeBytes(cryptoHandler.aesEncrypt(query) + "\r\n");
			dataOutputStream.flush();
			return true;
		} catch (Exception e) {
			System.err.println("sendQuery[ERROR]: " + e.getMessage());
		}
		return false;
	}
}
