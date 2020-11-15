
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to read the CSV files.
 */
public class CSVFileReader {

  /**
   * Constructor of the Problem1.CSVFileReader class.
   */
  public CSVFileReader() {
  }

  /**
   * Read in the data of the CSV files
   *
   * @param csvFilePath path of the current CSV file.
   * @return data stored in List of String array.
   */
  public static List<String[]> readDataAndStore(String csvFilePath) {
    try {
      List<String[]> resData = new ArrayList<>();
      String basePath = System.getProperty("user.dir");
      String resCSVFilePath = basePath + "/" + csvFilePath;
      List<String> lines = Files.readAllLines(Paths.get(resCSVFilePath));
      lines.remove(0);
      for (String line : lines) {
        String[] currData = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        for (int i = 0; i < currData.length; i++) {
          //System.out.println(currData[i]);
          currData[i] = currData[i].replace("\"", "");
          //System.out.println(currData[i]);
        }
        if (currData.length > 1) {
          resData.add(currData);
        }
      }
      return resData;
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalArgumentException(e);
    }
  }
}
