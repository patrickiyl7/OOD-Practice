import java.util.List;

/**
 * Class of InnerData.
 */
public class InnerData {
  String entryKey;
  List<String> data;

  /**
   * Constructor of InnerData.
   * @param entryKey entryKey
   * @param data data
   */
  public InnerData(String entryKey, List<String> data) {
    this.entryKey = entryKey;
    this.data = data;
  }

  /**
   * innerData getter
   * @return List of String contains data.
   */
  public List<String> getData() {
    return data;
  }

}
