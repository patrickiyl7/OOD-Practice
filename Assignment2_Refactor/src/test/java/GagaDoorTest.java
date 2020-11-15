import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class GagaDoorTest {
  GagaDoor gagaDoorQuater = new GagaDoor(18, 38, 0,
      new String[]{"brown", "black", "bone", "oxblood"});
  GagaDoor gagaDoorHalf = new GagaDoor(36, 38, 0,
      new String[]{"brown", "black", "bone", "oxblood"});
  @Test
  public void doorHandleRequirement() {
    Assert.assertEquals(gagaDoorQuater.doorHandleRequirement(), true);
  }

  @Test
  public void drawerHandleRequirement() {
    Assert.assertEquals(gagaDoorQuater.drawerHandleRequirement(), false);
  }

  @Test
  public void doorDrawerColorGeneration() {
    Assert.assertArrayEquals(gagaDoorQuater.color, new String[]{"brown", "black", "bone", "oxblood"});
  }
}