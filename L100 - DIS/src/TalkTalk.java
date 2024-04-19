import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkTalk {
    public static void main(String[] args) {

        new Thread(() -> {
            try {
                runServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


        try {
            runClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(6969)) {
            System.out.println("Server started. Waiting for connection...");
            Socket connectionSocket = serverSocket.accept();

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));

            String clientSentence;
            String replySentence;

            while (true) {
                if ((clientSentence = inFromClient.readLine()) != null) {
                    System.out.println("Client: " + clientSentence);
                }
                System.out.print("Server: ");
                replySentence = inFromServer.readLine();
                outToClient.println(replySentence);

            }
        }
    }

    private static void runClient() throws IOException {
        try (Socket clientSocket = new Socket("localhost", 6969);
             BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true)) {


            String sentence;
            String serverSentence;
            System.out.println("Connected to server." + "\n" +  "Ip adress: " + clientSocket.getLocalAddress());

            while (true) {
                if ((serverSentence = inFromServer.readLine()) != null) {
                    System.out.println("Server: " + serverSentence);
                }

                System.out.print("Client: ");
                sentence = inFromUser.readLine();
                outToServer.println(sentence);

            }
        }
    }
}
