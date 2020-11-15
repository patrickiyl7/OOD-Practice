import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class Grammar consists elements like title, description and contents;
 */
public class Grammar {
  private String grammarTitle;
  private String grammarDesc;
  private List<String> entries;
  private HashMap<String, InnerData> innerDataMap;

  /**
   * Constructor of Grammar;
   */
  public Grammar() {
    this.grammarTitle = "";
    this.grammarDesc = "";
    this.entries = new ArrayList<>();
    this.innerDataMap = new HashMap<>();
  }

  /**
   * grammarTitle getter.
   * @return grammarTitle.
   */
  public String getGrammarTitle() {
    return grammarTitle;
  }

  /**
   * grammarTitle setter.
   * @param grammarTitle grammarTitle
   */
  public void setGrammarTitle(String grammarTitle) {
    this.grammarTitle = grammarTitle;
  }

  /**
   * GrammarDescription getter.
   * @return GrammarDescription.
   */
  public String getGrammarDesc() {
    return grammarDesc;
  }

  /**
   * GrammarDescription setter.
   * @param grammarDesc GrammarDescription
   */
  public void setGrammarDesc(String grammarDesc) {
    this.grammarDesc = grammarDesc;
  }

  /**
   * entries getter.
   * @return entries.
   */
  public List<String> getEntries() {
    return entries;
  }

  /**
   * entries setter.
   * @param entries entries.
   */
  public void setEntries(List<String> entries) {
    this.entries = entries;
  }

  /**
   * innerDataMap getter.
   * @return innerDataMap
   */
  public HashMap<String, InnerData> getInnerDataMap() {
    return innerDataMap;
  }
}
