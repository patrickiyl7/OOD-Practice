package assignment1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AthleteTest {

  private Name athletesName = new Name("A", "B", "C");
  private Double height = 190.0;
  private Double weight = 170.0;
  private String league = "A";
  private Name expectedAthletesName = athletesName;
  private Double expectedHeight = 190.0;
  private Double expectedWeight = 170.0;
  private String expectedLeague = "A";
  private Athlete athlete;
  private final String notAthleteClass = "This object belongs to String Class not Athlete Class";

  @Before
  public void setUp() throws Exception {
    athlete = new Athlete(athletesName, height, weight, league);
  }

  @Test
  public void getAthletesName() {
    Assert.assertEquals(athlete.getAthletesName(), expectedAthletesName);
  }

  @Test
  public void getHeight() {
    Assert.assertEquals(athlete.getHeight(), expectedHeight);
  }

  @Test
  public void getWeight() {
    Assert.assertEquals(athlete.getWeight(), expectedWeight);
  }

  @Test
  public void getLeague() {
    Assert.assertEquals(athlete.getLeague(), expectedLeague);
  }

  @Test
  public void testEquals() {
    Athlete athleteTest = new Athlete(new Name("D", "E", "F"), 200.0, 300.0, "B");
    Assert.assertTrue(athlete.equals(athlete));
    Assert.assertFalse(athlete.equals(athleteTest));
    Assert.assertEquals(new Athlete(athletesName, height, weight, league),
        new Athlete(athletesName, height, weight, league));
    Assert.assertFalse(athlete.equals(null));
    Assert.assertFalse(athlete.equals(notAthleteClass));
  }

  @Test
  public void testHashCode() {
    assertEquals(athlete.hashCode(), new Athlete(athletesName, height, weight, league).hashCode());
  }

  @Test
  public void testToString() {
    String expectedString = "Athlete{" +
        "athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
    Assert.assertEquals(athlete.toString(), expectedString);
  }
}