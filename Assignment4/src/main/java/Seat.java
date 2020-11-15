/**
 * Class of Seat.
 */
public class Seat {
  private String seatType;
  private Integer seatRowNum;
  private Integer seatColNum;
  private GroupAttendee groupAttendee;
  private IndividualAttendee individualAttendee;
  private Boolean isAvailable;
  private Boolean canCancel;

  /**
   * Constructor of Seat Class.
   * @param seatType seatType
   * @param seatRowNum seatRowNum
   * @param seatColNum seatColNum
   */
  public Seat(String seatType, Integer seatRowNum, Integer seatColNum) {
    this.seatType = seatType;
    this.seatRowNum = seatRowNum;
    this.seatColNum = seatColNum;
    this.groupAttendee = null;
    this.individualAttendee = null;
    this.isAvailable = true;
    this.canCancel = true;
  }

  /**
   * groupAttendee getter
   * @return groupAttendee
   */
  public GroupAttendee getGroupAttendee() {
    return groupAttendee;
  }

  /**
   * groupAttendee setter
   * @param groupAttendee groupAttendee
   */
  public void setGroupAttendee(GroupAttendee groupAttendee) {
    this.groupAttendee = groupAttendee;
  }

  /**
   * individualAttendee getter
   * @return individualAttendee
   */
  public IndividualAttendee getIndividualAttendee() {
    return individualAttendee;
  }

  /**
   * individualAttendee setter
   * @param individualAttendee individualAttendee
   */
  public void setIndividualAttendee(IndividualAttendee individualAttendee) {
    this.individualAttendee = individualAttendee;
  }

  /**
   * seat type getter
   * @return seatType
   */
  public String getSeatType() {
    return seatType;
  }

  /**
   * check the seat is available
   * @return if the seat is available in boolean type.
   */
  public Boolean getAvailable() {
    return isAvailable;
  }

  /**
   * set if the seat is available
   * @param available available
   */
  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  /**
   * method of printSeats, a checking in process.
   */
  public void printSeats()
  {
    this.canCancel = false;
    this.isAvailable = false;
    System.out.println("Seat PRINT request received. You have confirmed the seat assignation and can't re-select or cancel this arrangement. Thank you");
  }

  /**
   * a method to cancel the current seat reservation.
   * @param canCancel canCancel
   */
  public void seatCancellation(boolean canCancel)
  {
    if(this.canCancel)
    {
      this.isAvailable = true;
      this.groupAttendee = null;
      this.individualAttendee = null;
      System.out.println("Your seat selection has been cancelled");
    }
    else
    {
      System.out.println("You have confirmed the seat assignation and can't re-select or cancel this arrangement. Thank you");
    }
  }

  /**
   * a method to get the canCancel value.
   * @return canCancel
   */
  public Boolean getCanCancel() {
    return canCancel;
  }

  /**
   * a method to set the canCancel value.
   * @param canCancel canCancel
   */
  public void setCanCancel(Boolean canCancel) {
    this.canCancel = canCancel;
  }
}
