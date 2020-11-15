import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to read the TXT files.
 */
public class TXTFileReader {

  /**
   * Constructor of the TXTFileReader class.
   */
  public TXTFileReader() {
  }

  /**
   * Read in the data of the TXT files
   *
   * @param txtFilePath path of the current TXT file.
   * @return data stored in List of String.
   */
  public static List<String> readTemplateAndStore(String txtFilePath) {
    try {
      List<String> resData = new ArrayList<>();
      String basePath = System.getProperty("user.dir");
      String resCSVFilePath = basePath + "/" + txtFilePath;
      List<String> lines = Files.readAllLines(Paths.get(resCSVFilePath));
      for (String line : lines) {
        if (line != null) {
          resData.add(line);
        }
      }
      return resData;
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalArgumentException(e);
    }
  }
}
