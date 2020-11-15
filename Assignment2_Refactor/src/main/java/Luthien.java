import java.security.InvalidParameterException;

/**
 * Luthien product line extends Cabinet Class.
 */
public class Luthien extends Cabinet {

  /**
   * Constructor of the Luthien product line.
   *
   * @param height height
   * @param width width
   * @param depth depth
   * @throws Exception if it has invalid parameters.
   */
  public Luthien(Integer height, Integer width, Integer depth) throws Exception {
    super("Luthien", 0, 0, 0, new String[0], 0, 0, false, false, false, "Not required", "Not required");
    if (height == 36 && width == 36 && depth == 18) {
      this.height = 36;
      this.width = 36;
      this.depth = 18;
      this.color = colorGeneration(36);
      this.maxNumOfShelves = 3;
      this.maxNumOfDrawers = 1;
      this.isFloorMounted = true;
      this.isWallMounted = true;
      this.fixtureRequirement = false;
      this.feetRequirement = feetSuggestion(isFloorMounted, height);
      this.railRequirement = railSuggestion(isWallMounted);
      this.productLine = "Luthien Half";
    } else if (height == 18 && width == 36 && depth == 18) {
      this.height = 18;
      this.width = 36;
      this.depth = 18;
      this.color = colorGeneration(18);
      this.maxNumOfShelves = 1;
      this.maxNumOfDrawers = 1;
      this.isFloorMounted = true;
      this.isWallMounted = true;
      this.fixtureRequirement = false;
      this.feetRequirement = feetSuggestion(isFloorMounted, height);
      this.railRequirement = railSuggestion(isWallMounted);
      this.productLine = "Luthien Quarter";
    } else {
      throw new InvalidParameterException("Size Spec Invalid");
    }
  }

  /**
   * feetSuggestion function.
   *
   * @param isFloorMounted if the cabinet is installed on the floor.
   * @param height the height of the cabinet.
   * @return feetSuggestion
   */
  String feetSuggestion(Boolean isFloorMounted, int height) {
    if (height == 36 && isFloorMounted) {
      return "Optional";
    } else if (height == 18 && isFloorMounted) {
      return "Required";
    } else {
      return "Not Specified";
    }
  }

  /**
   * railSuggestion function
   *
   * @param isWallMounted if the cabinet is installed on the wall.
   * @return railSuggestion
   */
  @Override
  String railSuggestion(Boolean isWallMounted) {
    if (isWallMounted) {
      return "Standard wall mount rail required.";
    } else {
      return "Not required";
    }
  }

  /**
   * colorGeneration function
   *
   * @param height height
   * @return colorGeneration
   */
  @Override
  String[] colorGeneration(Integer height) {
    return new String[]{"black", "bone"};
  }
}
