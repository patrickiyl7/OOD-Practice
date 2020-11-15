package assignment1.problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.*;

public class CurrentBalanceTest {

  private CurrentBalance failBalance1;
  private CurrentBalance failBalance2;
  private CurrentBalance successBalance1;

  @org.junit.Rule
  public ExpectedException thrown1 = ExpectedException.none();

  @org.junit.Test
  public void BalanceDollarExceptionTest() {
    thrown1.expect(Exception.class);
    thrown1.expectMessage("Card balance is less than zero");
    this.failBalance1 = new CurrentBalance(-1, 10);
  }

  @org.junit.Rule
  public ExpectedException thrown2 = ExpectedException.none();

  @org.junit.Test
  public void BalanceCentExceptionTest() {
    thrown2.expect(Exception.class);
    thrown2.expectMessage("Cent amount is too large");
    this.failBalance2 = new CurrentBalance(10, 100);
  }

  @Before
  public void setUp() throws Exception {
    this.successBalance1 = new CurrentBalance(100, 35);
  }

  @Test
  public void getDollarAmount() {
    Assert.assertEquals(new Integer(100), this.successBalance1.getDollarAmount());
  }

  @Test
  public void setDollarAmount() {
  }

  @Test
  public void getCentAmount() {
    Assert.assertEquals(new Integer(35), this.successBalance1.getCentAmount());
  }

  @Test
  public void setCentAmount() {
  }
}