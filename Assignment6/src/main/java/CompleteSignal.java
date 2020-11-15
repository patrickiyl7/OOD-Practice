
/**
 * A class to tell consumer process to stop when producer process is complete.
 */
public class CompleteSignal {
  private Boolean isCompleted;

  /**
   * Constructor of CompleteSignal class. default to false.
   * @param isCompleted check if the producer process is complete.
   */
  public CompleteSignal(Boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

  /**
   * getter of CompleteSignal class.
   * @return if the producer process is complete.
   */
  public synchronized Boolean getCompleted() {
    return isCompleted;
  }

  /**
   * setter of CompleteSignal class.
   * @param completed if the process is complete.
   */
  public synchronized void setCompleted(Boolean completed) {
    isCompleted = completed;
  }
}
