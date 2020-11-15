package sequentialSolution;

import java.util.HashMap;

/**
 * A class contains the data structure that output files need.
 */
public class DataBucket {
  HashMap<String, HashMap<String, Integer>> map;

  /**
   * Constructor of dataBucket class.
   */
  public DataBucket() {
    this.map = new HashMap<>();
  }

  /**
   * dataMap getter
   * @return HashMap of HashMap contains data like courseId, date, click.
   */
  public HashMap<String, HashMap<String, Integer>> getMap() {
    return map;
  }

}
