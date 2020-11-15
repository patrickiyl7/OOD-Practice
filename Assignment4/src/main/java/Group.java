import java.util.List;

/**
 * Class of Group. Containing information like groupName,
 * list of group members, number of wheelAccessibility requirement and group leader info.
 */
public class Group {
  String groupName;
  List<GroupAttendee> groupAttendeeList;
  Integer numWheelAccessibility;
  GroupAttendee groupLeader;

  /**
   * Constructor of Group Class.
   * @param groupName groupName.
   * @param groupAttendeeList groupAttendeeList.
   * @param numWheelAccessibility numWheelAccessibility.
   * @param groupLeader groupLeader.
   */
  public Group(String groupName, List<GroupAttendee> groupAttendeeList, Integer numWheelAccessibility,
      GroupAttendee groupLeader) {
    this.groupName = groupName;
    this.groupAttendeeList = groupAttendeeList;
    this.numWheelAccessibility = numWheelAccessibility;
    this.groupLeader = groupLeader;
  }

  /**
   * group name getter
   * @return group name in String form.
   */
  public String getGroupName() {
    return groupName;
  }

  /**
   * group name setter
   * @param groupName groupName
   */
  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  /**
   * groupLeader getter
   * @return groupLeader.
   */
  public GroupAttendee getGroupLeader() {
    return groupLeader;
  }

  /**
   * groupLeader setter
   * @param groupLeader groupLeader.
   */
  public void setGroupLeader(GroupAttendee groupLeader) {
    this.groupLeader = groupLeader;
  }
}
