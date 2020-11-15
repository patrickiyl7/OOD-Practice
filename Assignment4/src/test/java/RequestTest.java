import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RequestTest {
  Group C = new Group("C", null, 0, null);
  GroupAttendee A = new GroupAttendee("A", false, C, "leader");
  GroupAttendee B = new GroupAttendee("B", false, C, "member");

  Request request;

  @Before
  public void setUp() throws Exception {
    request = new Request("Group", 10, 0, "A", C, null);
  }

  @Test
  public void getRequestType() {
    Assert.assertEquals(request.getRequestType(), "Group");
  }

  @Test
  public void getNumRegularSeats() {
    Assert.assertSame(request.getNumRegularSeats(), 10);
  }

  @Test
  public void getNumWheelAccessibilitySeats() {
    Assert.assertSame(request.getNumWheelAccessibilitySeats(), 0);
  }

  @Test
  public void getContactPersonUserName() {
    Assert.assertSame(request.getContactPersonUserName(), "A");
  }

  @Test
  public void getGroup() {
    Assert.assertEquals(request.getGroup(), C);
  }

  @Test
  public void getIndividualAttendee() {
    Assert.assertEquals(request.getIndividualAttendee(), null);
  }
}