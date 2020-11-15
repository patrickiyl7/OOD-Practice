package assignment1;

import java.util.Objects;

/**
 *  Class of Name info.
 */
public class Name {

  private String firstName;
  private String midName;
  private String lastName;

  /**
   * Constructor of Name info.
   * @param firstName firstName of name.
   * @param midName midName of name.
   * @param lastName lastName of name.
   */
  public Name(String firstName, String midName, String lastName) {
    this.firstName = firstName;
    this.midName = midName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMidName() {
    return midName;
  }

  public void setMidName(String midName) {
    this.midName = midName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Name)) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(getFirstName(), name.getFirstName()) &&
        Objects.equals(getMidName(), name.getMidName()) &&
        Objects.equals(getLastName(), name.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getMidName(), getLastName());
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", midName='" + midName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
