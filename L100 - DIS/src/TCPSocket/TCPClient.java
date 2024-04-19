package TCPSocket;
import java.io.*;
import java.net.*;

public class TCPClient {
	//Kør TCPServer først

	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost",6789);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		sentence = inFromUser.readLine();

		clientSocket.setSoTimeout(100000);
		try {
			Thread.sleep(10000);
			outToServer.writeBytes(sentence + '\n');
		} catch (SocketTimeoutException e) {
			System.out.println("TIMEOUT!!!");
		} finally {
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: " + modifiedSentence);
			System.out.println("IP-adresse: " + clientSocket.getLocalAddress().toString());
			clientSocket.close();
		}

	}
}


