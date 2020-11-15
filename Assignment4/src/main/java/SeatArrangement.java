import java.util.List;

/**
 * Seat arrangement Class.
 */
public class SeatArrangement {

  Request request;
  Venue venue;

  /**
   * Constructor of Seat arrangement class.
   * @param request request
   * @param venue venue
   */
  public SeatArrangement(Request request, Venue venue) {
    this.request = request;
    this.venue = venue;
  }

  /**
   * function to arrange the seat according to request type
   * and return certain print messages.
   * @return if the arrangement is successful.
   */
  public boolean arrangeSeat() {
    String requestType = request.getRequestType();
    String leaderName = request.getContactPersonUserName();
    if (venue.remainSeatOverAll() == 0 && venue.compromisedSeatArrangement() == 0) {
      if (requestType == "Group") {
        System.out.println("Hi, leader " + leaderName + "The Venue is full. Please come next time");
      } else {
        System.out.println("Hi, " + "The Venue is full. Please come next time");
      }
      return false;
    }
    int regularSeatReq = request.getNumRegularSeats();
    int wheelAccessibilitySeatReq = request.getNumWheelAccessibilitySeats();

    int regularSeatFulfill = 0;
    int wheelAccessibilitySeatFulfill = 0;
    if (requestType == "group") {
      Group group = request.getGroup();
      int regularSeatArrangementStartPoint = group.numWheelAccessibility;
      boolean resWCASeat = arrangeWheelChairAccessibilitySeat(wheelAccessibilitySeatReq, wheelAccessibilitySeatFulfill, venue, group);
      boolean resRegular = arrangeRegularSeat(regularSeatReq, regularSeatFulfill, venue, group, regularSeatArrangementStartPoint);
      if(resWCASeat && resRegular)
      {
        System.out.println("Hi, leader: " + leaderName + ", the seat arrangement is complete and successful.");
        return true;
      }
      else
      {
        return false;
      }
    } else {
      if (regularSeatReq == 1) {
        for (int i = 0; i < venue.getNumSectionRow(); i++) {
          for (int j = 0; j < venue.getNumSectionCol(); j++) {
            Section currSection = venue.getSections()[i][j];
            for(int m = 0; m < currSection.getRowCapacity(); m++) {
              for (int n = 0; n < currSection.getColCapacity(); n++) {
                Seat currSeat = currSection.getSeat()[m][n];
                if (currSeat.getAvailable()) {
                  currSeat.setAvailable(false);
                  currSeat.setIndividualAttendee(request.getIndividualAttendee());
                  return true;
                }

              }
            }
          }
        }
      }
      else if(wheelAccessibilitySeatReq == 1)
      {
        for (int i = 0; i < venue.getNumSectionRow(); i++) {
          for (int j = 0; j < venue.getNumSectionCol(); j++) {
            Section currSection = venue.getSections()[i][j];
            for (int n = 0; n < currSection.getColCapacity(); n++) {
              Seat currSeat = currSection.getSeat()[0][n];
              if (currSeat.getAvailable()) {
                currSeat.setAvailable(false);
                currSeat.setIndividualAttendee(request.getIndividualAttendee());
                return true;
              }
            }
          }
        }
      }
    }

    return false;
  }

  /**
   * arrangeWheelChairAccessibilitySeat
   * @param wheelAccessibilitySeatReq wheelAccessibilitySeatReq
   * @param wheelAccessibilitySeatFulfill wheelAccessibilitySeatFulfill
   * @param venue venue
   * @param group group
   * @return if the arrangement is successful.
   */
  public boolean arrangeWheelChairAccessibilitySeat(int wheelAccessibilitySeatReq,
      int wheelAccessibilitySeatFulfill, Venue venue, Group group) {
    for (int i = 0; i < venue.getNumSectionRow(); i++) {
      for (int j = 0; j < venue.getNumSectionCol(); j++) {
        if (wheelAccessibilitySeatFulfill == wheelAccessibilitySeatReq) {
          return true;
        }
        Section currSection = venue.getSections()[i][j];
        for (int n = 0; n < currSection.getColCapacity(); n++) {
          Seat currSeat = currSection.getSeat()[0][n];
          if (currSeat.getAvailable()) {
            currSeat.setAvailable(false);
            currSeat.setGroupAttendee(group.groupAttendeeList.get(wheelAccessibilitySeatFulfill));
            wheelAccessibilitySeatFulfill++;
            if (wheelAccessibilitySeatFulfill == wheelAccessibilitySeatReq) {
              break;
            }
          }
        }
      }
    }
    System.out.println("Hi, leader: " + group.groupLeader.getUserName() + ", the seat arrangement is complete but " + (wheelAccessibilitySeatReq - wheelAccessibilitySeatFulfill) + " wheelchair accessibility seats arrangement unsuccessful");
    return false;
  }

  /**
   * arrangeRegularSeat
   * @param regularSeatReq regularSeatReq
   * @param regularSeatFulfill regularSeatFulfill
   * @param venue venue
   * @param group group
   * @param regularSeatArrangementStartPoint regularSeatArrangementStartPoint
   * @return if the arrangement is successful.
   */
  public boolean arrangeRegularSeat(int regularSeatReq,
      int regularSeatFulfill, Venue venue, Group group, int regularSeatArrangementStartPoint) {
    for (int i = 0; i < venue.getNumSectionRow(); i++) {
      for (int j = 0; j < venue.getNumSectionCol(); j++) {
        if (regularSeatReq == regularSeatFulfill) {
          return true;
        }
        Section currSection = venue.getSections()[i][j];
        for(int m = 0; m < currSection.getRowCapacity(); m++) {
          if (regularSeatFulfill == regularSeatReq) {
            break;
          }
          for (int n = 0; n < currSection.getColCapacity(); n++) {
            Seat currSeat = currSection.getSeat()[m][n];
            if (currSeat.getAvailable()) {
              currSeat.setAvailable(false);
              currSeat
                  .setGroupAttendee(group.groupAttendeeList.get(regularSeatArrangementStartPoint));
              regularSeatFulfill++;
              if (regularSeatFulfill == regularSeatReq) {
                break;
              }
            }

          }
        }
      }
    }
    System.out.println("Hi, leader: " + group.groupLeader.getUserName() + ", the seat arrangement is complete but " + (regularSeatReq - regularSeatFulfill) + " regular seats arrangement unsuccessful");

    return false;

  }



}
