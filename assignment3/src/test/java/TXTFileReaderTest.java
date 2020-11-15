import static org.junit.Assert.*;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TXTFileReaderTest {

  private final String txtFilePath = "emailtemplate.txt";
  private final TXTFileReader txtFileReader = new TXTFileReader();
  private final List<String> txtData = txtFileReader.readTemplateAndStore(txtFilePath);
  @Test
  public void readTemplateAndStore() {
    List<String> txtDataTest = txtFileReader.readTemplateAndStore(txtFilePath);
    Assert.assertEquals(txtDataTest, txtData);
  }
}