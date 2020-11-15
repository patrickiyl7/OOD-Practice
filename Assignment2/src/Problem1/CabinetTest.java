package Problem1;

import static org.junit.Assert.*;

import org.junit.Assert;

public class CabinetTest {

  private Luthien luthien;
  @org.junit.Before
  public void setUp() throws Exception {
    luthien = new Luthien(36, 36, 18);
  }

  @org.junit.Test
  public void feetCalculate() {
    String feetRequirement = "Required";
    Assert.assertEquals(8, this.luthien.feetCalculate(5, feetRequirement));
  }
}