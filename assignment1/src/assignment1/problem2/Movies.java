package assignment1.problem2;

import java.util.Objects;

/**
 * represents Movies with movieName and releaseDate.
 *
 * @author yihaoli
 */
public class Movies {

  private String movieName;
  private Integer releaseDate;

  /**
   * Constructor of the Movies Class.
   *
   * @param movieName
   * @param releaseDate
   */
  public Movies(String movieName, Integer releaseDate) {
    this.movieName = movieName;
    this.releaseDate = releaseDate;
  }

  /**
   * @return the name of the movie.
   */
  public String getMovieName() {
    return movieName;
  }

  /**
   * set the name of the movie.
   *
   * @param movieName
   */
  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  /**
   * @return the releaseDate of the movie.
   */
  public int getReleaseDate() {
    return releaseDate;
  }

  /**
   * set the releaseDate of the movie.
   * @param releaseDate
   */
  public void setReleaseDate(Integer releaseDate) {
    this.releaseDate = releaseDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Movies)) {
      return false;
    }
    Movies movies = (Movies) o;
    return Objects.equals(getMovieName(), movies.getMovieName()) &&
        Objects.equals(getReleaseDate(), movies.getReleaseDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMovieName(), getReleaseDate());
  }

  @Override
  public String toString() {
    return "Movies{" +
        "movieName='" + movieName + '\'' +
        ", releaseDate=" + releaseDate +
        '}';
  }
}
