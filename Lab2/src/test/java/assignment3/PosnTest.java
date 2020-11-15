package assignment3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PosnTest {

  private final Integer X = 1;
  private final Integer expectedX = 1;
  private final Integer Y = 7;
  private final Integer expectedY = 7;
  private final String notPosnClass = "This object belongs to String Class not Posn Class";
  private Posn posnExample;

  @Before
  public void setUp() throws Exception {
    posnExample = new Posn(X, Y);
  }

  @Test
  public void getX() {
    Assert.assertEquals(posnExample.getX(), expectedX);
  }

  @Test
  public void getY() {
    Assert.assertEquals(posnExample.getY(), expectedY);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(posnExample.equals(posnExample));
    Assert.assertFalse(posnExample.equals(null));
    Assert.assertFalse(posnExample.equals(notPosnClass));
    Posn oCastToPosn = new Posn(X, Y);
    Posn posnDifferentX = new Posn(X + 1, Y);
    Posn posnXIsNull = new Posn(null, Y);
    Posn posnYIsNull = new Posn(X, null);
    Assert.assertFalse(posnDifferentX.equals(oCastToPosn));
    Assert.assertFalse(oCastToPosn.equals(posnXIsNull));
    Assert.assertFalse(oCastToPosn.equals(posnYIsNull));
    Assert.assertFalse(oCastToPosn.equals(new Posn(null, null)));
    Assert.assertFalse(oCastToPosn.equals(new Posn(17, 23)));
    Assert.assertFalse(oCastToPosn.equals(new Posn(1, 23)));
    Assert.assertTrue(oCastToPosn.equals(posnExample));
    Posn posnTransitiveTest = new Posn(X, Y);
    Posn posnTransitiveTest2 = new Posn(X, Y);
    Assert.assertTrue(posnTransitiveTest.equals(posnTransitiveTest2));
    Posn posnTransitiveTest3 = new Posn(X, Y);
    Assert.assertTrue(posnTransitiveTest.equals(posnTransitiveTest3));
    Assert.assertTrue(posnExample.equals(posnExample));
    if (posnTransitiveTest.equals(posnTransitiveTest2)) {
      if (posnTransitiveTest2.equals(posnTransitiveTest3)) {
        Assert.assertTrue(posnTransitiveTest.equals(posnTransitiveTest3));
      }
    }
    Assert.assertTrue(posnTransitiveTest2.equals(posnTransitiveTest3) && posnTransitiveTest3
        .equals(posnTransitiveTest2));
    Assert.assertFalse(posnExample.equals(null));
    for (int i = 0; i < 1025; i++) {
      Assert.assertTrue(posnExample.equals(posnTransitiveTest2));
    }
  }

  @Test
  public void testHashCode() {
    Posn posnTest = new Posn(X, Y);
    for (int i = 0; i < 1025; i++) {
      Assert.assertTrue(posnTest.equals(posnTest));
    }
    if (posnExample.equals(posnTest)) {
      Assert.assertTrue(posnExample.hashCode() == posnTest.hashCode());
    }
    if (posnExample.equals(null)) {
      Assert.assertFalse(posnExample.hashCode() == posnTest.hashCode());
    }
    Assert.assertFalse(posnExample.hashCode() == new Posn(null, null).hashCode());
    Posn posnFailureTestCase = new Posn(3, Y);
    if (!posnExample.equals(posnFailureTestCase)) {
      Assert.assertFalse(posnExample.hashCode() == posnFailureTestCase.hashCode());
    }
  }

  @Test
  public void testToString() {
    String expectedString = "Posn{" + "x=" + X + ", y=" + Y + '}';
    Assert.assertEquals(posnExample.toString(), expectedString);
  }
}