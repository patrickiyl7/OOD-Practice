import static org.junit.Assert.*;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ConcurrentProcessorTest {
  private final String[] args = new String[]{
      "courses.csv", "studentVle_test.csv", "5","assessments.csv"};
  private final List<String[]> csvData = CSVFileReader.readDataAndStore(args[0]);

  @Test
  public void concurrentProcessor() throws Exception {
    List<String[]> csvDataTest = CSVFileReader.readDataAndStore(args[0]);
    for (int i = 0; i < csvDataTest.size(); i++) {
      Assert.assertArrayEquals(csvDataTest.get(i), csvData.get(i));
    }
    ConcurrentProcessor.ConcurrentProcessor(args);
  }
}