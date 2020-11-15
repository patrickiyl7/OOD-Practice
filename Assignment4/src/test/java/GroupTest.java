import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroupTest {
  private Group groupTest;
  @Before
  public void setUp() throws Exception {
    groupTest = new Group("NEU", null, 0, null);
  }

  @Test
  public void getGroupName() {
    Assert.assertEquals(groupTest.getGroupName(), "NEU");
  }

  @Test
  public void setGroupName() {
    groupTest.setGroupName("NEU");
    Assert.assertEquals(groupTest.getGroupName(), "NEU");
  }

  @Test
  public void getGroupLeader() {
    Assert.assertEquals(groupTest.getGroupLeader(), null);
  }

  @Test
  public void setGroupLeader() {
    groupTest.setGroupLeader(null);
    Assert.assertEquals(groupTest.getGroupLeader(), null);
  }
}