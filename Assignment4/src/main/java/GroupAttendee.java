/**
 * Class of Group. Containing information like group, title in the group
 * and inherit the features from Person Class.
 */
public class GroupAttendee extends Person {
  private Group group;
  private String title;

  /**
   * Constructor of GroupAttendee Class.
   * @param userName userName
   * @param wheelChairAccessibility wheelChairAccessibility
   * @param group group
   * @param title title
   */
  public GroupAttendee(String userName, Boolean wheelChairAccessibility, Group group, String title) {
    super(userName, wheelChairAccessibility);
    this.group = group;
    this.title = title;
  }

  /**
   * group getter
   * @return info of group.
   */
  public Group getGroup() {
    return group;
  }

  /**
   * group setter
   * @param group group.
   */
  public void setGroup(Group group) {
    this.group = group;
  }

  /**
   * title getter
   * @return title of the group attendee.
   */
  public String getTitle() {
    return title;
  }

  /**
   * title setter
   * @param title title.
   */
  public void setTitle(String title) {
    this.title = title;
  }
}