package assignment1.package3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PublicationTest {

  private Publication publication;
  private Publication publication1;

  @Before
  public void setUp() throws Exception {
    this.publication = new Publication("A", new String[]{"B", "C"}, 1999, 10);
  }

  @Test
  public void getTitle() {
    Assert.assertEquals("A", this.publication.getTitle());
  }

  @Test
  public void getAuthors() {
    Assert.assertArrayEquals(new String[]{"B", "C"}, this.publication.getAuthors());
  }

  @Test
  public void getPublishingYear() {
    Assert.assertEquals(1999, this.publication.getPublishingYear());
  }

  @Test
  public void getNumberOfCitations() {
    Assert.assertEquals(10, this.publication.getNumberOfCitations());
  }

  @Test
  public void baseImpactWithFreshnessBump() throws Exception {
    Assert.assertEquals(0.5, this.publication.baseImpactWithFreshnessBump(10, 1999), 0.0);
  }

  @Test
  public void baseImpactExceptionTest() throws Exception {
    try {
      this.publication1 = new Publication("D", new String[]{"B", "C"}, 1099, 10);
      this.publication1.baseImpactWithFreshnessBump(this.publication1.getNumberOfCitations(),
          this.publication1.getPublishingYear());
      fail("An exception should have been thrown");
    } catch (ImpactEstimationException e) {
      System.out.println(e.getMessage());
    }
  }
}