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

public class RequirementReader {
  Integer widthRequirement;
  Integer heightRequirement;
  Integer depthRequirement;
  Integer shelvesRequirement;
  Integer drawersRequirement;
  Integer numOfCabinets;
  Boolean wallMountedRequirement;
  Boolean floorMountedRequirement;
  String[] colorRequirement;

  public RequirementReader(String fileName) throws IOException, ParseException {
    JSONParser jsonParser = new JSONParser();
    Object obj = jsonParser.parse(new FileReader(fileName));
    JSONObject jsonObject = (JSONObject) obj;
    widthRequirement = ((Number) jsonObject.get("width")).intValue();
    heightRequirement = ((Number) jsonObject.get("height")).intValue();
    depthRequirement = ((Number) jsonObject.get("depth")).intValue();
    shelvesRequirement = ((Number) jsonObject.get("shelves")).intValue();
    drawersRequirement = ((Number) jsonObject.get("drawers")).intValue();
    numOfCabinets = ((Number) jsonObject.get("drawers")).intValue();
    wallMountedRequirement = (Boolean) jsonObject.get("wallMounted");
    floorMountedRequirement = (Boolean) jsonObject.get("floorMounted");
    JSONArray colorRequirementJSON = (JSONArray) jsonObject.get("color");
    int length = colorRequirementJSON.size();
    colorRequirement = new String[length];
    for (int i = 0; i < length; i++) {
      colorRequirement[i] = colorRequirementJSON.get(i).toString();
    }
  }
}
