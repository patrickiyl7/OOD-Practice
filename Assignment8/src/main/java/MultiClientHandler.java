import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Class of MultiClienHandler
 *
 */
public class MultiClientHandler implements Runnable {

  private final Socket clientSocket;
  private ArrayList<MultiClientHandler> clientList = new ArrayList<>();
  private Boolean connectStatus = false;
  private String userName = null;
  private final Integer CONNECT_MESSAGE = 19;
  private final Integer CONNECT_RESPONSE = 20;
  private final Integer DISCONNECT_MESSAGE = 21;
  private final Integer QUERY_CONNECTED_USERS = 22;
  private final Integer QUERY_USER_RESPONSE = 23;
  private final Integer BROADCAST_MESSAGE = 24;
  private final Integer DIRECT_MESSAGE = 25;
  private final Integer FAILED_MESSAGE = 26;
  private final Integer SEND_INSULT = 27;
  public MultiClientHandler(Socket clientSocket, ArrayList<MultiClientHandler> clientList) {
    this.clientSocket = clientSocket;
    this.clientList = clientList;
  }

  /**
   * wrapped function of override run();
   */
  @Override
  public void run() {
    try {
      handleCommand();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * function to handle the command.
   * @throws IOException invalid input
   */
  private void handleCommand() throws IOException {
    InputStream inputStream = clientSocket.getInputStream();
    OutputStream outputStream = clientSocket.getOutputStream();

    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String line;
    while ((line = reader.readLine()) != null) {
      String[] tokens = line.split(" ");
      if (tokens != null && tokens.length > 0) {
        ProtocolFrame protocolFrame = null;
        if(tokens.length > 1)
        {
          protocolFrame = new ProtocolFrame(tokens[1].length(), tokens[1].getBytes());
        }
        String command = tokens[0];
        System.out.println(command);
        if (command.equals("logoff")) {
          if(protocolFrame != null)
          {
            protocolFrame.setMessageIdentifier(DISCONNECT_MESSAGE);
          }
          System.out.println("reached");
          Disconnect(tokens, outputStream);
          break;
        } else if (command.equals("login")) {
          if(protocolFrame != null)
          {
            protocolFrame.setMessageIdentifier(CONNECT_MESSAGE);
          }
          Connect(outputStream, tokens);
        }
        else if (command.equals("who")) {
          if(protocolFrame != null)
          {
            protocolFrame.setMessageIdentifier(QUERY_CONNECTED_USERS);
          }
          Query(outputStream);
        }
        else if (command.equals("@user")) {
          if(protocolFrame != null)
          {
            protocolFrame.setMessageIdentifier(DIRECT_MESSAGE);
          }
          DirectMessage(tokens);
        }
        else if (command.equals("@all")) {
          if(protocolFrame != null)
          {
            protocolFrame.setMessageIdentifier(BROADCAST_MESSAGE);
          }
          BroadcastMessage(tokens, userName);
        }
        else if (command.equals("!user")) {
          if(protocolFrame != null)
          {
            protocolFrame.setMessageIdentifier(SEND_INSULT);
          }
          GrammarProcessor grammarProcessor = new GrammarProcessor();
          String msg = grammarProcessor.processor1();
          String receiver = tokens[1];
          for(MultiClientHandler client : clientList) {
            if (client.getUserName().equals(receiver)) {
              String directMsg = "insult msg from " + userName + ": " + msg + "\n";
              client.clientSocket.getOutputStream().write(directMsg.getBytes());
            }
          }
        }
          else {
          String msg = "unknown " + command + "\n";
          outputStream.write(msg.getBytes());
          msg = "Tips on commands: logoff, who, @user, @all, !user "  + "\n";
          outputStream.write(msg.getBytes());
        }
      }
    }
    clientSocket.close();
  }

  private void Disconnect(String[] tokens, OutputStream outputStream) throws IOException {
    clientSocket.close();
    System.out.println("reached1");
    String msg;
    if(clientSocket.isClosed())
    {
      System.out.println("reached2");
      clientList.remove(this);
      connectStatus = false;
      System.out.println("reached3");
      if(tokens.length > 1)
      {
        System.out.println("reached4");
        msg = "(Message Identifier: " + CONNECT_RESPONSE + ") " +  tokens[1] + ": No longer connected.";
      }
      else
      {
        msg = "(Message Identifier: " + CONNECT_RESPONSE + ") " + "Unknown user: No longer connected.";
      }
      outputStream.write(msg.getBytes());
    }
    else
    {
      msg = "(Message Identifier: " + CONNECT_RESPONSE + ")" +  " You didn't logoff successfully";
      System.out.println(msg);
    }
  }

  /**
   * method to handle user connection.
   * @param outputStream outputStream
   * @param tokens tokens
   * @throws IOException invalid input
   */
  private void Connect(OutputStream outputStream, String[] tokens) throws IOException {
    String msg;
    if(tokens.length > 1 && connectStatus == false)
    {
      this.userName = tokens[1];
      msg = "(Message Identifier: " + CONNECT_RESPONSE + ")" +  " User logged in successfully: " + userName;
      System.out.println(msg);
      outputStream.write(msg.getBytes());
      outputStream.write('\n');
      int onlineUserCount = 0;
      for(MultiClientHandler client : clientList) {
        if (client.getConnectStatus()) {
          onlineUserCount++;
          }
        }
      String msg2 = "There are " + onlineUserCount + " other connected clients";
      outputStream.write(msg2.getBytes());
      outputStream.write('\n');
      connectStatus = true;
      }
    else
    {
      msg = "(Message Identifier: " + CONNECT_RESPONSE + ")" +  " You didn't login successfully";
      System.out.println(msg);
      outputStream.write(msg.getBytes());
      outputStream.write('\n');
    }
  }

  /**
   * method to handle query command
   * @param outputStream outputStream
   * @throws IOException invalid input
   */
  private void Query(OutputStream outputStream) throws IOException {
    int count = 0;
    for(MultiClientHandler client : clientList) {
      if (client.getConnectStatus()) {
        if (!userName.equals(client.getUserName())) {
          String msg = "online: " + client.getUserName() + "\n";
          outputStream.write(msg.getBytes());
          count++;
        }
      }
    }
    if(count == 0)
    {
      String msg3 = "No other online users." + "\n";
      outputStream.write(msg3.getBytes());
    }
  }

  /**
   * method to handle directMessage function
   * @param tokens command
   * @throws IOException invalid input
   */
  private void DirectMessage(String[] tokens) throws IOException {
    String receiver = tokens[1];
    StringBuilder content = new StringBuilder();
    for(int i = 2; i < tokens.length; i++)
    {
      content.append(tokens[i]);
      if(i != tokens.length - 1)
      {
        content.append(" ");
      }
    }

    for(MultiClientHandler client : clientList) {
      if (client.getUserName().equals(receiver)) {
        String directMsg = "msg from " + userName + ": " + content.toString() + "\n";
        client.clientSocket.getOutputStream().write(directMsg.getBytes());
      }
    }
  }

  /**
   * method to handle broadcastMessage function
   * @param tokens command
   * @param userName userName
   * @throws IOException invalid input
   */
  private void BroadcastMessage(String[] tokens, String userName) throws IOException {
    StringBuilder content = new StringBuilder();
    for(int i = 1; i < tokens.length; i++)
    {
      content.append(tokens[i]);
      if(i != tokens.length - 1)
      {
        content.append(" ");
      }
    }
    for(MultiClientHandler client : clientList) {
      if (!client.getUserName().equals(userName)) {
        String directMsg = "msg from " + userName + ": " + content.toString() + "\n";
        client.clientSocket.getOutputStream().write(directMsg.getBytes());
      }
    }
  }

  /**
   * connection status getter
   * @return connection status
   */
  public Boolean getConnectStatus() {
    return connectStatus;
  }

  /**
   * userName getter
   * @return userName
   */
  public String getUserName() {
    return userName;
  }

}
