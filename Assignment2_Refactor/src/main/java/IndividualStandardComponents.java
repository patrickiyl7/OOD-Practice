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

  public Integer getNumOfCabinetFeet() {
    return numOfCabinetFeet;
  }

  public void setNumOfCabinetFeet(int numOfCabinetFeet) {
    this.numOfCabinetFeet = numOfCabinetFeet;
  }

}
