package assignment1.problem2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Represents an Artist with their details--firstName, lastName, age, genre and awards.
 */
public class Artist {

  private String firstName;
  private String lastName;
  private Integer age;
  private ArrayList<String> genre;
  private TreeMap<Integer, String> awards;


  /**
   * @param firstName
   * @param lastName
   * @param age
   * @param genre
   * @param awards
   * @throws Exception while the input age is not in the valid range.
   */
  public Artist(String firstName, String lastName, Integer age, ArrayList<String> genre,
      TreeMap<Integer, String> awards) throws Exception {
    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("Artist age not valid");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.genre = new ArrayList<>();
    this.awards = new TreeMap<>();
  }

  /**
   * @return the firstName of the Artist.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * set the firstName of the Artist.
   *
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName of the Artist.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * set the lastName of the Artist.
   *
   * @param lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the age of the Artist
   */
  public int getAge() {
    return age;
  }

  /**
   * set the age of the Artist.
   * @param age
   */
  public void setAge(Integer age) {
    this.age = age;
  }

  /**
   * @return the genre of the Artist.
   */
  public ArrayList<String> getGenre() {
    return genre;
  }

  /**
   * set the genre of the Artist.
   * @param genre
   */
  public void setGenre(ArrayList<String> genre) {
    this.genre = genre;
  }

  /**
   * @return the awards of the Artist.
   */
  public TreeMap<Integer, String> getAwards() {
    return awards;
  }

  /**
   * set the awards of the Artist.
   * @param awards
   */
  public void setAwards(TreeMap<Integer, String> awards) {
    this.awards = awards;
  }

  /**
   * add genre to some artist.
   * @param newGenre
   */
  public void addGenre(String newGenre) {
    this.genre.add(newGenre);
  }

  /**
   * add awards with received year and intro to artist.
   * @param awardedYear
   * @param awardName
   */
  public void addAwards(Integer awardedYear, String awardName) {
    this.awards.put(awardedYear, awardName);
  }

  /**
   * @return the most recent year when the artist received the awards.
   */
  public int getMostRecentAwardYear() {
    return this.awards.firstKey();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Artist)) {
      return false;
    }
    Artist artist = (Artist) o;
    return Objects.equals(getFirstName(), artist.getFirstName()) &&
        Objects.equals(getLastName(), artist.getLastName()) &&
        Objects.equals(getAge(), artist.getAge()) &&
        Objects.equals(getGenre(), artist.getGenre()) &&
        Objects.equals(getAwards(), artist.getAwards());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName(), getAge(), getGenre(), getAwards());
  }

  @Override
  public String toString() {
    return "Artist{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        ", genre=" + genre +
        ", awards=" + awards +
        '}';
  }
}
