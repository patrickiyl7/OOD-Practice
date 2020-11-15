
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A class contains the data structure that output files need.
 */
public class ConcurrentDataBucket {
  ConcurrentHashMap<String, BlockingQueue<String[]>> map;
  ConcurrentHashMap<String, Integer> coursePresentationLengthPair;
  ConcurrentHashMap<String, HashSet<String>> dateAssessmentTypePair;

  /**
   * Constructor of dataBucket class.
   */
  public ConcurrentDataBucket() {
    this.map = new ConcurrentHashMap<>();;
    this.coursePresentationLengthPair = new ConcurrentHashMap<>();
    this.dateAssessmentTypePair = new ConcurrentHashMap<>();
  }

  /**
   * dataMap getter
   * @return HashMap of HashMap contains data like courseId, date, click.
   */
  public ConcurrentHashMap<String, BlockingQueue<String[]>> getMap() {
    return map;
  }

  /**
   * CoursePresentationLengthPairMap getter
   * @return HashMap of HashMap contains data like courseId, prensentationLength.
   */
  public ConcurrentHashMap<String, Integer> getCoursePresentationLengthPair() {
    return coursePresentationLengthPair;
  }

  /**
   * CoursePresentationLengthPairMap getter
   * @return HashMap of HashMap contains data like courseId, Assessment type.
   */
  public ConcurrentHashMap<String, HashSet<String>> getDateAssessmentTypePair() {
    return dateAssessmentTypePair;
  }

}
