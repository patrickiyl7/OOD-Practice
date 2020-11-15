/**
 * Class of IndividualAttendee. Containing info like preferredName
 * and inherit features from Person Class.
 */
public class IndividualAttendee extends Person {
  String preferredName;
  public IndividualAttendee(String name, Boolean wheelChairAccessibility, String preferredName) {
    super(name, wheelChairAccessibility);
    this.preferredName = preferredName;
  }

  /**
   * preferredName getter
   * @return preferredName
   */
  public String getPreferredName() {
    return preferredName;
  }

  /**
   * preferredName setter
   * @param preferredName preferredName
   */
  public void setPreferredName(String preferredName) {
    this.preferredName = preferredName;
  }
}
