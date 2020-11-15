package concurrentSolution;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import sequentialSolution.CSVFileReader;

/**
 * Consumer class to process the data and interacts with consumer.
 */
public class Producer implements Runnable {
  ConcurrentDataBucket concurrentDataBucket;
  String studentVlePath;
  CompleteSignal completeSignal;

  /**
   * Constructor of Producer class.
   * @param studentVlePath studentVlePath
   * @param concurrentDataBucket concurrentDataBucket
   * @param completeSignal completeSignal
   */
  public Producer(String studentVlePath, ConcurrentDataBucket concurrentDataBucket, CompleteSignal completeSignal) {
    this.studentVlePath = studentVlePath;
    this.concurrentDataBucket = concurrentDataBucket;
    this.completeSignal = completeSignal;
  }

  /**
   * function to process the data and parse into consumer process.
   */
  @Override
  public void run() {
    //System.out.println("reached1");
    CSVFileReaderConcurrent.readDataAndStore(studentVlePath, concurrentDataBucket.getMap(), completeSignal);
  }
}
