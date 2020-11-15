import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SlothropTest {
  Slothrop slothropWardrobe = new Slothrop(72, 36, 0, new String[]{"brown", "black"});
  Slothrop slothropHalf = new Slothrop(36, 36, 0, new String[]{"brown", "black"});

  @Test
  public void doorHandleRequirement() {
    Assert.assertEquals(slothropWardrobe.doorHandleRequirement(), false);
  }

  @Test
  public void drawerHandleRequirement() {
    Assert.assertEquals(slothropWardrobe.drawerHandleRequirement(), false);
  }

  @Test
  public void doorDrawerColorGeneration() {
    Assert.assertArrayEquals(slothropWardrobe.doorDrawerColorGeneration(), new String[]{"brown", "black"});
  }
}