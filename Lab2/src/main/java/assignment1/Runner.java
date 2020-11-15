package assignment1;

import java.util.Objects;

/**
 * Runner class contains runner info.
 */
public class Runner extends Athlete {

  private Double bestFiveKTime;
  private Double bestHalfMarathonTime;
  private String favoriteRunningEvent;

  /**
   * Constructor of Runner class.
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double bestFiveKTime, Double bestHalfMarathonTime, String favoriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.bestFiveKTime = bestFiveKTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Constructor of Runner class with no specified league.
   */
  public Runner(Name athletesName, Double height, Double weight, Double bestFiveKTime,
      Double bestHalfMarathonTime, String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.bestFiveKTime = bestFiveKTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * getBestFiveKTime function of Runner class.
   * @returns bestFiveKTime.
   */
  public Double getBestFiveKTime() {
    return bestFiveKTime;
  }

  /**
   * setBestFiveKTime function of Runner class.
   */
  public void setBestFiveKTime(Double bestFiveKTime) {
    this.bestFiveKTime = bestFiveKTime;
  }

  /**
   * getBestHalfMarathonTime function of Runner class.
   * @returns bestHalfMarathonTime.
   */
  public Double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  /**
   * setBestHalfMarathonTime function of Runner class.
   */
  public void setBestHalfMarathonTime(Double bestHalfMarathonTime) {
    this.bestHalfMarathonTime = bestHalfMarathonTime;
  }

  /**
   * getFavoriteRunningEvent function of Runner class.
   * @returns favoriteRunningEvent.
   */
  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
  }

  /**
   * setFavoriteRunningEvent function of Runner class.
   */
  public void setFavoriteRunningEvent(String favoriteRunningEvent) {
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * equals function of Runner class.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Runner)) {
      return false;
    }
    Runner runner = (Runner) o;
    return Double.compare(runner.getBestFiveKTime(), getBestFiveKTime()) == 0 &&
        Double.compare(runner.getBestHalfMarathonTime(), getBestHalfMarathonTime()) == 0 &&
        Objects.equals(getFavoriteRunningEvent(), runner.getFavoriteRunningEvent());
  }

  /**
   * hashCode function of Runner class.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getBestFiveKTime(), getBestHalfMarathonTime(), getFavoriteRunningEvent());
  }

  /**
   * toString function of Runner class.
   */
  @Override
  public String toString() {
    return "Runner{" +
        "bestFiveKTime=" + bestFiveKTime +
        ", bestHalfMarathonTime=" + bestHalfMarathonTime +
        ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
        '}';
  }
}
