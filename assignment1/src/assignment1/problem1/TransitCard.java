package assignment1.problem1;

import java.util.Objects;

/**
 * Represents the TransitCard with CardOwner and CurrentBalance.
 *
 * @author yihaoli
 */
public class TransitCard {

  private CardOwner cardOwner;
  private CurrentBalance currBalance;

  /** Constructor of the TransitCard class.
   * @param cardOwner
   * @param currBalance
   */
  public TransitCard(CardOwner cardOwner, CurrentBalance currBalance) {
    this.cardOwner = cardOwner;
    this.currBalance = currBalance;
  }

  /**
   * @return the CardOwner of the TransitCard.
   */
  public CardOwner getCardOwner() {
    return cardOwner;
  }

  /**
   * set the cardOwner of the TransitCard.
   * @param cardOwner
   */
  public void setCardOwner(CardOwner cardOwner) { this.cardOwner = cardOwner; }

  /**
   * @return the CurrentBalance of the TransitCard.
   */
  public CurrentBalance getCurrBalance() {
    return currBalance;
  }

  /**
   * Set the CurrentBalance of the CardOwner.
   * @param currBalance
   */
  public void setCurrBalance(CurrentBalance currBalance) {
    this.currBalance = currBalance;
  }

  /**
   * Deposit a new amount of fund to the TransitCard.
   * @param newDeposit
   * @throws Exception If the name of the CardOwner doesn't match the deposit.
   */
  public void depositMoney(Deposit newDeposit) throws Exception {
    if (!newDeposit.getFirstName().equals(this.cardOwner.getFirstName()) || !newDeposit
        .getLastName().equals(this.cardOwner.getLastName())) {
      throw new IllegalArgumentException("CardOwner Name not match");
    }

    int newDollarAmount = this.currBalance.getDollarAmount() + newDeposit.getDollarAmount();
    int newCentAmount = this.currBalance.getCentAmount() + newDeposit.getCentAmount();
    if (newCentAmount > 99) {
      currBalance.setCentAmount(newCentAmount - 100);
      currBalance.setDollarAmount(1 + newDollarAmount);
    } else {
      currBalance.setCentAmount(newCentAmount);
      currBalance.setDollarAmount(newDollarAmount);
    }


  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TransitCard)) {
      return false;
    }
    TransitCard that = (TransitCard) o;
    return getCardOwner().equals(that.getCardOwner()) &&
        getCurrBalance().equals(that.getCurrBalance());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCardOwner(), getCurrBalance());
  }

  @Override
  public String toString() {
    return "TransitCard{" +
        "cardOwner=" + cardOwner +
        ", currBalance=" + currBalance +
        '}';
  }
}
