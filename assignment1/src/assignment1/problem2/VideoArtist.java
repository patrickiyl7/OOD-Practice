package assignment1.problem2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

/**
 * represents the VideoArtist extends Artist Class with added features.
 * @author yihaoli
 */
public class VideoArtist extends Artist {

  private ArrayList<Movies> movies;
  private ArrayList<Series> series;
  private ArrayList<OtherMultiMedia> otherMultiMedia;


  /**
   * Constructor of the VideoArtist Class.
   * @param firstName
   * @param lastName
   * @param age
   * @param genre
   * @param awards
   * @param movies
   * @param series
   * @param otherMultiMedia
   * @throws Exception
   */
  public VideoArtist(String firstName, String lastName, int age, ArrayList<String> genre,
      TreeMap<Integer, String> awards, ArrayList<Movies> movies, ArrayList<Series> series,
      ArrayList<OtherMultiMedia> otherMultiMedia) throws Exception {
    super(firstName, lastName, age, genre, awards);
    this.movies = movies;
    this.series = series;
    this.otherMultiMedia = otherMultiMedia;
  }

  /**
   * @return the Movies VideoArtist worked in.
   */
  public ArrayList<Movies> getMovies() {
    return movies;
  }

  /**
   * Set the Movies that VideoArtist worked in.
   * @param movies
   */
  public void setMovies(ArrayList<Movies> movies) { this.movies = movies; }

  /**
   * @return the Series VideoArtist worked in.
   */
  public ArrayList<Series> getSeries() {
    return series;
  }

  /**
   * set the Series VideoArtist worked in.
   * @param series
   */
  public void setSeries(ArrayList<Series> series) { this.series = series; }

  /**
   * @return the Media VideoArtist worked in.
   */
  public ArrayList<OtherMultiMedia> getOtherMultiMedia() { return otherMultiMedia; }

  /**
   * set the Media VideoArtist worked in.
   * @param otherMultiMedia
   */
  public void setOtherMultiMedia(ArrayList<OtherMultiMedia> otherMultiMedia) {
    this.otherMultiMedia = otherMultiMedia;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof VideoArtist)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    VideoArtist that = (VideoArtist) o;
    return Objects.equals(getMovies(), that.getMovies()) &&
        Objects.equals(getSeries(), that.getSeries()) &&
        Objects.equals(getOtherMultiMedia(), that.getOtherMultiMedia());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMovies(), getSeries(), getOtherMultiMedia());
  }

  @Override
  public String toString() {
    return "VideoArtist{" +
        "movies=" + movies +
        ", series=" + series +
        ", otherMultiMedia=" + otherMultiMedia +
        '}';
  }
}
