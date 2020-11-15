package assignment1.problem2;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Painter Class extends Artist Class.
 */
public class Painter extends Artist {

  public Painter(String firstName, String lastName, int age, ArrayList<String> genre,
      TreeMap<Integer, String> awards) throws Exception {
    super(firstName, lastName, age, genre, awards);
  }
}
