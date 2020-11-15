package assignment1.problem2;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Poet Class extends Artist Class.
 */
public class Poet extends Artist {

  public Poet(String firstName, String lastName, int age, ArrayList<String> genre,
      TreeMap<Integer, String> awards) throws Exception {
    super(firstName, lastName, age, genre, awards);
  }
}
