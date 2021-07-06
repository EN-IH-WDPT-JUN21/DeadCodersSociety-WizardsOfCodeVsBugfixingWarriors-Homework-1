import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinesGenerator {
  private String SourceFile;

  public LinesGenerator(String sourceFile) {
    SourceFile = sourceFile;
  }

  public List<String> getLines() {
    List<String> list = new ArrayList<>();

    File file = new File(SourceFile);
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    if (null == scanner) {
      return list;
    }

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      list.add(line);
    }
    scanner.close();
    return list;
  }
}
