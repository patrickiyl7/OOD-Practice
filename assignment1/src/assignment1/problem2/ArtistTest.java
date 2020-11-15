package assignment1.problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArtistTest {

  private Artist artist;

  @Before
  public void setUp() throws Exception {
    ArrayList<String> genre = new ArrayList<String>() {
      {
        add("A");
      }
    };
    TreeMap<Integer, String> awards = new TreeMap<Integer, String>(Collections.reverseOrder()) {
      {
        put(2018, "B");
        put(2016, "C");
        put(2019, "A");
      }
    };
    this.artist = new Artist("Patrick", "Li", 23, genre, awards);
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("Patrick", this.artist.getFirstName());
  }

  @Test
  public void setFirstName() {
  }

  @Test
  public void getLastName() {
    Assert.assertEquals("Li", this.artist.getLastName());
  }

  @Test
  public void setLastName() {
  }

  @Test
  public void getAge() {
    Assert.assertEquals(23, this.artist.getAge());
  }

  @Test
  public void setAge() {
  }

  @Test
  public void getGenre() {
    ArrayList<String> expectedGenre = new ArrayList<String>() {
      {
        add("A");
      }
    };
    Assert.assertEquals(expectedGenre, this.artist.getGenre());
  }

  @Test
  public void setGenre() {
  }

  @Test
  public void getAwards() {
    TreeMap<Integer, String> expectedAwards = new TreeMap<Integer, String>() {
      {
        put(2019, "A");
        put(2018, "B");
        put(2016, "C");
      }
    };
    Assert.assertEquals(expectedAwards, this.artist.getAwards());
  }

  @Test
  public void setAwards() {
  }

  @Test
  public void addGenre() {
    ArrayList<String> expectedGenre = new ArrayList<String>() {
      {
        add("A");
        add("V");
      }
    };
    this.artist.addGenre("V");
    Assert.assertEquals(expectedGenre, this.artist.getGenre());
  }

  @Test
  public void addAwards() {
    TreeMap<Integer, String> expectedAwards = new TreeMap<Integer, String>() {
      {
        put(2019, "A");
        put(2018, "B");
        put(2016, "C");
        put(2015, "D");
      }
    };
    this.artist.addAwards(2015, "D");
    Assert.assertEquals(expectedAwards, this.artist.getAwards());
  }


  @Test
  public void getMostRecentAwardYear() {
    int expectedYear = 2019;
    Assert.assertEquals(expectedYear, this.artist.getMostRecentAwardYear());
  }

  @org.junit.Rule
  public ExpectedException thrown1 = ExpectedException.none();

  @Test
  public void createArtistWithInvalidAgeException() throws Exception {
    thrown1.expect(Exception.class);
    thrown1.expectMessage("Artist age not valid");
    ArrayList<String> genre1 = new ArrayList<String>() {
      {
        add("A");
      }
    };
    TreeMap<Integer, String> awards1 = new TreeMap<Integer, String>(Collections.reverseOrder()) {
      {
        put(2018, "B");
      }
    };
    this.artist = new Artist("Invalid", "A", 223, genre1, awards1);
  }
}