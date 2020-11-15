package assignment1.problem1;

import java.util.Objects;

/**
 * Represents an CardOwner with their details--firstName, lastName, email and address.
 *
 * @author yihaoli
 */
public class CardOwner {

  private String firstName;
  private String lastName;
  private String email;
  private String address;

  /**
   * Constructor of the CardOwner class.
   * @param firstName
   * @param lastName
   * @param email
   * @param address
   */
  public CardOwner(String firstName, String lastName, String email, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
  }


  /**
   * @return the firstName of the cardOwner.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the firstName.
   *
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName of the cardOwner.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the lastName.
   *
   * @param lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  /**
   * @return the email of the CardOwner.
   */
  public String getEmail() {
    return email;
  }

  /**
   * set the email.
   *
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the address of the CardOwner.
   */
  public String getAddress() {
    return address;
  }

  /**
   * set the address.
   *
   * @param address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardOwner cardOwner = (CardOwner) o;
    return firstName.equals(cardOwner.firstName) &&
        lastName.equals(cardOwner.lastName) &&
        email.equals(cardOwner.email) &&
        address.equals(cardOwner.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email, address);
  }

  @Override
  public String toString() {
    return "CardOwner{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
