import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IndividualAttendeeTest {
  IndividualAttendee individualAttendee;
  @Before
  public void setUp() throws Exception {
    individualAttendee = new IndividualAttendee("A", false, "a");

  }

  @Test
  public void getPreferredName() {
    Assert.assertSame(individualAttendee.getPreferredName(), "a");
  }

  @Test
  public void setPreferredName() {
    individualAttendee.setPreferredName("a");
    Assert.assertSame(individualAttendee.getPreferredName(), "a");
  }
}