package assignment1.problem2;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Actors Class extends VideoArtist Class.
 */
public class Actors extends VideoArtist {

  public Actors(String firstName, String lastName, int age,
      ArrayList<String> genre,
      TreeMap<Integer, String> awards,
      ArrayList<Movies> movies, ArrayList<Series> series,
      ArrayList<OtherMultiMedia> otherMultiMedia) throws Exception {
    super(firstName, lastName, age, genre, awards, movies, series, otherMultiMedia);
  }
}
