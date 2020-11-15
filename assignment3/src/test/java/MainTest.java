import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

  private SecurityManager m;

  @Before
  public void setUp()
  {
    m = System.getSecurityManager();
  }

  @Test
  public void main() {
    try {
      new GenerateFiles().GenerateResults(new String[] {"--email --email-template emailtemplate.txt --output-dir out --csv-file"});
    } catch (SecurityException se) {
      assertEquals("1", se.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @Test
  public void mainTestWrongArguments() throws Exception {
    new GenerateFiles().GenerateResults(new String[] {"--email --email-template emailtemplate.txt --output-dir out --csv-file"});
  }
}