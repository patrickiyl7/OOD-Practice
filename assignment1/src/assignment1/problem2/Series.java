package assignment1.problem2;

import java.util.Objects;

/**
 * Represents the Series Class with seriesName and seriesLength.
 */
public class Series {

  private String seriesName;
  private int seriesLength;

  /**
   * Constructor of the Series class.
   * @param seriesName
   * @param seriesLength
   */
  public Series(String seriesName, int seriesLength) {
    this.seriesName = seriesName;
    this.seriesLength = seriesLength;
  }

  /**
   * @return the name of the Series.
   */
  public String getSeriesName() {
    return seriesName;
  }

  /**
   * Set the name of the Series.
   * @param seriesName
   */
  public void setSeriesName(String seriesName) {
    this.seriesName = seriesName;
  }

  /**
   * @return the length of the Series.
   */
  public int getSeriesLength() {
    return seriesLength;
  }

  /**
   * Set the length of the Series.
   * @param seriesLength
   */
  public void setSeriesLength(int seriesLength) { this.seriesLength = seriesLength; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Series)) {
      return false;
    }
    Series series = (Series) o;
    return getSeriesLength() == series.getSeriesLength() &&
        Objects.equals(getSeriesName(), series.getSeriesName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSeriesName(), getSeriesLength());
  }

  @Override
  public String toString() {
    return "Series{" +
        "seriesName='" + seriesName + '\'' +
        ", seriesLength=" + seriesLength +
        '}';
  }
}
