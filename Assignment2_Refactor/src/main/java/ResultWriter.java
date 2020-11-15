import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ResultWriter {
  List<Cabinet> resCabinet;
  List<DoorAndDrawer> resDrawer;
  List<DoorAndDrawer> resDoor;
  IndividualStandardComponents individualStandardComponents;
  RequirementReader requirementReader;

  public ResultWriter(List<Cabinet> resCabinet, List<DoorAndDrawer> resDrawer,
      List<DoorAndDrawer> resDoor, IndividualStandardComponents individualStandardComponents,
      RequirementReader requirementReader) {
    this.resCabinet = resCabinet;
    this.resDrawer = resDrawer;
    this.resDoor = resDoor;
    this.individualStandardComponents = individualStandardComponents;
    this.requirementReader = requirementReader;
  }

  public void GenerateResult(){
    JSONObject recommendCombo = new JSONObject();
    JSONArray individualComponents = new JSONArray();
    for(int i = 0; i < resCabinet.size(); i++)
    {
      recommendCombo.put("Cabinet", resCabinet.get(i).getProductLine());
      //IndividualStandardComponents r = new IndividualStandardComponents();
      if(resCabinet.get(i).getFixtureRequirement())
      {
        individualComponents.add("Wall fixture attachment for earthquake safety : Required");
      }
      if(resCabinet.get(i).feetSuggestion(resCabinet.get(i).getFloorMounted(), resCabinet.get(i).getHeight()).equals("Required"))
      {
        individualComponents.add(individualStandardComponents.getNumOfCabinetFeet() + " Number of Required Cabinet Feet");
      }
      if(resCabinet.get(i).feetSuggestion(resCabinet.get(i).getFloorMounted(), resCabinet.get(i).getHeight()).equals("Optional"))
      {
        individualComponents.add(individualStandardComponents + " Number of Optional Cabinet Feet");
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
      individualComponents.add(requirementReader.drawersRequirement + " Number of Drawers");
    }
    try (FileWriter file = new FileWriter("recommendCombo.json")) {
      recommendCombo.put("Individual Components List", individualComponents);
      file.write(recommendCombo.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
