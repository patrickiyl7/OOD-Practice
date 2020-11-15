package assignment1.problem2;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Filmmakers Class extends VideoArtist Class.
 */
public class Filmmakers extends VideoArtist {

  public Filmmakers(String firstName, String lastName, Integer age,
      ArrayList<String> genre,
      TreeMap<Integer, String> awards,
      ArrayList<Movies> movies, ArrayList<Series> series,
      ArrayList<OtherMultiMedia> otherMultiMedia) throws Exception {
    super(firstName, lastName, age, genre, awards, movies, series, otherMultiMedia);
  }
}
