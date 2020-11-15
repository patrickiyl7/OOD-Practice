package sequentialSolution;

import java.util.HashMap;
import java.util.List;

/**
 * Class to process the csv file and write out results.
 */
public class Processor {

  /**
   * function to process the csv file and write out results.
   * @param args csv files and threshold.
   * @throws Exception to handle invalid input.
   */
  public static void Processor(String[] args) throws Exception {
    String coursesFilePath = args[0];
    String studentVlePath = args[1];
    //Problem1.DataBucket dataBucket = new Problem1.DataBucket();

    List<String[]> coursesInfo = CSVFileReader.readDataAndStore(coursesFilePath);
    List<String[]> studentVleInfo = CSVFileReader.readDataAndStore(studentVlePath);

    DataBucket dataBucket = new DataBucket();
    for (int i = 0; i < coursesInfo.size(); i++) {
      dataBucket.getMap()
          .put(coursesInfo.get(i)[0] + "_" + coursesInfo.get(i)[1], new HashMap<String, Integer>());
    }

    for (int i = 0; i < studentVleInfo.size(); i++) {
      if (dataBucket.getMap().containsKey(studentVleInfo.get(i)[0] + "_" + studentVleInfo.get(i)[1])) {
        HashMap<String, Integer> valueMap = dataBucket.getMap()
            .get(studentVleInfo.get(i)[0] + "_" + studentVleInfo.get(i)[1]);
        if (valueMap.get(studentVleInfo.get(i)[4]) != null) {
          valueMap.put(studentVleInfo.get(i)[4],
              valueMap.get(studentVleInfo.get(i)[4]) + Integer.valueOf(studentVleInfo.get(i)[5]));
        }
        else
        {
          valueMap.put(studentVleInfo.get(i)[4],
              Integer.valueOf(studentVleInfo.get(i)[5]));
        }
      }
    }
    for(String key : dataBucket.getMap().keySet())
    {
      /*System.out.print(key + " ");
      for (HashMap.Entry<String, Integer> entry : dataBucket.map.get(key).entrySet()) {
        System.out.print(entry.getKey() + " ");
        System.out.println(entry.getValue());*/
        // do something with key and
      CSVFileWriter.writeDataToFiles(key, dataBucket.getMap().get(key));
    }


  }
}
