import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GenerateFilesTest {

  private final String csvFilePath = "testclient.csv";
  private final CSVFileReader csvFileReader = new CSVFileReader();
  private final List<String[]> csvData = csvFileReader.readDataAndStore(csvFilePath);
  private final String[] args = new String[]{
      "--email", "--email-template", "emailtemplate.txt", "--output-dir", "testOut", "--csv-file", "insurancecompanymembers.csv"};
  private final int successfulArgumentsLength = 7;
  HashMap<String, String> pathFileConnection = new HashMap<>();

  @Test
  public void generateResults() throws Exception {
    assertEquals(args.length, successfulArgumentsLength);
    List<String[]> csvDataTest = csvFileReader.readDataAndStore(csvFilePath);
    for (int i = 0; i < csvDataTest.size(); i++) {
      Assert.assertArrayEquals(csvDataTest.get(i), csvData.get(i));
    }
    List<ClientInfo> clientInfoList = new ArrayList<>();
    for (int i = 0; i < csvDataTest.size(); i++) {
      ClientInfo currClientInfo = new ClientInfo(csvData.get(i)[0], csvData.get(i)[1],
          csvData.get(i)[2], csvData.get(i)[3], csvData.get(i)[4], csvData.get(i)[5],
          csvData.get(i)[6], csvData.get(i)[7], csvData.get(i)[8], csvData.get(i)[9],
          csvData.get(i)[10], csvData.get(i)[11]);
      clientInfoList.add(currClientInfo);
    }
    GenerateFiles.GenerateResults(args);
  }
}