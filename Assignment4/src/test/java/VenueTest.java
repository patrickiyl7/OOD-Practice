import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VenueTest {
  Venue venue;

  @Before
  public void setUp() throws Exception {
    venue = new Venue(2, 2, 10, 10);
  }

  @Test
  public void getSections() {

  }

  @Test
  public void getNumSectionRow() {
    assertEquals(2, (int) venue.getNumSectionRow());
  }

  @Test
  public void getNumSectionCol() {
    assertEquals(2, (int) venue.getNumSectionCol());
  }

  @Test
  public void remainSeatOverAll() {
    assertEquals(400, (int) venue.remainSeatOverAll());
  }

  @Test
  public void compromisedSeatArrangement() {
    assertEquals(0, (int) venue.compromisedSeatArrangement());
  }
}