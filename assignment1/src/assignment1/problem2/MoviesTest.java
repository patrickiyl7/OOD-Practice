package assignment1.problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoviesTest {

  private Movies movie;

  @Before
  public void setUp() throws Exception {
    this.movie = new Movies("Dark Knight", 2018);
  }

  @Test
  public void getMovieName() {
    Assert.assertEquals("Dark Knight", movie.getMovieName());
  }

  @Test
  public void setMovieName() {
  }

  @Test
  public void getReleaseDate() {
    Assert.assertEquals(2018, movie.getReleaseDate());
  }

  @Test
  public void setReleaseDate() {
  }
}