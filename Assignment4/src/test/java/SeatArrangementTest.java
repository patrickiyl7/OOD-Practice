import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeatArrangementTest {
  SeatArrangement seatArrangement;
  SeatArrangement seatArrangement1;
  Venue venue;
  Request request;
  Request individualRequest;
  Group C;
  GroupAttendee L;
  IndividualAttendee individualAttendee;
  @Before
  public void setUp() throws Exception {

    venue = new Venue(2, 2, 10, 10);
    GroupAttendee L = new GroupAttendee("B", false, C, "leader");
    individualAttendee = new IndividualAttendee("M", true, "M");
    C = new Group("C", new ArrayList<>(), 10, L);
    C.groupAttendeeList.add(L);
    for(int i = 0; i < 10; i++)
    {
      C.groupAttendeeList.add(new GroupAttendee("A", true, C, "member"));
    }
    for(int i = 0; i < 10; i++)
    {
      C.groupAttendeeList.add(new GroupAttendee("A", false, C, "member"));
    }
    request = new Request("group", 10, 10, "B", C, null);
    individualRequest = new Request("individual", 1, 0, "M", null, individualAttendee);

    seatArrangement = new SeatArrangement(request, venue);
    seatArrangement1 = new SeatArrangement(individualRequest, venue);
  }

  @Test
  public void arrangeSeat() {
    Assert.assertEquals(seatArrangement.arrangeSeat(), true);
    Assert.assertEquals(seatArrangement1.arrangeSeat(), true);
    individualRequest = new Request("individual", 0, 1, "M", null, individualAttendee);
    seatArrangement1 = new SeatArrangement(individualRequest, venue);
    Assert.assertEquals(seatArrangement1.arrangeSeat(), true);
  }

  @Test
  public void arrangeWheelChairAccessibilitySeat() {
    Assert.assertEquals(seatArrangement.arrangeWheelChairAccessibilitySeat(10, 0, venue, C), true);


  }

  @Test
  public void arrangeRegularSeat() {
    Assert.assertEquals(seatArrangement.arrangeRegularSeat(10, 0, venue, C, 10), true);

  }
}