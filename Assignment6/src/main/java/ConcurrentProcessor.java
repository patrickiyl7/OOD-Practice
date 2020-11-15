
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class to process the csv file and write out results.
 */
public class ConcurrentProcessor {
  private static final int DEFAULT_QUEUE_SIZE = 777777;

  /**
   * function to process the csv file and write out results.
   * @param args csv files and threshold.
   * @throws Exception to handle invalid input.
   */
  public static void ConcurrentProcessor(String[] args) throws Exception {
    String coursesFilePath = args[0];
    String studentVlePath = args[1];
    String threshold = args[2];
    String assessments = args[3];
    List<String[]> coursesInfo = CSVFileReader.readDataAndStore(coursesFilePath);
    List<String[]> assessmentsInfo = CSVFileReader.readDataAndStore(assessments);
    ConcurrentDataBucket dataBucket = new ConcurrentDataBucket();
    CompleteSignal completeSignal = new CompleteSignal(false);
    for (int i = 0; i < coursesInfo.size(); i++) {
      dataBucket.getMap().put(coursesInfo.get(i)[0] + "_" + coursesInfo.get(i)[1], new ArrayBlockingQueue<String[]>(DEFAULT_QUEUE_SIZE));
      dataBucket.getCoursePresentationLengthPair().put(coursesInfo.get(i)[0] + "_" + coursesInfo.get(i)[1], Integer.valueOf(coursesInfo.get(i)[2]));
    }
    for (int i = 0; i < assessmentsInfo.size(); i++) {
      if(assessmentsInfo.get(i)[3].equals("TMA"))
      {
        if(dataBucket.getDateAssessmentTypePair().get(assessmentsInfo.get(i)[0] + "_" + assessmentsInfo.get(i)[1]) != null)
        {
          dataBucket.getDateAssessmentTypePair().get(assessmentsInfo.get(i)[0] + "_" + assessmentsInfo.get(i)[1]).add(assessmentsInfo.get(i)[4]);
        }
        else
        {
          dataBucket.getDateAssessmentTypePair().put(assessmentsInfo.get(i)[0] + "_" + assessmentsInfo.get(i)[1], new HashSet<String>());
        }
      }
    }

    int consumerNumThread = dataBucket.getMap().size();
    final ExecutorService threadPool = Executors.newFixedThreadPool(consumerNumThread + 1);
    threadPool.submit(new Producer(studentVlePath, dataBucket, completeSignal));
    for(String currentCourse : dataBucket.getMap().keySet())
    {
      //System.out.println("reached" + currentCourse);
      threadPool.submit(new Consumer(currentCourse, completeSignal, dataBucket.getMap().get(currentCourse), dataBucket.getCoursePresentationLengthPair().get(currentCourse), new ConcurrentHashMap<>(), dataBucket.getDateAssessmentTypePair().get(currentCourse), Integer.parseInt(threshold)));
    }

    threadPool.shutdown();
    while(!threadPool.isTerminated());
  }
}
