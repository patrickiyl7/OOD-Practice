/**
 * Section class.
 */
public class Section {

  private Integer sectionRowId;
  private Integer sectionColId;
  private Integer rowCapacity;
  private Integer colCapacity;
  private Seat[][] seat;

  /**
   * Constructor of Section.
   * @param sectionRowId sectionRowId
   * @param sectionColId sectionColId
   * @param rowCapacity rowCapacity
   * @param colCapacity colCapacity
   */
  public Section(Integer sectionRowId, Integer sectionColId, Integer rowCapacity,
      Integer colCapacity) {
    this.sectionRowId = sectionRowId;
    this.sectionColId = sectionColId;
    this.rowCapacity = rowCapacity;
    this.colCapacity = colCapacity;
    seat = new Seat[rowCapacity][rowCapacity];
    for (int i = 0; i < colCapacity; i++) {
      seat[0][i] = new Seat("WheelChairAccessibility", 0, i);
    }
    for (int i = 1; i < rowCapacity; i++) {
      for (int j = 0; j < colCapacity; j++) {
        seat[i][j] = new Seat("RegularSeat", i, j);
      }
    }
  }

  /**
   * rowCapacity getter
   * @return rowCapacity
   */
  public Integer getRowCapacity() {
    return rowCapacity;
  }

  /**
   * colCapacity getter
   * @return colCapacity
   */
  public Integer getColCapacity() {
    return colCapacity;
  }

  /**
   * seat getter
   * @return seat
   */
  public Seat[][] getSeat() {
    return seat;
  }

  /**
   * function to get the remain regular seat count.
   * @return remainRegularSeatCount
   */
  public int remainRegularSeatCount() {
    int res = 0;
    for (int i = 0; i < seat.length; i++) {
      for (int j = 0; j < seat[i].length; j++) {
        if (seat[i][j].getAvailable() && seat[i][j].getSeatType().equals("RegularSeat")) {
          res++;
        }
      }
    }
    return res;
  }

  /**
   * function to get the remain wheel accessibility seat count.
   * @return count of the remain wheel accessibility seats.
   */
  public int remainWheelAccessibilitySeatCount() {
    int res = 0;
    for (int i = 0; i < seat[0].length; i++) {
      if (seat[0][i].getAvailable() && seat[0][i].getSeatType().equals("WheelChairAccessibility")) {
        res++;
      }
    }
    return res;
  }

  /**
   * function to get the count of wheel accessibility seat assigned to person who doesn't need them.
   * @return count of wheel accessibility seat assigned to person who doesn't need them.
   */
  public int wheelChairSeatAssignedToNonWheelChairReqPerson() {
    int res = 0;
    for (int i = 0; i < seat.length; i++) {
      for (int j = 0; j < seat[i].length; j++) {
        if (!seat[i][j].getAvailable() && seat[i][j].getSeatType().equals("WheelChairAccessibility")) {
          if (seat[i][j].getGroupAttendee() != null) {
            if (!seat[i][j].getGroupAttendee().getWheelChairAccessibility()) {
              res++;
            }
          } else if (seat[i][j].getIndividualAttendee() != null) {
            if (!seat[i][j].getIndividualAttendee().getWheelChairAccessibility()) {
              res++;
            }
          }
        }
      }
    }
    return res;
  }

}
