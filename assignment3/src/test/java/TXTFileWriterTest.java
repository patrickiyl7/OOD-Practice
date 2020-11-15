import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TXTFileWriterTest {

  private final String txtEmailPath = "emailtemplate.txt";
  private final String txtLetterPath = "lettertemplate.txt";
  private final TXTFileWriter txtFileWriter = new TXTFileWriter();
  private final TXTFileReader txtFileReader = new TXTFileReader();
  private final ClientInfo clientInfo = new ClientInfo("James", "Butt", "Benton, John B Jr",
      "6649 N Blue Gum St", "New Orleans", "Orleans", "LA", "70116", "504-621-8927", "504-845-1427",
      "jbutt@gmail.com", "http://www.bentonjohnbjr.com");
  private final ClientInfo clientInfo1 = new ClientInfo("Patrick", "Butt", "Benton, John B Jr",
      "6649 N Blue Gum St", "New Orleans", "Orleans", "LA", "70116", "504-621-8927", "504-845-1427",
      "jbutt@gmail.com", "http://www.bentonjohnbjr.com");
  private List<String> txtEmailData = new ArrayList<>();
  private List<String> txtLetterData = new ArrayList<>();

  @Before
  public void setUp() throws Exception {
    txtEmailData = TXTFileReader.readTemplateAndStore(txtEmailPath);
    txtLetterData = TXTFileReader.readTemplateAndStore(txtLetterPath);
  }

  @Test(expected = IllegalArgumentException.class)
  public void writeEmailsToFilesExceptionTest() {
    TXTFileWriter.writeEmailsToFiles(txtEmailData, clientInfo, "out");
  }

  @Test
  public void writeEmailsToFile() {
    TXTFileWriter.writeEmailsToFiles(txtEmailData, clientInfo1, "testOut");
  }

  @Test
  public void writeLettersToFiles() {
    TXTFileWriter.writeLettersToFiles(txtLetterData, clientInfo, "testOut");
  }
}