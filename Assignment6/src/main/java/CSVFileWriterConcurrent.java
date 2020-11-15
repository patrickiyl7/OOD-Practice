
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A class to write the CSV files.
 */
public class CSVFileWriterConcurrent {


  /**
   * write out the data of the CSV files
   *
   * @param csvOutputFilePath path of the current CSV file.
   * @param dataMap HashMap that contains String as date(key) and Integer as click(value).
   * @param dailyAverageClicks dailyAverageClicks
   * @param modulePresentationLength modulePresentationLength
   * @param tmaSet tmaSet
   */
  public static synchronized void writeDataToFilesConcurrent(String csvOutputFilePath,
      ConcurrentHashMap<String, Integer> dataMap, double dailyAverageClicks, int modulePresentationLength, HashSet<String> tmaSet) {
    final String fileName =
        System.getProperty("user.dir") + "/" + "out" + "/" + csvOutputFilePath + ".csv";
    File csvContainsData = new File(fileName);
    try {
      csvContainsData.createNewFile();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      //System.out.println(fileName);
      FileWriter fileW = new FileWriter(fileName);
      BufferedWriter buffW = new BufferedWriter(fileW);
      StringBuilder sb = new StringBuilder();
      for (HashMap.Entry<String, Integer> entry : dataMap.entrySet()) {
        String currDate = entry.getKey();
        int currDateClick = entry.getValue();
        sb.append("\"");
        sb.append(currDate);
        sb.append("\"");
        sb.append(",");
        sb.append("\"");
        sb.append(Double.valueOf(currDate) / modulePresentationLength);
        sb.append("\"");
        sb.append(",");
        sb.append("\"");
        sb.append(currDateClick);
        sb.append("\"");
        sb.append(",");
        sb.append("\"");
        sb.append((double)currDateClick/dailyAverageClicks);
        sb.append("\"");
        if(tmaSet.contains(currDate))
        {
          sb.append(",");
          sb.append("\"");
          sb.append("TMA");
          sb.append("\"");
        }
        else
        {
          sb.append(",");
          sb.append("\"");
          sb.append("\"");
        }
        sb.append("\n");
      }
      buffW.write(sb.toString());
      buffW.close();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public static synchronized void writeActivityThresholdToFilesConcurrent(String csvOutputFilePath, String currentCourse,
      ConcurrentHashMap<String, Integer> dataMap)
  {
    final String fileName =
        System.getProperty("user.dir") + "/" + "out" + "/" + csvOutputFilePath + ".csv";
    File csvContainsData = new File(fileName);
    try {
      csvContainsData.createNewFile();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      //System.out.println(fileName);
      FileWriter fileW = new FileWriter(fileName, true);
      BufferedWriter buffW = new BufferedWriter(fileW);
      StringBuilder sb = new StringBuilder();
      for (HashMap.Entry<String, Integer> entry : dataMap.entrySet()) {
        sb.append("\"");
        sb.append(currentCourse);
        sb.append("\"");
        sb.append(",");
        sb.append("\"");
        sb.append(entry.getKey());
        sb.append("\"");
        sb.append(",");
        sb.append("\"");
        sb.append(entry.getValue());
        sb.append("\"");
        sb.append("\n");
      }
      buffW.write(sb.toString());
      buffW.close();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
