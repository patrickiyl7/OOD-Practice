/**
 * Class of ProtocolFrame
 */
public class ProtocolFrame {
  Integer messageIdentifier;
  Integer usernameSize;
  byte[] username;

  /**
   * Constructor of ProtocolFrame Class
   * @param usernameSize usernameSize
   * @param username userName
   */
  public ProtocolFrame(Integer usernameSize, byte[] username) {
    this.messageIdentifier = 0;
    this.usernameSize = usernameSize;
    this.username = username;
  }

  /**
   * messageIdentifier setter
   * @param messageIdentifier messageIdentifier
   */
  public void setMessageIdentifier(Integer messageIdentifier) {
    this.messageIdentifier = messageIdentifier;
  }

}
