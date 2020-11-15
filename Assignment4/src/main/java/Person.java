/**
 * Class of Person. Containing info like userName and wheelChairAccessibility.
 */
public abstract class Person {
  private String userName;
  private Boolean wheelChairAccessibility;

  /**
   * Constructor of Person Class
   * @param userName userName
   * @param wheelChairAccessibility wheelChairAccessibility
   */
  public Person(String userName, Boolean wheelChairAccessibility) {
    this.userName = userName;
    this.wheelChairAccessibility = wheelChairAccessibility;
  }

  /**
   * func getWheelChairAccessibility
   * @return if the person needs wheel chair accessibility.
   */
  public Boolean getWheelChairAccessibility() {
    return wheelChairAccessibility;
  }

  /**
   * userName getter
   * @return userName
   */
  public String getUserName() {
    return userName;
  }

}
