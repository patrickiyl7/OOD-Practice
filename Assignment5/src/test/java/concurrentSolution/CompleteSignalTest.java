package concurrentSolution;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CompleteSignalTest {
  private CompleteSignal completeSignal = new CompleteSignal(false);
  @Test
  public void getCompleted() {
    Assert.assertEquals(completeSignal.getCompleted(), false);
  }

  @Test
  public void setCompleted() {
    completeSignal.setCompleted(false);
    Assert.assertEquals(completeSignal.getCompleted(), false);
  }
}