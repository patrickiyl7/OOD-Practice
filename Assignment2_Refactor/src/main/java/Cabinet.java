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
   * constructor of Cabinet Class.
   *
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
   * function to return the suggestion of feet requirement.
   *
   * @param isFloorMounted if the cabinet is installed on the floor.
   * @param height the height of the cabinet.
   * @return if Corner feet is optional, required or not-required.
   */
  abstract String feetSuggestion(Boolean isFloorMounted, int height);

  /**
   * function to return the suggestion of rail requirement.
   *
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
   * function to check if it supports floorMounted.
   *
   * @return if the cabinet supports floor-mounted.
   */
  public Boolean getFloorMounted() {
    return isFloorMounted;
  }

  /**
   * function to check if it supports wall-mounted.
   *
   * @return if the cabinet supports wall-mounted.
   */
  public Boolean getWallMounted() {
    return isWallMounted;
  }

  /**
   * function to check if it requires fixture.
   *
   * @return if cabinet requires fixture equipment.
   */
  public Boolean getFixtureRequirement() {
    return fixtureRequirement;
  }


}

