package Problem1;

import java.security.InvalidParameterException;

/**
 * Yossarian product line extends Cabinet Class.
 */
public class Yossarian extends Cabinet {

  public Yossarian(Integer height, Integer width, Integer depth) throws Exception {
      super("Yossarian",0, 0, 0, new String[0], 0, 0, false, false, false, "Not required", "Not required");
      if(height == 72 && width == 36 && depth == 16)
      {
        this.height = 72;
        this.width = 36;
        this.depth = 16;
        this.color = colorGeneration(72);
        this.maxNumOfShelves = 7;
        this.maxNumOfDrawers = 0;
        this.isFloorMounted = true;
        this.isWallMounted = false;
        this.fixtureRequirement = true;
        this.feetRequirement = feetSuggestion(isFloorMounted, height);
        this.railRequirement = railSuggestion(isWallMounted);
        this.productLine = "Yossarian Wardrobe";
      }
      else if(height == 36 && width == 36 && depth == 16)
      {
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
        this.productLine = "Yossarian Half";
      }
      else if(height == 18 && width == 36 && depth == 16)
      {
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
        this.productLine = "Yossarian Quarter";
      }
      else
      {
        throw new InvalidParameterException("Size Spec Invalid");
      }
  }

  @Override
  String feetSuggestion(Boolean isFloorMounted, int height){
    if(height == 72 && isFloorMounted == true)
    {
      return "Not Required";
    }
    else if(height == 36 && isFloorMounted == true)
    {
      return "Optional";
    }
    else if(height == 18 && isFloorMounted == true)
    {
      return "Required";
    }
    else return "Not Specified";
  }

  @Override
  String railSuggestion(Boolean isWallMounted) {
    if(isWallMounted == true)
    {
      return "Standard wall mount rail required.";
    }
    else
    {
      return "Not required";
    }
  }

  @Override
  String[] colorGeneration(Integer height) {
    if(height == 72)
    {
      color = new String[]{"brown", "black", "bone", "oxblood"};
    }
    else
      color = new String[]{"brown", "black", "bone"};
    return color;
  }




}
