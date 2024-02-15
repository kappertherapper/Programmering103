package TCPSocket.sock;
import java.io.*;
import java.net.*;
public class TCPServer {

	public static void main(String[] args) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		System.out.println("SERVER IS RUNNING");
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			clientSentence = inFromClient.readLine();
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			//connectionSocket.close(); //sender bare null hehe
			outToClient.writeBytes(capitalizedSentence);
	
		}
	}

}
