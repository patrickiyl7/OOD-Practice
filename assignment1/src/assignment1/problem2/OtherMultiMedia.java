package assignment1.problem2;

import java.util.Objects;

/**
 * represents the Media Class with mediaName and mediaIntro information.
 */
public class OtherMultiMedia {

  private String mediaName;
  private String mediaIntro;

  /**
   * Constructor of the Media Class.
   * @param mediaName
   * @param mediaIntro
   */
  public OtherMultiMedia(String mediaName, String mediaIntro) {
    this.mediaName = mediaName;
    this.mediaIntro = mediaIntro;
  }

  /**
   * @return the name of the Media.
   */
  public String getMediaName() {
    return mediaName;
  }

  /**
   * set the name of the Media.
   * @param mediaName
   */
  public void setMediaName(String mediaName) {
    this.mediaName = mediaName;
  }

  /**
   * @return the intro of the Media.
   */
  public String getMediaIntro() {
    return mediaIntro;
  }

  /**
   * set the intro of the Media.
   * @param mediaIntro
   */
  public void setMediaIntro(String mediaIntro) {
    this.mediaIntro = mediaIntro;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OtherMultiMedia)) {
      return false;
    }
    OtherMultiMedia that = (OtherMultiMedia) o;
    return Objects.equals(getMediaName(), that.getMediaName()) &&
        Objects.equals(getMediaIntro(), that.getMediaIntro());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMediaName(), getMediaIntro());
  }

  @Override
  public String toString() {
    return "OtherMultiMedia{" +
        "mediaName='" + mediaName + '\'' +
        ", mediaIntro='" + mediaIntro + '\'' +
        '}';
  }
}
