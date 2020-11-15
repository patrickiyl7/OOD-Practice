package assignment1.problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VideoArtistTest {

  private VideoArtist videoArtist;
  private ArrayList<Movies> movies;
  private ArrayList<Series> series;
  private ArrayList<OtherMultiMedia> otherMultiMedia;
  private ArrayList<String> genre1;
  private TreeMap<Integer, String> awards1;

  @Before
  public void setUp() throws Exception {
    movies = new ArrayList<>();
    series = new ArrayList<>();
    otherMultiMedia = new ArrayList<>();
    movies.add(new Movies("Dark Knight", 2018));
    movies.add(new Movies("Dark Knight Rises", 2012));
    series.add(new Series("Batman", 3));
    otherMultiMedia.add(new OtherMultiMedia("test", "intro"));
    genre1 = new ArrayList<String>() {
      {
        add("A");
      }
    };
    awards1 = new TreeMap<Integer, String>(Collections.reverseOrder()) {
      {
        put(2018, "B");
      }
    };
    this.videoArtist = new VideoArtist("Christian", "Bale", 45, genre1, awards1, movies, series,
        otherMultiMedia);
  }

  @Test
  public void getMovies() {
    ArrayList<Movies> expectedMovies = new ArrayList<Movies>() {
      {
        add(new Movies("Dark Knight", 2018));
        add(new Movies("Dark Knight Rises", 2012));
      }
    };
    Assert.assertEquals(expectedMovies.get(0).getMovieName(),
        this.videoArtist.getMovies().get(0).getMovieName());
    Assert.assertEquals(expectedMovies.get(0).getReleaseDate(),
        this.videoArtist.getMovies().get(0).getReleaseDate());
    Assert.assertEquals(expectedMovies.get(1).getMovieName(),
        this.videoArtist.getMovies().get(1).getMovieName());
    Assert.assertEquals(expectedMovies.get(1).getReleaseDate(),
        this.videoArtist.getMovies().get(1).getReleaseDate());
  }

  @Test
  public void setMovies() {
  }

  @Test
  public void getSeries() {
    ArrayList<Series> expectedSeries = new ArrayList<Series>() {
      {
        add(new Series("Batman", 3));
      }
    };
    Assert.assertEquals(expectedSeries.get(0).getSeriesName(),
        this.videoArtist.getSeries().get(0).getSeriesName());
    Assert.assertEquals(expectedSeries.get(0).getSeriesLength(),
        this.videoArtist.getSeries().get(0).getSeriesLength());
  }

  @Test
  public void setSeries() {
  }

  @Test
  public void getOtherMultiMedia() {
    ArrayList<OtherMultiMedia> expectedOtherMultiMedia = new ArrayList<OtherMultiMedia>() {
      {
        add(new OtherMultiMedia("test", "intro"));
      }
    };
    Assert.assertEquals(expectedOtherMultiMedia.get(0).getMediaName(),
        this.videoArtist.getOtherMultiMedia().get(0).getMediaName());
    Assert.assertEquals(expectedOtherMultiMedia.get(0).getMediaIntro(),
        this.videoArtist.getOtherMultiMedia().get(0).getMediaIntro());
  }

  @Test
  public void setOtherMultiMedia() {
  }
}
