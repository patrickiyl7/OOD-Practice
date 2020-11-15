/**
* Class Athlete contains information about an athlete, including athlete's name,
their height, weight and league.
*/
package assignment1;

import java.util.Objects;


public class Athlete {

  private Name athletesName;
  private Double height;
  private Double weight;
  private String league;

  /**
  * Constructs a new athlete, based upon all of the provided input parameters.
  * @param athletesName - object Name, containing athlete's first, middle and last
 name.
  * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is
 recorded as 187.96cm).
  * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155,
 200 pounds).
  * @param league - athelete's league, expressed as String.
  * @return - object Athlete.
  */
  public Athlete(Name athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }
 /**
 * Constructs a new athlete, based upon all of the provided input parameters.
 * @param athletesName - object Name, containing athlete's first, middle and last
name.
 * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is
recorded as 187.96cm).
 * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155,
200 pounds).
 * @return - object Athlete, with league field set to null.
 */

  public Athlete(Name athletesName, Double height, Double weight) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }

  /**
   * @Return athlete's name as an object Name.
   */
  public Name getAthletesName() {
    return athletesName;
  }

  /**
   * @Return athlete's height as a Double.
   */
  public Double getHeight() {
    return height;
  }

  /**
   * @Return athlete's weight as a Double.
   */
  public Double getWeight() {
    return weight;
  }

  /**
   * @Return athlete's league as a String.
   */
  public String getLeague() {
    return league;
  }

  /**
   * @equal function for the athlete class.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Athlete)) {
      return false;
    }
    Athlete athlete = (Athlete) o;
    return Objects.equals(getAthletesName(), athlete.getAthletesName()) &&
        Objects.equals(getHeight(), athlete.getHeight()) &&
        Objects.equals(getWeight(), athlete.getWeight()) &&
        Objects.equals(getLeague(), athlete.getLeague());
  }

  /**
   * @hashCode function for the athlete class.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getAthletesName(), getHeight(), getWeight(), getLeague());
  }

  /**
   * @toString function for the athlete class.
   */
  @Override
  public String toString() {
    return "Athlete{" +
        "athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
  }
}
