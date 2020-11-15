package assignment1.package3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JournalTest {

  private Journal journal;
  private Journal journal1;

  @Before
  public void setUp() throws Exception {
    this.journal = new Journal("A", new String[]{"B", "C"}, 1999, 10, "publisher",
        new String[]{"e1", "e2"});
  }

  @Test
  public void getPublisher() {
    Assert.assertEquals("publisher", this.journal.getPublisher());
  }

  @Test
  public void getEditors() {
    Assert.assertArrayEquals(new String[]{"e1", "e2"}, this.journal.getEditors());
  }

  @Test
  public void journalImpact() throws Exception {
    assertEquals(1, this.journal.journalImpact(this.journal
        .baseImpactWithFreshnessBump(this.journal.getNumberOfCitations(),
            this.journal.getPublishingYear())), 0.0);
  }

  @Test
  public void journalImpactWithFreshBump() throws Exception {
    this.journal1 = new Journal("A", new String[]{"B", "C"}, 2018, 10, "publisher",
        new String[]{"e1", "e2"});
    assertEquals(120, this.journal1.journalImpact(this.journal1
        .baseImpactWithFreshnessBump(this.journal1.getNumberOfCitations(),
            this.journal1.getPublishingYear())), 0.0);
  }
}