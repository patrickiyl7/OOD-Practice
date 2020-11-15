package assignment1.package3;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents the ConferenceProceeding Class extends Article Class
 * with conferenceName and conferenceLocation.
 */
public class ConferenceProceeding extends Article {

  private String conferenceName;
  private String conferenceLocation;


  /**
   * Constructor of ConferenceProceeding Class.
   * @param title
   * @param authors
   * @param publishingYear
   * @param numberOfCitations
   * @param conferenceName
   * @param conferenceLocation
   */
  public ConferenceProceeding(String title, String[] authors, int publishingYear,
      int numberOfCitations, String conferenceName, String conferenceLocation) {
    super(title, authors, publishingYear, numberOfCitations);
    this.conferenceName = conferenceName;
    this.conferenceLocation = conferenceLocation;
  }


  /**
   * @return the conferenceName of the ConferenceProceeding.
   */
  public String getConferenceName() {
    return conferenceName;
  }

  /**
   * Set the conferenceName of the ConferenceProceeding.
   * @param conferenceName
   */
  public void setConferenceName(String conferenceName) {
    this.conferenceName = conferenceName;
  }

  /**
   * @return the conferenceLocation of the ConferenceProceeding.
   */
  public String getConferenceLocation() {
    return conferenceLocation;
  }

  /**
   * Set the conferenceLocation of the ConferenceProceeding.
   * @param conferenceLocation
   */
  public void setConferenceLocation(String conferenceLocation) {
    this.conferenceLocation = conferenceLocation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ConferenceProceeding)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ConferenceProceeding that = (ConferenceProceeding) o;
    return Objects.equals(getConferenceName(), that.getConferenceName()) &&
        Objects.equals(getConferenceLocation(), that.getConferenceLocation());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getConferenceName(), getConferenceLocation());
  }

  @Override
  public String toString() {
    return "ConferenceProceeding{" +
        "conferenceName='" + conferenceName + '\'' +
        ", conferenceLocation='" + conferenceLocation + '\'' +
        ", title='" + title + '\'' +
        ", authors=" + Arrays.toString(authors) +
        ", publishingYear=" + publishingYear +
        ", numberOfCitations=" + numberOfCitations +
        '}';
  }
}
