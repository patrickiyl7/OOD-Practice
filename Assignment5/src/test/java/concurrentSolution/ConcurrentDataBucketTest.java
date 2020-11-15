package concurrentSolution;

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
}