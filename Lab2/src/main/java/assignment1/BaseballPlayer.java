package assignment1;

import java.util.Objects;

/**
 * BaseballPlayer class.
 */
public class BaseballPlayer extends Athlete {

  private String team;
  private Double averageBatting;
  private Integer seasonHomeRun;

  /**
   * Constructor of BaseballPlayer class.
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team,
      Double averageBatting, Integer seasonHomeRun) {
    super(athletesName, height, weight, league);
    this.averageBatting = averageBatting;
    this.seasonHomeRun = seasonHomeRun;
    this.team = team;
  }

  /**
   * Constructor of BaseballPlayer class with no specified league.
   * @params athletesName.
   * @params height.
   * @params weight.
   * @params team.
   * @params averageBatting.
   * @params seasonHomeRun.
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String team,
      Double averageBatting, Integer seasonHomeRun) {
    super(athletesName, height, weight);
    this.averageBatting = averageBatting;
    this.seasonHomeRun = seasonHomeRun;
    this.team = team;
  }

  /**
   * getTeam function of BaseballPlayer class.
   * @return team.
   */
  public String getTeam() {
    return team;
  }

  /**
   * setTeam function of BaseballPlayer class.
   * @params team.
   */
  public void setTeam(String team) {
    this.team = team;
  }

  /**
   * get Average batting score from BaseballPlayer.
   * @returns averageBatting.
   */
  public Double getAverageBatting() {
    return averageBatting;
  }

  /**
   * set Average batting score from BaseballPlayer.
   * @params averageBatting.
   */
  public void setAverageBatting(Double averageBatting) {
    this.averageBatting = averageBatting;
  }

  /**
   * get season home run score from BaseballPlayer.
   * @returns seasonHomeRun.
   */
  public Integer getSeasonHomeRun() {
    return seasonHomeRun;
  }

  /**
   * set season home run score from BaseballPlayer.
   * @params seasonHomeRun.
   */
  public void setSeasonHomeRun(Integer seasonHomeRun) {
    this.seasonHomeRun = seasonHomeRun;
  }

  /**
   * equals function for BaseballPlayer class.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BaseballPlayer)) {
      return false;
    }
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(getTeam(), that.getTeam()) &&
        Objects.equals(getAverageBatting(), that.getAverageBatting()) &&
        Objects.equals(getSeasonHomeRun(), that.getSeasonHomeRun());
  }

  /**
   * hashCode function for BaseballPlayer class.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getTeam(), getAverageBatting(), getSeasonHomeRun());
  }

  /**
   * toString function for BaseballPlayer class.
   */
  @Override
  public String toString() {
    return "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", averageBatting=" + averageBatting +
        ", seasonHomeRun=" + seasonHomeRun +
        '}';
  }
}
