import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

/**
 * Class of Processor.
 */
public class GrammarProcessor {

  public static final String basePath = System.getProperty("user.dir");
  public static final String GRAMMAR_FOLDER = basePath + "/" + "grammars" + "/";

  /**
   * processor function.
   */
  public static void processor() {
    welcomeDisplays();
    List<Grammar> grammarList = loadGrammarFromJson();
    grammarSelectAndGenerate(grammarList);
  }

  public static String processor1() {
    List<Grammar> grammarList = loadGrammarFromJson();
    Grammar selectedGrammar = grammarList.get(0);
    String entryPoint = selectedGrammar.getEntries()
        .get(new Random().nextInt(selectedGrammar.getEntries().size()));
    String resSentence = randomSentenceGenerate(entryPoint, selectedGrammar.getInnerDataMap());
    //System.out.println(resSentence);
    return resSentence;
  }

  /**
   * function of welcomeDisplays.
   */
  public static void welcomeDisplays() {
    System.out.println("Current GRAMMAR folder: " + GRAMMAR_FOLDER);
    System.out.println("Loading grammars...");
  }

  /**
   * loadGrammarFromJson function.
   * @return List of Grammar.
   */
  public static List<Grammar> loadGrammarFromJson() {
    List<Grammar> resGrammarList = new ArrayList<>();
    File[] grammarFiles = new File(GRAMMAR_FOLDER).listFiles();
    for (File grammarFile : grammarFiles) {
      String fileName = grammarFile.getName();
      //System.out.println(grammarFile);
      if (!fileName.equals(".DS_Store")) {
        String currFileName = GRAMMAR_FOLDER + fileName;
        //System.out.println("Opening: " + currFileName);
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.reader(new TypeReference<List<String>>() {
        });
        ;
        String jsonContent = "";
        try {
          Grammar grammar = new Grammar();
          jsonContent = new String(Files.readAllBytes(Paths.get(currFileName)));
          JsonNode rootNode = mapper.readTree(jsonContent);
          Iterator<Entry<String, JsonNode>> fields = rootNode.fields();
          while (fields.hasNext()) {
            Entry<String, JsonNode> jsonField = fields
                .next();   // refer from https://www.baeldung.com/jackson-json-node-tree-model
            String entryKey = jsonField.getKey();
            //System.out.println(entryKey);
            JsonNode data = jsonField.getValue();
            //System.out.println(data);
            String currData = data.toString().substring(1, data.toString().length() - 1);
            if (entryKey.equals("grammarTitle")) {
              grammar.setGrammarTitle(currData);
            } else if (entryKey.equals("grammarDesc")) {
              grammar.setGrammarDesc(currData);
            } else if (entryKey.equals("start")) {
              grammar.setEntries(reader.readValue(data));
              //System.out.println(grammar.getEntries().get(0));
            } else {
              //System.out.println(entryKey);
              if (!grammar.getInnerDataMap().containsKey(entryKey.toLowerCase())) {
                grammar.getInnerDataMap()
                    .put(entryKey.toLowerCase(), new InnerData(entryKey, reader.readValue(data)));
              } else {
                grammar.getInnerDataMap().get(entryKey.toLowerCase()).getData()
                    .add(reader.readValue(data));
              }
            }
          }
          resGrammarList.add(grammar);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return resGrammarList;
  }

  /**
   * grammarSelectAndGenerate function.
   * @param grammarList grammarList.
   */
  public static void grammarSelectAndGenerate(List<Grammar> grammarList) {
    Scanner input = new Scanner(System.in);
    int count = 0;
    while (true) {
      System.out.println("The following grammars are available:");
      for (int i = 0; i < grammarList.size(); i++) {
        Grammar grammar = grammarList.get(i);
        String availableGrammer = (i + 1) + ". " + grammar.getGrammarTitle();
        if (grammar.getGrammarDesc() != null) {
          availableGrammer += " ( " + grammar.getGrammarDesc() + ")";
        }
        System.out.println(availableGrammer);
      }
      String userSelection = "1";
      if(count > 0)
      {
        userSelection = "q";
      }
      if(input.hasNextLine()) {
        userSelection = input.nextLine().toLowerCase().trim();
      }
      if (userSelection.equals("q")) {
        return;
      }
      int userSelectionNum = Integer.parseInt(userSelection);
      if (userSelectionNum < 1 || userSelectionNum > grammarList.size()) {
        System.out.println("Please input valid number to select the grammar.");
        System.out.println();
        continue;
      }
      System.out.println();
      Grammar selectedGrammar = grammarList.get(userSelectionNum - 1);
      String entryPoint = selectedGrammar.getEntries()
          .get(new Random().nextInt(selectedGrammar.getEntries().size()));
      String resSentence = randomSentenceGenerate(entryPoint, selectedGrammar.getInnerDataMap());
      System.out.println(resSentence);
      System.out.println();
      System.out.println("Would you like another? (y/n)");
      while (true) {
        userSelection = "n";
        if(input.hasNextLine()) {
          userSelection = input.nextLine().toLowerCase().trim();
        }
        if (userSelection.equals("y")) {
          System.out.println();
          selectedGrammar = grammarList.get(userSelectionNum - 1);
          entryPoint = selectedGrammar.getEntries()
              .get(new Random().nextInt(selectedGrammar.getEntries().size()));
          resSentence = randomSentenceGenerate(entryPoint, selectedGrammar.getInnerDataMap());
          System.out.println(resSentence);
          System.out.println(" Would you like another? (y/n) ");
          System.out.println();
        } else if (userSelection.equalsIgnoreCase("n")) {
          break;
        }
      }
      count++;
    }
  }

  /**
   * randomSentenceGenerate function.
   * @param entryPoint entryPoint
   * @param innerDataHashMap innerDataHashMap
   * @return Sentence generated.
   */
  public static String randomSentenceGenerate(String entryPoint,
      HashMap<String, InnerData> innerDataHashMap) {
    //System.out.println(entryPoint);
    if (!entryPoint.contains("<") && !entryPoint.contains(">")) {
      return entryPoint;
    } else {
      String nextEntryKey = entryPoint.substring(entryPoint.indexOf("<") + 1, entryPoint.indexOf(">"));
      return randomSentenceGenerate(entryPoint.substring(0, entryPoint.indexOf("<")), innerDataHashMap)
          + randomSentenceGenerate(innerDataHashMap.get(nextEntryKey).getData().get(new Random().nextInt(innerDataHashMap.get(nextEntryKey).getData().size())), innerDataHashMap)
          + randomSentenceGenerate(entryPoint.substring(entryPoint.indexOf(">") + 1), innerDataHashMap);
    }
  }
}

