package Problem1;

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

  public static void main(String[] args) {
    JSONParser jsonParser = new JSONParser();

    try {
      Object obj = jsonParser.parse(new FileReader("customerCriteria.json"));
      JSONObject jsonObject = (JSONObject) obj;
      int widthRequirement = ((Number) jsonObject.get("width")).intValue();
      int heightRequirement = ((Number) jsonObject.get("height")).intValue();
      int depthRequirement = ((Number) jsonObject.get("depth")).intValue();
      int shelvesRequirement = ((Number) jsonObject.get("shelves")).intValue();
      int drawersRequirement = ((Number) jsonObject.get("drawers")).intValue();
      int numOfCabinets = ((Number) jsonObject.get("drawers")).intValue();
      JSONArray colorRequirementJSON = (JSONArray) jsonObject.get("color");
      int length = colorRequirementJSON.size();
      String[] colorRequirement = new String[length];
      for (int i = 0; i < length; i++) {
        colorRequirement[i] = colorRequirementJSON.get(i).toString();
      }
      if (drawersRequirement > 0 && depthRequirement < 18) {
        throw new IllegalArgumentException("Depth not enough for a drawer");
      }
      IndividualStandardComponents individualStandardComponents = new IndividualStandardComponents();
      Boolean wallMountedRequirement = (Boolean) jsonObject.get("wallMounted");
      Boolean floorMountedRequirement = (Boolean) jsonObject.get("floorMounted");
      List<Cabinet> cabinetProducts = new ArrayList<>(); //List of the current Cabinet-type product line.
      Yossarian yossarianWardrobe = new Yossarian(72, 36, 16);
      Yossarian yossarianHalf = new Yossarian(36, 36, 16);
      Yossarian yossarianQuarter = new Yossarian(18, 36, 16);
      Luthien luthienHalf = new Luthien(36, 36, 18);
      Luthien luthienQuarter = new Luthien(18, 36, 18);
      Atreides atreidesHalf = new Atreides(36, 36, 16);
      Atreides atreidesQuarter = new Atreides(18, 36, 16);
      cabinetProducts.add(yossarianWardrobe);
      cabinetProducts.add(yossarianHalf);
      cabinetProducts.add(yossarianQuarter);
      cabinetProducts.add(luthienHalf);
      cabinetProducts.add(luthienQuarter);
      cabinetProducts.add(atreidesHalf);
      cabinetProducts.add(atreidesQuarter);
      List<DoorAndDrawer> drawerFrontProducts = new ArrayList<>(); //List of the current DrawerFront-type product line.
      GagaDrawer gagaDrawerQuater = new GagaDrawer(18, 38, 0,
          new String[]{"brown", "black", "bone", "oxblood"});
      drawerFrontProducts.add(gagaDrawerQuater);
      List<DoorAndDrawer> doorProducts = new ArrayList<>(); //List of the current Door-type product line.
      Slothrop slothropWardrobe = new Slothrop(72, 36, 0, new String[]{"brown", "black"});
      Slothrop slothropHalf = new Slothrop(36, 36, 0, new String[]{"brown", "black"});
      Belacqua belacquaWardrobe = new Belacqua(72, 36, 0, new String[]{"bone", "oxblood"});
      Belacqua belacquaHalf = new Belacqua(36, 36, 0, new String[]{"bone", "oxblood"});
      Belacqua belacquaQuater = new Belacqua(18, 36, 0, new String[]{"bone", "oxblood"});
      GagaDoor gagaDoorQuater = new GagaDoor(18, 38, 0,
          new String[]{"brown", "black", "bone", "oxblood"});
      doorProducts.add(slothropWardrobe);
      doorProducts.add(slothropHalf);
      doorProducts.add(belacquaWardrobe);
      doorProducts.add(belacquaHalf);
      doorProducts.add(belacquaQuater);
      doorProducts.add(gagaDoorQuater);
      List<Cabinet> resCabinet = cabinetMatcher(widthRequirement, heightRequirement,
          depthRequirement, shelvesRequirement, drawersRequirement, colorRequirement,
          wallMountedRequirement, floorMountedRequirement, cabinetProducts);
      List<DoorAndDrawer> resDrawer = new ArrayList<>();
      int remainingHeightRequirement =
          heightRequirement - individualStandardComponents.getDrawerSizeSpec() * drawersRequirement;
      //System.out.println(remainingHeightRequirement);
      if (drawersRequirement > 0) {
        resDrawer = drawerFrontMatcher(heightRequirement, depthRequirement, drawersRequirement,
            colorRequirement,
            drawerFrontProducts);
        /*for(int i = 0; i < resDrawer.size(); i++)
        {
          //System.out.println("reached");
          System.out.println(resDrawer.get(i).getProductLine());
          System.out.println(resDrawer.get(i).getHeight());
          System.out.println(resDrawer.get(i).getColor()[0]);
        }*/
      }
      List<DoorAndDrawer> resDoor = doorMatcher(remainingHeightRequirement,
          colorRequirement,
          doorProducts);

      /*for(int i = 0; i < resCabinet.size(); i++)
      {
        System.out.println(resCabinet.get(i).getProductLine());
        System.out.println(resCabinet.get(i).getHeight());
        System.out.println(resCabinet.get(i).getColor()[0]);
      }
      for(int i = 0; i < resDoor.size(); i++)
      {
        System.out.println(resDoor.get(i).getProductLine());
        System.out.println(resDoor.get(i).getHeight());
        System.out.println(resDoor.get(i).getColor()[0]);
      }*/
      JSONObject recommendCombo = new JSONObject();
      JSONArray individualComponents = new JSONArray();
      for(int i = 0; i < resCabinet.size(); i++)
      {
        recommendCombo.put("Cabinet", resCabinet.get(i).getProductLine());
        IndividualStandardComponents r = new IndividualStandardComponents();
        if(resCabinet.get(i).getFixtureRequirement())
        {
          individualComponents.add("Wall fixture attachment for earthquake safety : Required");
        }
        if(resCabinet.get(i).feetSuggestion(resCabinet.get(i).getFloorMounted(), resCabinet.get(i).getHeight()).equals("Required"))
        {
          individualComponents.add(feetCalculate(numOfCabinets, "Required") + " Number of Required Cabinet Feet");
        }
        if(resCabinet.get(i).feetSuggestion(resCabinet.get(i).getFloorMounted(), resCabinet.get(i).getHeight()).equals("Optional"))
        {
          individualComponents.add(feetCalculate(numOfCabinets, "Optional") + " Number of Optional Cabinet Feet");
        }
        if(resCabinet.get(i).getWallMounted())
        {
          individualComponents.add(resCabinet.get(i).railSuggestion(resCabinet.get(i).getWallMounted()));
        }
      }
      for(int i = 0; i < resDoor.size(); i++)
      {
        recommendCombo.put("Door", resDoor.get(i).getProductLine());
        individualComponents.add("Door Hinges Required");
      }
      for(int i = 0; i < resDrawer.size(); i++)
      {
        recommendCombo.put("Drawer", resDrawer.get(i).getProductLine());
        individualComponents.add(drawersRequirement + " Number of Drawers");
      }
      try (FileWriter file = new FileWriter("recommendCombo.json")) {
        recommendCombo.put("Individual Components List", individualComponents);
        file.write(recommendCombo.toJSONString());
        file.flush();

      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

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

  public static int feetCalculate(Integer numOfCabinet, String feetRequirement) {
    if (feetRequirement.equals("Required") || feetRequirement.equals("Optional")) {
      int additionFeetRequirement = ((int) Math.ceil(numOfCabinet / 2.0) - 1) * 2;
      return 4 + additionFeetRequirement;
    } else {
      return 0;
    }
  }

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

