import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * main function of Server.
 */
public class ServerMain {
  private static final int portNum = 8809;
  private static ArrayList<MultiClientHandler> clientList = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(portNum);
    while (true) {
      System.out.println("Try connecting with client...");
      Socket clientSocket = serverSocket.accept();
      System.out.println("Successfully connecting from " + clientSocket);
      MultiClientHandler client = new MultiClientHandler(clientSocket, clientList);
      clientList.add(client);
      new Thread(client).start();
    }
  }
}
