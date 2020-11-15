package assignment1.package3;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents the Publication Class with title, authors, publishingYear and numOfCitations.
 */
public class Publication {

  String title;
  String[] authors;
  Integer publishingYear;
  Integer numberOfCitations;

  /**
   * Constructor of the Publication Class.
   * @param title
   * @param authors
   * @param publishingYear
   * @param numberOfCitations
   */
  public Publication(String title, String[] authors, Integer publishingYear,
      Integer numberOfCitations) {
    this.title = title;
    this.authors = authors;
    this.publishingYear = publishingYear;
    this.numberOfCitations = numberOfCitations;
  }

  /**
   * @return the Title of the Publication.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the Title of the Publication.
   * @param title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the authors of the Publication.
   */
  public String[] getAuthors() {
    return authors;
  }

  /**
   * Set the authors of the Publication.
   * @param authors
   */
  public void setAuthors(String[] authors) {
    this.authors = authors;
  }

  /**
   * @return the PublishingYear of the Publication.
   */
  public int getPublishingYear() { return publishingYear; }

  /**
   * Set the PublishingYear of the Publication.
   * @param publishingYear
   */
  public void setPublishingYear(int publishingYear) { this.publishingYear = publishingYear; }

  /**
   * @return the NumOfCitation of the Publication.
   */
  public int getNumberOfCitations() {
    return numberOfCitations;
  }

  /**
   * Set the NumOfCitation of the Publication.
   * @param numberOfCitations
   */
  public void setNumberOfCitations(int numberOfCitations) {
    this.numberOfCitations = numberOfCitations;
  }

  /**
   * @param numberOfCitations
   * @param publishingYear
   * @return the baseImpact with FreshnessBump of the Publication
   * @throws Exception when the Age of the Publication larger than 250 years.
   */
  public double baseImpactWithFreshnessBump(Integer numberOfCitations, Integer publishingYear)
      throws Exception {
    if (publishingYear == 2019) {
      return (double) numberOfCitations / 1;
    } else if (2019 - publishingYear > 250) {
      throw new ImpactEstimationException("Publication too old to estimate the impact");
    } else if (2019 - publishingYear < 3) {
      return (numberOfCitations / (double) (2019 - publishingYear)) + 100;
    } else {
      return (numberOfCitations / (double) (2019 - publishingYear));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Publication)) {
      return false;
    }
    Publication that = (Publication) o;
    return Objects.equals(getTitle(), that.getTitle()) &&
        Arrays.equals(getAuthors(), that.getAuthors()) &&
        Objects.equals(getPublishingYear(), that.getPublishingYear()) &&
        Objects.equals(getNumberOfCitations(), that.getNumberOfCitations());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getTitle(), getPublishingYear(), getNumberOfCitations());
    result = 31 * result + Arrays.hashCode(getAuthors());
    return result;
  }

  @Override
  public String toString() {
    return "Publication{" +
        "title='" + title + '\'' +
        ", authors=" + Arrays.toString(authors) +
        ", publishingYear=" + publishingYear +
        ", numberOfCitations=" + numberOfCitations +
        '}';
  }
}
