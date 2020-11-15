
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Consumer class to process the data and write out to csv files.
 */
public class Consumer implements Runnable {

  String currentCourse;
  CompleteSignal completeSignal;
  BlockingQueue<String[]> blockingQueue;
  HashSet<String> tmaSet;
  Integer modulePresentationLength;
  ConcurrentHashMap<String, Integer> latestDataPair;
  Integer threshold;
  Integer totalClicks;

  /**
   * Constructor of consumer class.
   * @param currentCourse currentCourse
   * @param completeSignal completeSignal
   * @param blockingQueue blockingQueue
   * @param modulePresentationLength modulePresentationLength
   * @param latestDataPair latestDataPair
   * @param tmaSet tmaSet
   * @param threshold threshold
   */
  public Consumer(String currentCourse, CompleteSignal completeSignal,
      BlockingQueue<String[]> blockingQueue, Integer modulePresentationLength,
      ConcurrentHashMap<String, Integer> latestDataPair, HashSet<String> tmaSet, Integer threshold) {
    this.currentCourse = currentCourse;
    this.completeSignal = completeSignal;
    this.blockingQueue = blockingQueue;
    this.modulePresentationLength = modulePresentationLength;
    this.latestDataPair = latestDataPair;
    this.tmaSet = tmaSet;
    this.threshold = threshold;
    this.totalClicks = 0;
  }

  /**
   * function to process the data and write out to csv files.
   */
  @Override
  public void run() {
    int firstDate = Integer.MAX_VALUE;
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
        totalClicks = currClick;
        latestDataPair.put(currDateClickPair[0], currClick);
        if(currDateClickPair[0].charAt(0) == '-')
        {
          int currDate = Integer.valueOf(currDateClickPair[0].substring(1)) * (-1);
          firstDate = Math.min(firstDate, currDate);
        }
        else
        {
          firstDate = Math.min(firstDate, Integer.valueOf(currDateClickPair[0]));
        }
      }

      //System.out.println(currDateClickPair[0]);
      //System.out.println(currDateClickPair[1]);

      //int currClick = Integer.parseInt(currDateClickPair[1]) + latestDataPair.getOrDefault(currDateClickPair[0], 0);
      //latestDataPair.put("7",7);
    }
    int activePeriod = modulePresentationLength - firstDate;
    double dailyAverageClicks = (double)totalClicks / activePeriod;
    /*if(currentCourse.equals("AAA_2013J"))
    {
      System.out.println(activePeriod);
      System.out.println(totalClicks);
      System.out.println(dailyAverageClicks);
    }
*/
    //System.out.println(latestDataPair.keySet());
    CSVFileWriterConcurrent.writeDataToFilesConcurrent(currentCourse, latestDataPair, dailyAverageClicks, modulePresentationLength, tmaSet);
    for(Integer clickNum : latestDataPair.values())
    {
      if(clickNum >= threshold)
      {
        CSVFileWriterConcurrent.writeActivityThresholdToFilesConcurrent("activity-threshold", currentCourse, latestDataPair);
      }
    }
  }
}
