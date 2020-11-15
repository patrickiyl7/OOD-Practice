package assignment1.problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TransitCardTest {

  private TransitCard transitCard;
  private CardOwner cardOwner;
  private CurrentBalance currBalance;

  @Before
  public void setUp() throws Exception {
    this.cardOwner = new CardOwner("Patrick", "Li", "yl@gmail.com", "225 Terry Ave");
    this.currBalance = new CurrentBalance(100, 50);
    this.transitCard = new TransitCard(cardOwner, currBalance);
  }

  @Test
  public void getCardOwner() {
    Assert.assertEquals(this.cardOwner, this.transitCard.getCardOwner());
  }

  @Test
  public void setCardOwner() {
  }

  @Test
  public void getCurrBalance() {
    Assert.assertEquals(this.currBalance, this.transitCard.getCurrBalance());

  }

  @Test
  public void setCurrBalance() {
  }

  @Test
  public void depositMoneyWithoutCarry() throws Exception {
    CurrentBalance ExpectedBalance = new CurrentBalance(130, 65);
    Deposit newDeposit = new Deposit("Patrick", "Li", 30, 15);
    this.transitCard.depositMoney(newDeposit);

    Assert.assertEquals(this.currBalance.getDollarAmount(), ExpectedBalance.getDollarAmount());
    Assert.assertEquals(this.currBalance.getCentAmount(), ExpectedBalance.getCentAmount());
  }

  @Test
  public void depositMoneyWithCarry() throws Exception {
    CurrentBalance ExpectedBalance = new CurrentBalance(106, 0);
    Deposit newDeposit = new Deposit("Patrick", "Li", 5, 50);
    this.transitCard.depositMoney(newDeposit);
    Assert.assertEquals(this.currBalance.getDollarAmount(), ExpectedBalance.getDollarAmount());
    Assert.assertEquals(this.currBalance.getCentAmount(), ExpectedBalance.getCentAmount());
  }

  @org.junit.Rule
  public ExpectedException thrown1 = ExpectedException.none();

  @Test
  public void depositMoneyWithInvalidNameException() throws Exception {
    thrown1.expect(Exception.class);
    thrown1.expectMessage("CardOwner Name not match");
    Deposit newDeposit = new Deposit("AAA", "B", 5, 50);
    this.transitCard.depositMoney(newDeposit);
  }
}