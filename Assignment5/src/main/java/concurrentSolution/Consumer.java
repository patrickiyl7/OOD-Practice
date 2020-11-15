package concurrentSolution;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import sequentialSolution.CSVFileWriter;

/**
 * Consumer class to process the data and write out to csv files.
 */
public class Consumer implements Runnable {

  String currentCourse;
  CompleteSignal completeSignal;
  BlockingQueue<String[]> blockingQueue;
  ConcurrentHashMap<String, Integer> latestDataPair;
  Integer threshold;

  /**
   * Constructor of consumer class.
   * @param currentCourse currentCourse
   * @param completeSignal completeSignal
   * @param blockingQueue blockingQueue
   * @param latestDataPair latestDataPair
   * @param threshold threshold
   */
  public Consumer(String currentCourse, CompleteSignal completeSignal,
      BlockingQueue<String[]> blockingQueue,
      ConcurrentHashMap<String, Integer> latestDataPair, Integer threshold) {
    this.currentCourse = currentCourse;
    this.completeSignal = completeSignal;
    this.blockingQueue = blockingQueue;
    this.latestDataPair = latestDataPair;
    this.threshold = threshold;
  }

  /**
   * function to process the data and write out to csv files.
   */
  @Override
  public void run() {
    //System.out.println(currentCourse);
    while(!completeSignal.getCompleted() || blockingQueue.size() > 0)
    {
      //System.out.println(currentCourse);
      //System.out.println(completeSignal.getCompleted());
      //System.out.println(blockingQueue.size());
      String[] currDateClickPair = new String[0];
      if(blockingQueue.size() > 0)
      {
        try {
          currDateClickPair = blockingQueue.take();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      if(currDateClickPair.length == 2)
      {
        int prevClick = 0;
        int currClick = 0;
        //System.out.println(currDateClickPair[0]);
        if(this.latestDataPair.containsKey(currDateClickPair[0]))
        {
          prevClick = this.latestDataPair.get(currDateClickPair[0]);
        }
        else
        {
          this.latestDataPair.put(currDateClickPair[0], 0);
        }

        currClick = Integer.parseInt(currDateClickPair[1]);
        currClick += prevClick;
        latestDataPair.put(currDateClickPair[0], currClick);
      }
      //System.out.println(currDateClickPair[0]);
      //System.out.println(currDateClickPair[1]);

      //int currClick = Integer.parseInt(currDateClickPair[1]) + latestDataPair.getOrDefault(currDateClickPair[0], 0);
      //latestDataPair.put("7",7);
    }
    //System.out.println(currentCourse);
    //System.out.println(latestDataPair.keySet());
    CSVFileWriterConcurrent.writeDataToFilesConcurrent(currentCourse, latestDataPair);
    for(Integer clickNum : latestDataPair.values())
    {
      if(clickNum >= threshold)
      {
        CSVFileWriterConcurrent.writeActivityThresholdToFilesConcurrent("activity-threshold", currentCourse, latestDataPair);
      }
    }
  }
}
