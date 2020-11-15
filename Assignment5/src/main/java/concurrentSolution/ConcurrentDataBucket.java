package concurrentSolution;

import java.util.HashMap;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A class contains the data structure that output files need.
 */
public class ConcurrentDataBucket {
  ConcurrentHashMap<String, BlockingQueue<String[]>> map;

  /**
   * Constructor of dataBucket class.
   */
  public ConcurrentDataBucket() {
    this.map = new ConcurrentHashMap<>();;
  }

  /**
   * dataMap getter
   * @return HashMap of HashMap contains data like courseId, date, click.
   */
  public ConcurrentHashMap<String, BlockingQueue<String[]>> getMap() {
    return map;
  }

}
