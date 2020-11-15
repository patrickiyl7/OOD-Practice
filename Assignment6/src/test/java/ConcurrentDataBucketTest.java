import static org.junit.Assert.*;

import java.util.concurrent.ConcurrentHashMap;
import org.junit.Assert;
import org.junit.Test;

public class ConcurrentDataBucketTest {
  ConcurrentDataBucket concurrentDataBucket = new ConcurrentDataBucket();
  @Test
  public void getMap() {
    Assert.assertEquals(concurrentDataBucket.getMap(), new ConcurrentHashMap<>());
  }

  @Test
  public void getCoursePresentationLengthPair() {
    Assert.assertEquals(concurrentDataBucket.getCoursePresentationLengthPair(), new ConcurrentHashMap<>());
  }

  @Test
  public void getDateAssessmentTypePair() {
    Assert.assertEquals(concurrentDataBucket.getDateAssessmentTypePair(), new ConcurrentHashMap<>());
  }
}