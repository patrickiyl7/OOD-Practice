package Problem1;

/**
 * Cabinet abstract class extends Furniture class.
 */
public abstract class Cabinet extends Furniture {

  Integer maxNumOfShelves;
  Integer maxNumOfDrawers;
  Boolean isFloorMounted;
  Boolean isWallMounted;
  Boolean fixtureRequirement;
  String feetRequirement;
  String railRequirement;

  /**
   * @param productLine brand of the cabinet.
   * @param height height of the cabinet.
   * @param width width of the cabinet.
   * @param depth depth of the cabinet.
   * @param color color of the cabinet.
   * @param maxNumOfShelves maximum number of shelves the cabinet could contain.
   * @param maxNumOfDrawers maximum number of drawers the cabinet could contain.
   * @param isFloorMounted check the installation place.
   * @param isWallMounted check the installation place.
   * @param fixtureRequirement check if fixture equipment is required.
   * @param feetRequirement check if cabin corner feet is required.
   * @param railRequirement check if wall rail is required.
   *
   */
  public Cabinet(String productLine, Integer height, Integer width, Integer depth, String[] color, Integer maxNumOfShelves,
      Integer maxNumOfDrawers, Boolean isFloorMounted, Boolean isWallMounted, Boolean fixtureRequirement, String feetRequirement, String railRequirement) {
    super(productLine, height, width, depth, color);
    this.maxNumOfShelves = maxNumOfShelves;
    this.maxNumOfDrawers = maxNumOfDrawers;
    this.isFloorMounted = isFloorMounted;
    this.isWallMounted = isWallMounted;
    this.fixtureRequirement = fixtureRequirement;;
    this.feetRequirement = feetRequirement;
    this.railRequirement = railRequirement;
  }

  /**
   * @param numOfCabinet number of Cabinets customer wants to purchase.
   * @param feetRequirement check the corner feet requirement of the Cabinet.
   * @return the cabinet corner feet required.
   */
  public int feetCalculate(Integer numOfCabinet, String feetRequirement){
    if(feetRequirement.equals("Required"))
    {
      int additionFeetRequirement = ((int)Math.ceil(numOfCabinet / 2.0) - 1) * 2;
      return 4 + additionFeetRequirement;
    }
    else
      return 0;
  }

  /**
   * @param isFloorMounted if the cabinet is installed on the floor.
   * @param height the height of the cabinet.
   * @return if Corner feet is optional, required or not-required.
   */
  abstract String feetSuggestion(Boolean isFloorMounted, int height);

  /**
   * @param isWallMounted if the cabinet is installed on the wall.
   * @return what kind of rails should be chosen or rails n
   */
  abstract String railSuggestion(Boolean isWallMounted);

  /**
   * @param height height of the cabinet.
   * @return the color set of that cabinet.
   */
  abstract String[] colorGeneration(Integer height);

  /**
   * @return max number of shelves that cabinet could have.
   */
  public Integer getMaxNumOfShelves() {
    return maxNumOfShelves;
  }

  /**
   * @param maxNumOfShelves max number of shelves that cabinet could have.
   */
  public void setMaxNumOfShelves(Integer maxNumOfShelves) {
    this.maxNumOfShelves = maxNumOfShelves;
  }

  /**
   * @return max number of drawers that cabinet could have.
   */
  public Integer getMaxNumOfDrawers() {
    return maxNumOfDrawers;
  }

  /**
   * @param maxNumOfDrawers max number of drawers that cabinet could have.
   */
  public void setMaxNumOfDrawers(Integer maxNumOfDrawers) {
    this.maxNumOfDrawers = maxNumOfDrawers;
  }

  /**
   * @return if the cabinet supports floor-mounted.
   */
  public Boolean getFloorMounted() {
    return isFloorMounted;
  }

  /**
   * @param floorMounted if the cabinet supports floor-mounted.
   */
  public void setFloorMounted(Boolean floorMounted) {
    isFloorMounted = floorMounted;
  }

  /**
   * @return if the cabinet supports wall-mounted.
   */
  public Boolean getWallMounted() {
    return isWallMounted;
  }

  /**
   * @param wallMounted if the cabinet supports wall-mounted.
   */
  public void setWallMounted(Boolean wallMounted) {
    isWallMounted = wallMounted;
  }

  /**
   * @return if cabinet requires fixture equipment.
   */
  public Boolean getFixtureRequirement() {
    return fixtureRequirement;
  }

  /**
   * @param fixtureRequirement if cabinet requires fixture equipment.
   */
  public void setFixtureRequirement(Boolean fixtureRequirement) {
    this.fixtureRequirement = fixtureRequirement;
  }

  /**
   * @return the requirement of the cabinet corner feet.
   */
  public String getFeetRequirement() {
    return feetRequirement;
  }

  /**
   * @param feetRequirement the requirement of the cabinet corner feet.
   */
  public void setFeetRequirement(String feetRequirement) {
    this.feetRequirement = feetRequirement;
  }

  /**
   * @return the requirement of the wall rails.
   */
  public String getRailRequirement() {
    return railRequirement;
  }

  /**
   * @param railRequirement the requirement of the wall rails.
   */
  public void setRailRequirement(String railRequirement) {
    this.railRequirement = railRequirement;
  }
}
