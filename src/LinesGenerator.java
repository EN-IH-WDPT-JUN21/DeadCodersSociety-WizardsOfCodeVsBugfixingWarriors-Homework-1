import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
used to create a list of names and a list of battle cries
 */
public class LinesGenerator {
  private final String SourceFile;

  public LinesGenerator(String sourceFile) {
    SourceFile = sourceFile;
  }
  /*
  reads file to a List of Strings
   */
  public List<String> getLines() {
    List<String> list = new ArrayList<>();

    // try to open file SourceFile
    File file = new File(SourceFile);
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    if (null == scanner) {
      // failed to open file
      return list;
    }

    // for each line in file
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      list.add(line);
    }
    scanner.close();
    return list;
  }
}
