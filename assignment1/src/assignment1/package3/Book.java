package assignment1.package3;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents the Book Class extends Publication
 * with added publishingCompany and numberOfPages.
 */
public class Book extends Publication {

  String publishingCompany;
  String numberOfPages;

  /**
   * Constructor of the Book Class.
   * @param title
   * @param authors
   * @param publishingYear
   * @param numberOfCitations
   * @param publishingCompany
   * @param numberOfPages
   */
  public Book(String title, String[] authors, int publishingYear, int numberOfCitations,
      String publishingCompany, String numberOfPages) {
    super(title, authors, publishingYear, numberOfCitations);
    this.publishingCompany = publishingCompany;
    this.numberOfPages = numberOfPages;
  }

  /**
   * @return the publishingCompany of the Book Class.
   */
  public String getPublishingCompany() {
    return publishingCompany;
  }

  /**
   * Set the publishingCompany of the Book.
   * @param publishingCompany
   */
  public void setPublishingCompany(String publishingCompany) {
    this.publishingCompany = publishingCompany;
  }

  /**
   * @return the numberOfPages of Book.
   */
  public String getNumberOfPages() {
    return numberOfPages;
  }

  /**
   * Set the numberOfPages of Book.
   * @param numberOfPages
   */
  public void setNumberOfPages(String numberOfPages) {
    this.numberOfPages = numberOfPages;
  }

  /**
   * @param baseImpact
   * @return the BookImpact based on basicImpact of Publication.
   */
  public double bookImpact(double baseImpact) {
    if (2019 - this.publishingYear < 3) {
      return (baseImpact - 100) * 4 + 100;
    } else {
      return 4 * baseImpact;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(getPublishingCompany(), book.getPublishingCompany()) &&
        Objects.equals(getNumberOfPages(), book.getNumberOfPages());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getPublishingCompany(), getNumberOfPages());
  }

  @Override
  public String toString() {
    return "Book{" +
        "publishingCompany='" + publishingCompany + '\'' +
        ", numberOfPages='" + numberOfPages + '\'' +
        ", title='" + title + '\'' +
        ", authors=" + Arrays.toString(authors) +
        ", publishingYear=" + publishingYear +
        ", numberOfCitations=" + numberOfCitations +
        '}';
  }
}
