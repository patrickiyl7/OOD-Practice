import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class InnerDataTest {
  InnerData innerData = new InnerData("a", null);
  @Test
  public void getData() {
    Assert.assertEquals(innerData.getData(), null);
  }
}