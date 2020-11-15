package assignment1.package3;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents the Journal Class extends Article with added publisher and editors features.
 */
public class Journal extends Article {

  private String publisher;
  private String[] editors;


  /**
   * Constructor of the Journal Class.
   * @param title
   * @param authors
   * @param publishingYear
   * @param numberOfCitations
   * @param publisher
   * @param editors
   */
  public Journal(String title, String[] authors, int publishingYear, int numberOfCitations,
      String publisher, String[] editors) {
    super(title, authors, publishingYear, numberOfCitations);
    this.publisher = publisher;
    this.editors = editors;
  }

  /**
   * @return the publisher of the Journal.
   */
  public String getPublisher() {
    return publisher;
  }

  /**
   * set the publisher of the Journal.
   * @param publisher
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  /**
   * @return the editors of the Journal
   */
  public String[] getEditors() {
    return editors;
  }

  /**
   * set the editors of the journal.
   * @param editors
   */
  public void setEditors(String[] editors) {
    this.editors = editors;
  }

  /**
   * @param baseImpact
   * @return the Impact of the Journal type of Publication.
   */
  public double journalImpact(double baseImpact) {
    if (2019 - this.publishingYear < 3) {
      return (baseImpact - 100) * 2 + 100;
    } else {
      return 2 * baseImpact;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Journal)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Journal journal = (Journal) o;
    return Objects.equals(getPublisher(), journal.getPublisher()) &&
        Arrays.equals(getEditors(), journal.getEditors());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(super.hashCode(), getPublisher());
    result = 31 * result + Arrays.hashCode(getEditors());
    return result;
  }

  @Override
  public String toString() {
    return "Journal{" +
        "publisher='" + publisher + '\'' +
        ", editors=" + Arrays.toString(editors) +
        ", title='" + title + '\'' +
        ", authors=" + Arrays.toString(authors) +
        ", publishingYear=" + publishingYear +
        ", numberOfCitations=" + numberOfCitations +
        '}';
  }
}
