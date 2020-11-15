import java.security.InvalidParameterException;
import java.util.*;

public class GenerateFiles {

  public static void GenerateResults(String[] args) throws Exception {
    Set<String> commandLineArguments = new HashSet<>();
    Set<String> standardLetterGenerationCommand = new HashSet<>();
    Set<String> standardEmailGenerationCommand = new HashSet<>();
    standardLetterGenerationCommand.add("--letter");
    standardLetterGenerationCommand.add("--letter-template");
    standardLetterGenerationCommand.add("--output-dir");
    standardLetterGenerationCommand.add("--csv-file");
    standardEmailGenerationCommand.add("--email");
    standardEmailGenerationCommand.add("--email-template");
    standardEmailGenerationCommand.add("--output-dir");
    standardEmailGenerationCommand.add("--csv-file");
    HashMap<String, String> pathFileConnection = new HashMap<>();
    for (int i = 0; i < args.length; i++) {
      commandLineArguments.add(args[i]);
      if (standardLetterGenerationCommand.contains(args[i])) {
        standardLetterGenerationCommand.remove(args[i]);
      }
      if (standardEmailGenerationCommand.contains(args[i])) {
        standardEmailGenerationCommand.remove(args[i]);
      }
      if (args[i].equals("--letter-template") || args[i].equals("--email-template") || args[i]
          .equals("--csv-file") || args[i].equals("--output-dir")) {
        if (i != args.length - 1) {
          pathFileConnection.put(args[i], args[i + 1]);
        } else {
          System.out.println("Error: No target file assigned after file generation command.");
          UsageReminder();
        }
      }
    }
    if ((!commandLineArguments.contains("--email") && !commandLineArguments.contains("--letter"))
        || commandLineArguments.size() != 7) {
      System.out.println("Error: Invalid Arguments, no --email or --letter specified.");
      UsageReminder();
      return;
    }

    String csvFilePath = pathFileConnection.get("--csv-file");
    //System.out.println(csvFilePath);
    List<String[]> clientInfo = CSVFileReader.readDataAndStore(csvFilePath);
    List<ClientInfo> clientInfoList = new ArrayList<>();
    for (int i = 0; i < clientInfo.size(); i++) {
      ClientInfo currClientInfo = new ClientInfo(clientInfo.get(i)[0], clientInfo.get(i)[1],
          clientInfo.get(i)[2], clientInfo.get(i)[3], clientInfo.get(i)[4], clientInfo.get(i)[5],
          clientInfo.get(i)[6], clientInfo.get(i)[7], clientInfo.get(i)[8], clientInfo.get(i)[9],
          clientInfo.get(i)[10], clientInfo.get(i)[11]);
      clientInfoList.add(currClientInfo);
    }
    //System.out.println(clientInfoList.size());
    if (standardLetterGenerationCommand.size() == 0) {
      String outputDirPath = pathFileConnection.get("--output-dir");
      String letterTemplatePath = pathFileConnection.get("--letter-template");
      List<String> letterTemplate = TXTFileReader.readTemplateAndStore(letterTemplatePath);
      for (int i = 0; i < clientInfoList.size(); i++) {
        TXTFileWriter.writeLettersToFiles(letterTemplate, clientInfoList.get(i), outputDirPath);
      }
      return;
    } else if (standardEmailGenerationCommand.size() == 0) {
      String outputDirPath = pathFileConnection.get("--output-dir");
      String emailTemplatePath = pathFileConnection.get("--email-template");
      //System.out.println(outputDirPath);
      List<String> emailTemplate = TXTFileReader.readTemplateAndStore(emailTemplatePath);
      for (int i = 0; i < clientInfoList.size(); i++) {
        TXTFileWriter.writeEmailsToFiles(emailTemplate, clientInfoList.get(i), outputDirPath);
      }
      return;
    }
    UsageReminder();
    return;
  }

  public static void UsageReminder() {
    System.out.println(" Usage:");
    System.out.println("\t--email only generate email messages");
    System.out.println("\t--email-template <file> accept a filename that holds the ");
    System.out.println("email template.");
    System.out.println("\tRequired if --email is used");
    System.out.println();
    System.out.println("\t\t --letter only generate letters");
    System.out.println("\t\t --letter-template <file> accept a filename that holds ");
    System.out.println("the email template.");
    System.out.println("\t\t\tRequired if --letter is used");
    System.out.println();
    System.out.println("\t\t --output-dir <path> accept the name of a folder, all ");
    System.out.println("output is placed in this folder");
    System.out.println();
    System.out.println("\t\t --csv-file <path> accept the name of the csv file to ");
    System.out.println("process");
    System.out.println();
    System.out.println("Examples:");
    System.out.println("\t\t --email --email-template email-template.txt --output-dir ");
    System.out.println("emails --csv-file customer.csv");
    System.out.println();
    System.out.println("\t\t --letter --letter-template letter-template.txt --output");
    System.out.println("dir letters --csv-file customer.csv");
  }


}
