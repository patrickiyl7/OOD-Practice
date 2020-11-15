package assignment1.problem1;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.rules.*;
import org.junit.Assert.*;

public class DepositTest {

  private Deposit failDeposit1;
  private Deposit failDeposit2;
  private Deposit successDeposit1;

  @org.junit.Rule
  public ExpectedException thrown1 = ExpectedException.none();

  @org.junit.Test
  public void DepositDollarExceptionTest() throws Exception {
    thrown1.expect(Exception.class);
    thrown1.expectMessage("Deposit amount is larger than fifty");
    this.failDeposit1 = new Deposit("Patrick", "Li", 52, 0);
  }

  @org.junit.Rule
  public ExpectedException thrown2 = ExpectedException.none();

  @org.junit.Test
  public void DepositCentExceptionTest() throws Exception {
    thrown2.expect(Exception.class);
    thrown2.expectMessage("Cent amount is less than zero");
    this.failDeposit2 = new Deposit("Tom", "Li", 40, -10);
  }

  @org.junit.Before
  public void setUp() throws Exception {
    this.successDeposit1 = new Deposit("Jack", "A", 35, 67);
  }

  @org.junit.Rule
  public ExpectedException thrown3 = ExpectedException.none();

  @org.junit.Test
  public void getFirstName() {
    thrown3.expect(NullPointerException.class);
    Assert.assertEquals("Patrick", this.failDeposit1.getFirstName());
  }

  @org.junit.Test
  public void setFirstName() {
  }

  @org.junit.Test
  public void getLastName() {
    Assert.assertEquals("A", this.successDeposit1.getLastName());
  }

  @org.junit.Test
  public void setLastName() {
  }

  @org.junit.Test
  public void getDollarAmount() {
    Assert.assertEquals(new Integer(35), this.successDeposit1.getDollarAmount());
  }

  @org.junit.Test
  public void setDollarAmount() {
  }

  @org.junit.Test
  public void getCentAmount() {
    Assert.assertEquals(new Integer(67), this.successDeposit1.getCentAmount());

  }

  @org.junit.Test
  public void setCentAmount() {

  }


}