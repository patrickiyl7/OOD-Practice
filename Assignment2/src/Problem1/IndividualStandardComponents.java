package Problem1;

public class IndividualStandardComponents {
  private Integer numOfEighteenInchDrawer;
  private Boolean doorHandler;
  private Boolean drawerHandler;
  private final Boolean doorHinge = true;
  private String standardRail;
  private Boolean wallFixture;
  private String cabinetFeetRequirement;
  private Integer numOfCabinetFeet;
  private final Integer drawerSizeSpec = 18;

  public void setNumOfCabinetFeet(Integer numOfCabinetFeet) {
    this.numOfCabinetFeet = numOfCabinetFeet;
  }

  public Integer getDrawerSizeSpec() {
    return drawerSizeSpec;
  }

  public IndividualStandardComponents() {
    this.numOfEighteenInchDrawer = 0;
    this.doorHandler = false;
    this.drawerHandler = true;
    this.standardRail = "Not Required";
    this.wallFixture = false;
    this.numOfCabinetFeet = 0;
  }

  public Integer getNumOfEighteenInchDrawer() {
    return numOfEighteenInchDrawer;
  }

  public void setNumOfEighteenInchDrawer(Integer numOfEighteenInchDrawer) {
    this.numOfEighteenInchDrawer = numOfEighteenInchDrawer;
  }

  public Boolean getDoorHandler() {
    return doorHandler;
  }

  public void setDoorHandler(Boolean doorHandler) {
    this.doorHandler = doorHandler;
  }

  public Boolean getDrawerHandler() {
    return drawerHandler;
  }

  public void setDrawerHandler(Boolean drawerHandler) {
    this.drawerHandler = drawerHandler;
  }

  public Boolean getDoorHinge() {
    return doorHinge;
  }

  public String getStandardRail() {
    return standardRail;
  }

  public void setStandardRail(String standardRail) {
    this.standardRail = standardRail;
  }

  public Boolean getWallFixture() {
    return wallFixture;
  }

  public void setWallFixture(Boolean wallFixture) {
    this.wallFixture = wallFixture;
  }

  public Integer getNumOfCabinetFeet() {
    return numOfCabinetFeet;
  }

  public void setNumOfCabinetFeet(int numOfCabinetFeet) {
    this.numOfCabinetFeet = numOfCabinetFeet;
  }

  public String getCabinetFeetRequirement() {
    return cabinetFeetRequirement;
  }

  public void setCabinetFeetRequirement(String cabinetFeetRequirement) {
    this.cabinetFeetRequirement = cabinetFeetRequirement;
  }
}
