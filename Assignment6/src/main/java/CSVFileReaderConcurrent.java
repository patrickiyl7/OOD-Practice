
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A class to read the CSV files.
 */
public class CSVFileReaderConcurrent {

  /**
   * Constructor of the Problem1.CSVFileReader class.
   */
  public CSVFileReaderConcurrent() {
  }

  /**
   * Read in the data of the CSV files
   *
   * @param csvFilePath path of the current CSV file.
   * @param map dataMap.
   * @param completeSignal completeSignal
   */
  public static void readDataAndStore(String csvFilePath, ConcurrentHashMap<String, BlockingQueue<String[]>> map, CompleteSignal completeSignal)
  {
    try {
      //System.out.println("reached producer");
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
        if (currData.length == 6) {
          String[] dateClickPair = new String[2];
          dateClickPair[0] = currData[4];
          dateClickPair[1] = currData[5];
          //System.out.println(dateClickPair[0]);
          //System.out.println(dateClickPair[1]);
          String courseId = currData[0] + "_" + currData[1];
          //System.out.println(courseId);
          BlockingQueue<String[]> blockingQueue = map.get(courseId);
          blockingQueue.add(dateClickPair);
        }
      }
      //System.out.println("reached");
      completeSignal.setCompleted(true);
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalArgumentException(e);
    }
  }
}
