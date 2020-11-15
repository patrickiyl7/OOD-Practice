package assignment1.problem1;

import java.util.Objects;

/**
 * Represents the Deposit with firstName, lastName, dollarAmount and centAmount.
 *
 * @author yihaoli
 */
public class Deposit {

  private String firstName;
  private String lastName;
  private Integer dollarAmount;
  private Integer centAmount;

  /**
   * Constructor of the Deposit class.
   *
   * @param firstName
   * @param lastName
   * @param dollarAmount
   * @param centAmount
   * @throws Exception
   */
  public Deposit(String firstName, String lastName, Integer dollarAmount, Integer centAmount)
      throws Exception {
    if (dollarAmount < 5) {
      throw new IllegalArgumentException("Deposit amount is less than five");
    }
    if (dollarAmount > 50 || (dollarAmount == 50 && centAmount > 0)) {
      throw new IllegalArgumentException("Deposit amount is larger than fifty");
    }
    if (centAmount < 0) {
      throw new IllegalArgumentException("Cent amount is less than zero");
    }
    if (centAmount > 99) {
      throw new IllegalArgumentException("Cent amount is larger than ninety nine");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.dollarAmount = dollarAmount;
    this.centAmount = centAmount;
  }

  /**
   * @return the firstName of the Deposit.
   */
  public String getFirstName() { return firstName; }

  /**
   * set the firstName of the Deposit.
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName of the Deposit.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * set the lastName of the Deposit.
   * @param lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the dollarAmount of the Deposit.
   */
  public Integer getDollarAmount() {
    return dollarAmount;
  }

  /**
   * set the dollarAmount of the Deposit.
   * @param dollarAmount
   */
  public void setDollarAmount(Integer dollarAmount) {
    this.dollarAmount = dollarAmount;
  }

  /**
   * @return the centAmount of the Deposit.
   */
  public Integer getCentAmount() {
    return centAmount;
  }

  /**
   * set the centAmount of the Deposit.
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
    if (!(o instanceof Deposit)) {
      return false;
    }
    Deposit deposit = (Deposit) o;
    return getFirstName().equals(deposit.getFirstName()) &&
        getLastName().equals(deposit.getLastName()) &&
        getDollarAmount().equals(deposit.getDollarAmount()) &&
        getCentAmount().equals(deposit.getCentAmount());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName(), getDollarAmount(), getCentAmount());
  }

  @Override
  public String toString() {
    return "Deposit{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", dollarAmount=" + dollarAmount +
        ", centAmount=" + centAmount +
        '}';
  }
}
