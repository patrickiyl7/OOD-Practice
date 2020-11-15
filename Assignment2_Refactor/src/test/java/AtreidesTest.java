import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AtreidesTest {
  Atreides atreidesHalf;
  Atreides atreidesQuarter;
  @Before
  public void setUp() throws Exception {
    atreidesHalf = new Atreides(36, 36, 16);
    atreidesQuarter = new Atreides(18, 36, 16);
  }

  @Test
  public void feetSuggestion() {
    Assert.assertEquals(atreidesHalf.feetSuggestion(true, 36), "Optional");
    Assert.assertEquals(atreidesQuarter.feetSuggestion(true, 18), "Required");

  }

  @Test
  public void railSuggestion() {
    Assert.assertEquals(atreidesHalf.isWallMounted, true);
  }

  @Test
  public void colorGeneration() {
    Assert.assertArrayEquals(atreidesHalf.color, new String[]{"brown", "bone"});
  }
}