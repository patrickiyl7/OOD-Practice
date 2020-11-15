/**
 * Class of Request.
 */
public class Request {
  private String requestType;
  private Integer numRegularSeats;
  private Integer numWheelAccessibilitySeats;
  private String contactPersonUserName;
  private Group group;
  private IndividualAttendee individualAttendee;

  /**
   * Constructor of class Request
   * @param requestType requestType
   * @param numRegularSeats numRegularSeats
   * @param numWheelAccessibilitySeats numWheelAccessibilitySeats
   * @param contactPersonUserName contactPersonUserName
   * @param group group
   * @param individualAttendee individualAttendee
   */
  public Request(String requestType, Integer numRegularSeats,
      Integer numWheelAccessibilitySeats, String contactPersonUserName, Group group, IndividualAttendee individualAttendee) {
    this.requestType = requestType;
    this.numRegularSeats = numRegularSeats;
    this.numWheelAccessibilitySeats = numWheelAccessibilitySeats;
    this.contactPersonUserName = contactPersonUserName;
    this.group = group;
    this.individualAttendee = individualAttendee;
  }

  /**
   * Request Type getter.
   * @return request type.
   */
  public String getRequestType() {
    return requestType;
  }

  /**
   * number of regular seats getter
   * @return numRegularSeats numRegularSeats
   */
  public Integer getNumRegularSeats() {
    return numRegularSeats;
  }

  /**
   * number of wheel chair accessibility seats getter
   * @return numWheelAccessibilitySeats numWheelAccessibilitySeats
   */
  public Integer getNumWheelAccessibilitySeats() {
    return numWheelAccessibilitySeats;
  }

  /**
   * ContactPersonUserName getter
   * @return ContactPersonUserName ContactPersonUserName
   */
  public String getContactPersonUserName() {
    return contactPersonUserName;
  }

  /**
   * group getter
   * @return group group
   */
  public Group getGroup() {
    return group;
  }

  /**
   * individualAttendee getter
   * @return individualAttendee individualAttendee
   */
  public IndividualAttendee getIndividualAttendee() {
    return individualAttendee;
  }
}