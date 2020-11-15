import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Class of client main.
 */
public class ClientMain extends Socket {
  private static final String HOST_IP = "127.0.0.1";
  private static final int SERVER_PORT = 8809;
  private static final String DISCONNECT_SIGNAL = "logoff";
  private static Socket clientSocket;
  private static OutputStream outputStream;
  public ClientMain() throws Exception {
    super(HOST_IP, SERVER_PORT);
    this.clientSocket = this;
    System.out.println("Client[port:" + clientSocket.getLocalPort() + "]" +" is connected to the server. Please login with username.");
  }

  /**
   * handle message output and client disconnection
   */
  static class MyRunnable implements Runnable {

    private BufferedReader bufferedReader;

    /**
     * constructor
     * @throws IOException invalid input
     */
    MyRunnable() throws IOException {
      this.bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * override run function
     */
    @Override
    public void run() {
      try {
        while (true) {
          String readIn = bufferedReader.readLine();
          if (DISCONNECT_SIGNAL.equals(readIn) || readIn == null) {
            System.out.println("Client[port:" + clientSocket.getLocalPort() + "]" + " is disconnected");
            break;
          } else {
            System.out.println(readIn);
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
        try {
          bufferedReader.close();
          clientSocket.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
  }

  /**
   * main function of client
   * @param args args
   */
  public static void main(String[] args) {
    try {
      ClientMain client = new ClientMain();
      client.outputStream = client.getOutputStream();
      new Thread(new MyRunnable()).start();

      while(true) {
        outputStream.write((new BufferedReader(new InputStreamReader(System.in)).readLine() + "\n").getBytes());
        outputStream.flush();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

