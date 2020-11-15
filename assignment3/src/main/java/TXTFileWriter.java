import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to write the TXT files.
 */
public class TXTFileWriter {

  /**
   * Constructor of the TXTFileWriter class.
   */
  public TXTFileWriter() {
  }

  /**
   * write out the data to the TXT files using email templates.
   *
   * @param emailTemplate     path of the current TXT file.
   * @param clientInfo        info of the client.
   * @param txtOutputFilePath output path of the file.
   */
  public static void writeEmailsToFiles(List<String> emailTemplate, ClientInfo clientInfo,
      String txtOutputFilePath) {
    final String fileName =
        System.getProperty("user.dir") + "/" + txtOutputFilePath + "/" + "Email_for_"
            + clientInfo.getFirstName() + "." + clientInfo.getLastName() + ".txt";
    File dataOfEmailFiles = new File(fileName);
    if (dataOfEmailFiles.exists()) {
      throw new IllegalArgumentException("File already exists");
    } else {
      try {
        dataOfEmailFiles.createNewFile();
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        FileWriter fileW = new FileWriter(fileName);
        BufferedWriter buffW = new BufferedWriter(fileW);
        StringBuilder sb = new StringBuilder();
        for (String line : emailTemplate) {
          line = line.replaceAll("\\[\\[email", clientInfo.getEmail());
          line = line.replaceAll("\\[\\[first_name", clientInfo.getFirstName());
          line = line.replaceAll("\\[\\[last_name", clientInfo.getLastName());
          line = line.replaceAll("\\]", "");
          sb.append(line);
          sb.append("\n");
        }
        buffW.write(sb.toString());
        buffW.close();
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
  }

  /**
   * write out the data to the TXT files using letter templates.
   *
   * @param letterTemplate    path of the current TXT file.
   * @param clientInfo        info of the client.
   * @param txtOutputFilePath output path of the file.
   */
  public static void writeLettersToFiles(List<String> letterTemplate, ClientInfo clientInfo,
      String txtOutputFilePath) {
    final String fileName =
        System.getProperty("user.dir") + "/" + txtOutputFilePath + "/" + "Letter_for_"
            + clientInfo.getFirstName() + "_" + clientInfo.getLastName() + ".txt";
    File dataOfEmailFiles = new File(fileName);
    if (dataOfEmailFiles.exists()) {
      throw new IllegalArgumentException("File already exists");
    } else {
      try {
        dataOfEmailFiles.createNewFile();
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        FileWriter fileW = new FileWriter(fileName);
        BufferedWriter buffW = new BufferedWriter(fileW);
        StringBuilder sb = new StringBuilder();
        for (String line : letterTemplate) {
          line = line.replaceAll("\\[\\[email", clientInfo.getEmail());
          line = line.replaceAll("\\[\\[first_name", clientInfo.getFirstName());
          line = line.replaceAll("\\[\\[last_name", clientInfo.getLastName());
          line = line.replaceAll("\\[\\[company_name", clientInfo.getCompanyName());
          line = line.replaceAll("\\[\\[address", clientInfo.getAddress());
          line = line.replaceAll("\\[\\[county", clientInfo.getCounty());
          line = line.replaceAll("\\[\\[state", clientInfo.getState());
          line = line.replaceAll("\\[\\[zip", clientInfo.getZip());
          line = line.replaceAll("\\[\\[email", clientInfo.getEmail());
          line = line.replaceAll("\\[\\[city", clientInfo.getCity());
          line = line.replaceAll("\\]", "");
          sb.append(line);
          sb.append("\n");
        }
        buffW.write(sb.toString());
        buffW.close();
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
  }
}
