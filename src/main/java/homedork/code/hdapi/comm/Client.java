package homedork.code.hdapi.comm;

import java.io.*;
import java.net.Socket;

/**
 * Send in query Strings to this class, then to server(socket)
 */
public class Client {

	public Client() {
		setUpClient();
	}

	public Socket socket;
	public DataInputStream dataInputStream;
	public DataOutputStream dataOutputStream;
	public BufferedReader bufferedReader;


	public Socket setUpSocket() throws IOException {
		return new Socket("31.208.15.98", 1234);
	}

	public DataOutputStream getOutputStream(Socket socket) throws IOException {
		return new DataOutputStream(socket.getOutputStream());
	}

	public DataInputStream getInputStream(Socket socket) throws IOException {
		return new DataInputStream(socket.getInputStream());
	}

	public void setUpClient() {
		try {
			socket = setUpSocket();
			dataInputStream = getInputStream(socket);
			dataOutputStream = getOutputStream(socket);
			// objectInputStream = new ObjectInputStream(dataInputStream);
			bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
		} catch (IOException e) {
			System.err.println("Error during initial setup: " + e.getMessage());
		}
	}

	//  - response from database server
	//  - have  logic to map json + response message' from DB server
	//   json object to POJO called in @QueryBuilder class.
	//  TODO : only actual json object/array should be returned here, headers/response handled here!
	//   Good : 200 "OKAY"
	//   Bad  : 300 "invalid ID" - id doesn't exist
	public String getResponse() throws IOException {
		String messageFromDbServer;

		messageFromDbServer = bufferedReader.readLine();
		// status code-{json object} or  [{},{}]
		String[] parts = messageFromDbServer.split("-");
		String controlMessage = parts[0];
		String jsonStuff = parts[1];

		if(controlMessage.contains("200")) // everything is okay
				return jsonStuff;

		return null;
	}


	// - sends data query to database server (Query constructed in @QueryBuilder class)
	public boolean sendQuery(String query) {
		try {
			dataOutputStream.writeBytes(query + "\r\n");
			dataOutputStream.flush();
			return true;
		} catch (IOException e) {
			System.err.println("Error while writing query to DB server: " + e.getMessage());
		}
		return false;
	}
}
