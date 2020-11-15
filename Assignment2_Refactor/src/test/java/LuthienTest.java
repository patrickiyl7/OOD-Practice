import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class LuthienTest {

  Luthien luthienHalf;
  Luthien luthienQuarter;
  public LuthienTest() throws Exception {
    luthienHalf = new Luthien(36, 36, 18);
    luthienQuarter = new Luthien(18, 36, 18);
  }

  @Test
  public void feetSuggestion() {
    Assert.assertEquals(luthienHalf.feetSuggestion(true, 36), "Optional");
    Assert.assertEquals(luthienQuarter.feetSuggestion(true, 18), "Required");
  }

  @Test
  public void railSuggestion() {
    Assert.assertEquals(luthienHalf.isWallMounted, true);
  }

  @Test
  public void colorGeneration() {
    Assert.assertArrayEquals(luthienHalf.color, new String[]{"black", "bone"});
  }
}