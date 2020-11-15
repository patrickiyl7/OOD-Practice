import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeatTest {
  Seat seatTest;

  @Before
  public void setUp() throws Exception {
    seatTest = new Seat("regular", 1, 1);
  }

  @Test
  public void getGroupAttendee() {
    Assert.assertEquals(seatTest.getGroupAttendee(), null);
  }

  @Test
  public void setGroupAttendee() {
    seatTest.setGroupAttendee(null);
    Assert.assertEquals(seatTest.getGroupAttendee(), null);
  }

  @Test
  public void getIndividualAttendee() {
    Assert.assertEquals(seatTest.getIndividualAttendee(), null);
  }

  @Test
  public void setIndividualAttendee() {
    seatTest.setIndividualAttendee(null);
    Assert.assertEquals(seatTest.getIndividualAttendee(), null);
  }

  @Test
  public void getSeatType() {
    Assert.assertEquals(seatTest.getSeatType(), "regular");
  }

  @Test
  public void getAvailable() {
    Assert.assertEquals(seatTest.getAvailable(), true);
  }

  @Test
  public void setAvailable() {
    seatTest.setAvailable(true);
    Assert.assertEquals(seatTest.getAvailable(), true);
  }

  @Test
  public void printSeats() {
    seatTest.printSeats();
    Assert.assertEquals(seatTest.getCanCancel(), false);
    Assert.assertEquals(seatTest.getAvailable(), false);
  }

  @Test
  public void getCanCancel() {
    Assert.assertEquals(seatTest.getCanCancel(), true);
  }

  @Test
  public void setCanCancel() {
    seatTest.setCanCancel(true);
    Assert.assertEquals(seatTest.getCanCancel(), true);
  }

  @Test
  public void seatCancellation() {
    seatTest.seatCancellation(true);
    Assert.assertEquals(seatTest.getAvailable(), true);
    Assert.assertEquals(seatTest.getGroupAttendee(), null);
    Assert.assertEquals(seatTest.getIndividualAttendee(), null);
  }

  @Test
  public void seatCantCancellation() {
    seatTest.setCanCancel(false);
    seatTest.seatCancellation(false);
  }

}