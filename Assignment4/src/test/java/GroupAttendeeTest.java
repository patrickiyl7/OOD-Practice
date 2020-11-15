import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroupAttendeeTest {
  private GroupAttendee groupAttendeeTest;
  private Group groupTest;
  @Before
  public void setUp() throws Exception {
    groupTest = new Group("NEU", null, 0, null);
    groupAttendeeTest = new GroupAttendee("A", false, groupTest, "member");
  }

  @Test
  public void getGroup() {
    Assert.assertEquals(groupAttendeeTest.getGroup(), groupTest);
  }

  @Test
  public void setGroup() {
    groupAttendeeTest.setGroup(groupTest);
    Assert.assertEquals(groupAttendeeTest.getGroup(), groupTest);
  }

  @Test
  public void getTitle() {
    Assert.assertEquals(groupAttendeeTest.getTitle(), "member");
  }

  @Test
  public void setTitle() {
    groupAttendeeTest.setTitle("member");
    Assert.assertEquals(groupAttendeeTest.getTitle(), "member");
  }
}