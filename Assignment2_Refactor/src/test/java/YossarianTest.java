import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class YossarianTest {
  Yossarian yossarianWardrobe = new Yossarian(72, 36, 16);
  Yossarian yossarianHalf = new Yossarian(36, 36, 16);
  Yossarian yossarianQuarter = new Yossarian(18, 36, 16);

  @Test
  public void feetSuggestion() {
    Assert.assertEquals(yossarianWardrobe.feetSuggestion(true, 72), "Not Required");
    Assert.assertEquals(yossarianHalf.feetSuggestion(true, 36), "Optional");
    Assert.assertEquals(yossarianQuarter.feetSuggestion(true, 18), "Required");
  }

  @Test
  public void railSuggestion() {
    Assert.assertEquals(yossarianWardrobe.railSuggestion(false), "Not required");
    Assert.assertEquals(yossarianHalf.railSuggestion(true), "Standard wall mount rail required.");
  }

  @Test
  public void colorGeneration() {
    Assert.assertArrayEquals(yossarianWardrobe.colorGeneration(72), new String[]{"brown", "black", "bone", "oxblood"});
    Assert.assertArrayEquals(yossarianHalf.colorGeneration(36), new String[]{"brown", "black", "bone"});
  }
}