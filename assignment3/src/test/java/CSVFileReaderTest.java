import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CSVFileReaderTest {

  private final String csvFilePath = "insurancecompanymembers.csv";
  private final CSVFileReader csvFileReader = new CSVFileReader();
  private final List<String[]> csvData = csvFileReader.readDataAndStore(csvFilePath);

  @Test
  public void readDataAndStore() {
    List<String[]> csvDataTest = csvFileReader.readDataAndStore(csvFilePath);
    for(int i = 0; i < csvDataTest.size(); i++)
    {
        Assert.assertArrayEquals(csvDataTest.get(i), csvData.get(i));
    }
  }
}