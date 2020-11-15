import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class GagaDrawerTest {
  GagaDrawer gagaDrawerQuarter = new GagaDrawer(18,36,0, new String[]{"brown", "black", "bone", "oxblood"});
  @Test
  public void doorHandleRequirement() {
    Assert.assertEquals(gagaDrawerQuarter.doorHandleRequirement(), false);
  }

  @Test
  public void drawerHandleRequirement() {
    Assert.assertEquals(gagaDrawerQuarter.drawerHandleRequirement(), true);
  }

  @Test
  public void doorDrawerColorGeneration() {
    Assert.assertArrayEquals(gagaDrawerQuarter.doorDrawerColorGeneration(), new String[]{"brown", "black", "bone", "oxblood"});
  }
}