import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SectionTest {
  Section sectionTest;
  private Integer rowCapacity = 10;
  private Integer colCapacity = 10;
  GroupAttendee A = new GroupAttendee("A", false, null, "leader");
  IndividualAttendee B = new IndividualAttendee("B", false, "B");
  @Before
  public void setUp() throws Exception {
    sectionTest = new Section(0, 0, 10, 10);
  }

  @Test
  public void getRowCapacity() {
    Assert.assertSame(10, sectionTest.getRowCapacity());
  }

  @Test
  public void getColCapacity() {
    Assert.assertSame(10, sectionTest.getColCapacity());
  }

  @Test
  public void getSeat() {

  }

  @Test
  public void remainRegularSeatCount() {
    Assert.assertSame(90, sectionTest.remainRegularSeatCount());
  }

  @Test
  public void remainWheelAccessibilitySeatCount() {
    Assert.assertSame(10, sectionTest.remainWheelAccessibilitySeatCount());

  }

  @Test
  public void wheelChairSeatAssignedToNonWheelChairReqPerson() {
    sectionTest.getSeat()[0][0].setAvailable(false);
    sectionTest.getSeat()[0][0].setGroupAttendee(A);
    Assert.assertSame(1, sectionTest.wheelChairSeatAssignedToNonWheelChairReqPerson());
    sectionTest.getSeat()[0][1].setAvailable(false);
    sectionTest.getSeat()[0][1].setIndividualAttendee(B);
    Assert.assertSame(2, sectionTest.wheelChairSeatAssignedToNonWheelChairReqPerson());
  }
}