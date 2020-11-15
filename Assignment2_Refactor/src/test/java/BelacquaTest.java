import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BelacquaTest {

  Belacqua belacquaWardrobe = new Belacqua(72, 36, 0, new String[]{"bone", "oxblood"});
  Belacqua belacquaHalf = new Belacqua(36, 36, 0, new String[]{"bone", "oxblood"});
  Belacqua belacquaQuater = new Belacqua(18, 36, 0, new String[]{"bone", "oxblood"});

  @Test
  public void doorHandleRequirement() {
    Assert.assertEquals(belacquaWardrobe.doorHandleRequirement(), false);
  }

  @Test
  public void drawerHandleRequirement() {
    Assert.assertEquals(belacquaWardrobe.drawerHandleRequirement(), false);
  }

  @Test
  public void doorDrawerColorGeneration() {
    Assert.assertArrayEquals(belacquaWardrobe.doorDrawerColorGeneration(), new String[]{"brown", "black"});
  }
}