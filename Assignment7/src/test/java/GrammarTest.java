import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

public class GrammarTest {
  Grammar grammar = new Grammar();
  @Test
  public void getGrammarTitle() {
    Assert.assertEquals(grammar.getGrammarTitle(), "");
  }

  @Test
  public void setGrammarTitle() {
    grammar.setGrammarTitle("A");
    Assert.assertEquals(grammar.getGrammarTitle(), "A");
  }

  @Test
  public void getGrammarDesc() {
    Assert.assertEquals(grammar.getGrammarDesc(), "");
  }

  @Test
  public void setGrammarDesc() {
    grammar.setGrammarDesc("A");
    Assert.assertEquals(grammar.getGrammarDesc(), "A");
  }

  @Test
  public void getEntries() {
    Assert.assertEquals(grammar.getEntries(), new ArrayList<>());
  }

  @Test
  public void setEntries() {
    Assert.assertEquals(grammar.getEntries(), new ArrayList<>());
  }

  @Test
  public void getInnerDataMap() {
    Assert.assertEquals(grammar.getInnerDataMap(), new HashMap<>());
  }
}