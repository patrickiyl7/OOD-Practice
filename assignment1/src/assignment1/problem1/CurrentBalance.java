package assignment1.problem1;

import java.util.Objects;

/**
 * Represents the CurrentBalance with dollarAmount and centAmount.
 *
 * @author yihaoli
 */
public class CurrentBalance {

  private Integer dollarAmount;
  private Integer centAmount;

  /**
   * Constructor of the CurrentBalance class.
   * @param dollarAmount
   * @param centAmount
   * @throws Exception if the input amount doesn't satisfy the requirements.
   */
  public CurrentBalance(Integer dollarAmount, Integer centAmount) throws Exception {
    if (dollarAmount < 0) {
      throw new IllegalArgumentException("Card balance is less than zero");
    } else if (centAmount < 0) {
      throw new IllegalArgumentException("Cent amount is less than zero");
    } else if (centAmount > 99) {
      throw new IllegalArgumentException("Cent amount is too large");
    }
    this.dollarAmount = dollarAmount;
    this.centAmount = centAmount;
  }

  /**
   * @return the dollarAmount of CurrentBalance.
   */
  public Integer getDollarAmount() {
    return dollarAmount;
  }

  /**
   * set the CurrentBalance with input dollarAmount.
   *
   * @param dollarAmount
   */
  public void setDollarAmount(Integer dollarAmount) {
    this.dollarAmount = dollarAmount;
  }

  /**
   * @return the centAmount of CurrentBalance.
   */
  public Integer getCentAmount() {
    return centAmount;
  }

  /**
   * set the CurrentBalance with input centAmount.
   *
   * @param centAmount
   */
  public void setCentAmount(Integer centAmount) {
    this.centAmount = centAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CurrentBalance)) {
      return false;
    }
    CurrentBalance that = (CurrentBalance) o;
    return getDollarAmount().equals(that.getDollarAmount()) &&
        getCentAmount().equals(that.getCentAmount());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDollarAmount(), getCentAmount());
  }

  @Override
  public String toString() {
    return "CurrentBalance{" +
        "dollarAmount=" + dollarAmount +
        ", centAmount=" + centAmount +
        '}';
  }
}
