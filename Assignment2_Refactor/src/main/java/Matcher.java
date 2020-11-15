import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Read Json file from User and generate appropriate furniture set via filter.
 */
public class Matcher {

  public static void main(String[] args) throws Exception {

      RequirementReader requirementReader = new RequirementReader("customerCriteria.json");
      if (requirementReader.drawersRequirement > 0 && requirementReader.depthRequirement < 18) {
        throw new IllegalArgumentException("Depth not enough for a drawer");
      }
      IndividualStandardComponents individualStandardComponents = new IndividualStandardComponents();
      FurnitureDatabase furnitureDatabase = new FurnitureDatabase();
      List<Cabinet> cabinetProducts = furnitureDatabase.getCabinetProducts();
      List<DoorAndDrawer> drawerFrontProducts = furnitureDatabase.getDrawerFrontProducts();
      List<DoorAndDrawer> doorProducts = furnitureDatabase.getDoorProducts();
      List<Cabinet> resCabinet = cabinetMatcher(requirementReader.widthRequirement, requirementReader.heightRequirement,
          requirementReader.depthRequirement, requirementReader.shelvesRequirement, requirementReader.drawersRequirement, requirementReader.colorRequirement,
          requirementReader.wallMountedRequirement, requirementReader.floorMountedRequirement, cabinetProducts);
      List<DoorAndDrawer> resDrawer = new ArrayList<>();
      int remainingHeightRequirement =
          requirementReader.heightRequirement - individualStandardComponents.getDrawerSizeSpec() * requirementReader.drawersRequirement;
      if (requirementReader.drawersRequirement > 0) {
        resDrawer = drawerFrontMatcher(requirementReader.heightRequirement, requirementReader.depthRequirement, requirementReader.drawersRequirement,
            requirementReader.colorRequirement,
            drawerFrontProducts);
      }
      List<DoorAndDrawer> resDoor = doorMatcher(remainingHeightRequirement,
          requirementReader.colorRequirement,
          doorProducts);
      individualStandardComponents.setNumOfCabinetFeet(feetCalculate(requirementReader.numOfCabinets, "Required"));
      ResultWriter resultWriter = new ResultWriter(resCabinet, resDrawer, resDoor, individualStandardComponents, requirementReader);
      resultWriter.GenerateResult();
  }

  /**
   * cabinetMatcher function.
   *
   * @param widthRequirement widthRequirement
   * @param heightRequirement heightRequirement
   * @param depthRequirement depthRequirement
   * @param shelvesRequirement shelvesRequirement
   * @param drawersRequirement drawersRequirement
   * @param colorRequirement colorRequirement
   * @param wallMountedRequirement wallMountedRequirement
   * @param floorMountedRequirement floorMountedRequirement
   * @param cabinetProducts cabinetProducts
   * @return matched cabinets.
   */
  private static List<Cabinet> cabinetMatcher(int widthRequirement, int heightRequirement,
      int depthRequirement,
      int shelvesRequirement, int drawersRequirement, String[] colorRequirement,
      Boolean wallMountedRequirement,
      Boolean floorMountedRequirement, List<Cabinet> cabinetProducts) {
    List<Cabinet> res = new ArrayList<>();
    for (int i = 0; i < cabinetProducts.size(); i++) {
      if (cabinetProducts.get(i).height == heightRequirement
          && cabinetProducts.get(i).depth == depthRequirement
          && cabinetProducts.get(i).isFloorMounted == floorMountedRequirement
          && cabinetProducts.get(i).isWallMounted == wallMountedRequirement
          && cabinetProducts.get(i).maxNumOfDrawers >= drawersRequirement
          && cabinetProducts.get(i).maxNumOfShelves >= shelvesRequirement
      ) {
        if (colorRequirementCheck(cabinetProducts.get(i), colorRequirement)) {
          res.add(cabinetProducts.get(i));
        }
      }
    }
    return res;
  }

  /**
   * drawerFrontMatcher function.
   *
   * @param heightRequirement heightRequirement
   * @param depthRequirement depthRequirement
   * @param drawersRequirement drawersRequirement
   * @param colorRequirement colorRequirement
   * @param drawerFrontProducts drawerFrontProducts
   * @return matched drawer front.
   */
  private static List<DoorAndDrawer> drawerFrontMatcher(int heightRequirement,
      int depthRequirement,
      int drawersRequirement, String[] colorRequirement,
      List<DoorAndDrawer> drawerFrontProducts) {
    if (drawersRequirement < 1 || depthRequirement < 18) {
      return null;
    }
    List<DoorAndDrawer> res = new ArrayList<>();
    for (int i = 0; i < drawerFrontProducts.size(); i++) {
      if (colorRequirementCheck(drawerFrontProducts.get(i), colorRequirement)) {
        res.add(drawerFrontProducts.get(i));
      }
    }
    return res;
  }

  /**
   * doorMatcher function.
   *
   * @param heightRequirement heightRequirement
   * @param colorRequirement colorRequirement
   * @param doorProducts doorProducts
   * @return matched door and drawer
   */
  private static List<DoorAndDrawer> doorMatcher(int heightRequirement,
      String[] colorRequirement,
      List<DoorAndDrawer> doorProducts) {

    List<DoorAndDrawer> res = new ArrayList<>();
    for (int i = 0; i < doorProducts.size(); i++) {
      if (doorProducts.get(i).height == heightRequirement) {
        if (colorRequirementCheck(doorProducts.get(i), colorRequirement)) {
          res.add(doorProducts.get(i));
        }
      }
    }
    return res;
  }

  /**
   * feetCalculate function.
   * @param numOfCabinet numOfCabinet
   * @param feetRequirement feetRequirement
   * @return feetCalculate.
   */
  public static int feetCalculate(Integer numOfCabinet, String feetRequirement) {
    if (feetRequirement.equals("Required") || feetRequirement.equals("Optional")) {
      int additionFeetRequirement = ((int) Math.ceil(numOfCabinet / 2.0) - 1) * 2;
      return 4 + additionFeetRequirement;
    } else {
      return 0;
    }
  }

  /**
   * colorRequirementCheck function.
   * @param product product
   * @param colorRequirement colorRequirement
   * @return if it matches the color requirement.
   */
  public static boolean colorRequirementCheck(Furniture product, String[] colorRequirement) {

    int colorRequirementCount = 0;
    for (int j = 0; j < colorRequirement.length; j++) {
      for (int k = 0; k < product.color.length; k++) {
        if (colorRequirement[j].equals(product.color[k])) {
          colorRequirementCount++;
        }
      }
    }
    if (colorRequirementCount == colorRequirement.length) {
      return true;
    }
    return false;
  }

}

