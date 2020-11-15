import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
  private Group groupTest = new Group("NEU", null, 0, null);
  private GroupAttendee groupAttendeeTest = new GroupAttendee("A", false, groupTest, "member");

  @Test
  public void getWheelChairAccessibility() {
    Assert.assertEquals(groupAttendeeTest.getWheelChairAccessibility(), false);

  }

  @Test
  public void getUserName() {
    Assert.assertEquals(groupAttendeeTest.getUserName(), "A");
  }
}