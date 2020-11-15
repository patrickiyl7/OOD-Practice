package assignment1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest {

  private Name athletesName = new Name("A", "B", "C");
  private Double height = 190.0;
  private Double weight = 170.0;
  private String league = "A";
  private Double bestFiveKTime = 10.0;
  private Double bestHalfMarathonTime = 10.0;
  private String favoriteRunningEvent = "T";
  private Double expectedBestFiveKTime = 10.0;
  private Double expectedBestHalfMarathonTime = 10.0;
  private String expectedFavoriteRunningEvent = "T";
  private Runner runner;
  private final String notRunnerPlayerClass = "This object belongs to String Class not Runner Class";

  @Before
  public void setUp() throws Exception {
    runner = new Runner(athletesName, height, weight, league, bestFiveKTime, bestHalfMarathonTime,
        favoriteRunningEvent);
  }

  @Test
  public void getBestFiveKTime() {
    Assert.assertEquals(runner.getBestFiveKTime(), expectedBestFiveKTime);
  }

  @Test
  public void setBestFiveKTime() {
    runner.setBestFiveKTime(bestFiveKTime);
    Assert.assertEquals(runner.getBestFiveKTime(), expectedBestFiveKTime);
  }

  @Test
  public void getBestHalfMarathonTime() {
    Assert.assertEquals(runner.getBestHalfMarathonTime(), expectedBestHalfMarathonTime);

  }

  @Test
  public void setBestHalfMarathonTime() {
    runner.setBestHalfMarathonTime(bestHalfMarathonTime);
    Assert.assertEquals(runner.getBestHalfMarathonTime(), expectedBestHalfMarathonTime);
  }

  @Test
  public void getFavoriteRunningEvent() {
    Assert.assertEquals(runner.getFavoriteRunningEvent(), expectedFavoriteRunningEvent);

  }

  @Test
  public void setFavoriteRunningEvent() {
    runner.setFavoriteRunningEvent(favoriteRunningEvent);
    Assert.assertEquals(runner.getFavoriteRunningEvent(), expectedFavoriteRunningEvent);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(runner.equals(runner));
    Assert.assertEquals(
        new Runner(athletesName, height, weight, league, bestFiveKTime, bestHalfMarathonTime,
            favoriteRunningEvent),
        new Runner(athletesName, height, weight, league, bestFiveKTime, bestHalfMarathonTime,
            favoriteRunningEvent));
    Assert.assertFalse(runner.equals(null));
    Assert.assertFalse(runner.equals(notRunnerPlayerClass));
  }

  @Test
  public void testHashCode() {
    assertEquals(runner.hashCode(),
        new Runner(athletesName, height, weight, league, bestFiveKTime, bestHalfMarathonTime,
            favoriteRunningEvent).hashCode());

  }

  @Test
  public void testToString() {
    String expectedString = "Runner{" +
        "bestFiveKTime=" + bestFiveKTime +
        ", bestHalfMarathonTime=" + bestHalfMarathonTime +
        ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
        '}';
    Assert.assertEquals(runner.toString(), expectedString);
  }
}