package homedork.code.hdapi.comm;

import java.io.*;
import java.net.InetAddress;
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
	public ObjectInputStream objectInputStream;
	public DataOutputStream dataOutputStream;
	public BufferedReader bufferedReader;


	public Socket setUpSocket() throws IOException {
		return new Socket(InetAddress.getLocalHost(), 1400);
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
			objectInputStream = new ObjectInputStream(dataInputStream);
			bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
		} catch (IOException e) {
			System.err.println("Error during initial setup: " + e.getMessage());
		}
	}

	//  - response from database server
	//  - have  logic to map json + response message' from DB server
	//   json object to POJO called in @QueryBuilder class.
	//  TODO : only actual json object/array should be returned here, headers/response handled here!
	public String getResponse() throws IOException {
		String messageFromDbServer = null;
		StringBuilder stringBuilder = new StringBuilder();

		while ((messageFromDbServer = bufferedReader.readLine()) != null) {
			stringBuilder.append(messageFromDbServer);
		}
		return stringBuilder.toString();
	}


	// - sends data query to database server (Query constructed in @QueryBuilder class)
	public boolean sendQuery(String query) {
		try {
			dataOutputStream.writeBytes(query + "\r\n");
			return true;
		} catch (IOException e) {
			System.err.println("Error while writing query to DB server: " + e.getMessage());
		}
		return false;
	}
}
