package assignment1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTest {

  private Name athletesName = new Name("A", "B", "C");
  private Double height = 190.0;
  private Double weight = 170.0;
  private String league = "A";
  private String team = "T";
  private Double averageBatting = 10.0;
  private Integer seasonHomeRun = 10;
  private String expectedTeam = "T";
  private Double expectedAverageBatting = 10.0;
  private Integer expectedSeasonHomeRun = 10;
  private BaseballPlayer baseballPlayer;
  private final String notBaseballPlayerClass = "This object belongs to String Class not BaseballPlayer Class";

  @Before
  public void setUp() throws Exception {
    baseballPlayer = new BaseballPlayer(athletesName, height, weight, league, team, averageBatting,
        seasonHomeRun);
  }

  @Test
  public void getTeam() {
    Assert.assertEquals(baseballPlayer.getTeam(), expectedTeam);
  }

  @Test
  public void setTeam() {
    baseballPlayer.setTeam(team);
    Assert.assertEquals(baseballPlayer.getTeam(), expectedTeam);
  }

  @Test
  public void getAverageBatting() {
    Assert.assertEquals(baseballPlayer.getAverageBatting(), expectedAverageBatting);
  }

  @Test
  public void setAverageBatting() {
    baseballPlayer.setAverageBatting(averageBatting);
    Assert.assertEquals(baseballPlayer.getAverageBatting(), expectedAverageBatting);
  }

  @Test
  public void getSeasonHomeRun() {
    Assert.assertEquals(baseballPlayer.getSeasonHomeRun(), expectedSeasonHomeRun);
  }

  @Test
  public void setSeasonHomeRun() {
    baseballPlayer.setSeasonHomeRun(seasonHomeRun);
    Assert.assertEquals(baseballPlayer.getSeasonHomeRun(), expectedSeasonHomeRun);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(baseballPlayer.equals(baseballPlayer));
    Assert.assertEquals(
        new BaseballPlayer(athletesName, height, weight, league, team, averageBatting,
            seasonHomeRun),
        new BaseballPlayer(athletesName, height, weight, league, team, averageBatting,
            seasonHomeRun));
    Assert.assertFalse(baseballPlayer.equals(null));
    Assert.assertFalse(baseballPlayer.equals(notBaseballPlayerClass));
  }

  @Test
  public void testHashCode() {
    assertEquals(baseballPlayer.hashCode(),
        new BaseballPlayer(athletesName, height, weight, league, team, averageBatting,
            seasonHomeRun).hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", averageBatting=" + averageBatting +
        ", seasonHomeRun=" + seasonHomeRun +
        '}';
    Assert.assertEquals(baseballPlayer.toString(), expectedString);
  }


}