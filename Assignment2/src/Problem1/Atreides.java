package Problem1;

import java.security.InvalidParameterException;

/**
 * Atreides product line extends Cabinet Class.
 */
public class Atreides extends Cabinet {

  /**
   * @param height height of Atreides Cabinets.
   * @param width width of Atreides Cabinets.
   * @param depth depth of Atreides Cabinets.
   * @throws Exception if there is no valid Atreides Cabinet with such size spec.
   * Constructor of the Atreides Class.
   */
  public Atreides(Integer height, Integer width, Integer depth) throws Exception {
    super("Atreides",0, 0, 0, new String[0], 0, 0, false, false, false, "Not required", "Not required");
    if (height == 36 && width == 36 && depth == 16) {
      this.height = 36;
      this.width = 36;
      this.depth = 16;
      this.color = colorGeneration(36);
      this.maxNumOfShelves = 3;
      this.maxNumOfDrawers = 0;
      this.isFloorMounted = true;
      this.isWallMounted = true;
      this.fixtureRequirement = false;
      this.feetRequirement = feetSuggestion(isFloorMounted, height);
      this.railRequirement = railSuggestion(isWallMounted);
      this.productLine = "Atreides Half";
    } else if (height == 18 && width == 36 && depth == 16) {
      this.height = 18;
      this.width = 36;
      this.depth = 16;
      this.color = colorGeneration(18);
      this.maxNumOfShelves = 1;
      this.maxNumOfDrawers = 0;
      this.isFloorMounted = true;
      this.isWallMounted = true;
      this.fixtureRequirement = false;
      this.feetRequirement = feetSuggestion(isFloorMounted, height);
      this.railRequirement = railSuggestion(isWallMounted);
      this.productLine = "Atreides Quarter";
    } else {
      throw new InvalidParameterException("Size Spec Invalid");
    }
  }

  @Override
  String feetSuggestion(Boolean isFloorMounted, int height) {
    if (height == 36 && isFloorMounted == true) {
      return "Optional";
    } else if (height == 18 && isFloorMounted == true) {
      return "Required";
    } else {
      return "Not Specified";
    }
  }

  @Override
  String railSuggestion(Boolean isWallMounted) {
    if (isWallMounted == true) {
      return "Special wall mount rail required.";
    } else {
      return "Not required";
    }
  }

  @Override
  String[] colorGeneration(Integer height) {
    return new String[]{"brown", "bone"};
  }
}
