package org.excellinter.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

  public static List<String> getLines(String fileName) {
    List<String> result = new ArrayList<>();
    try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
      String line = buffer.readLine();
      while (line != null) {
        result.add(line);
        line = buffer.readLine();
      }
    } catch (FileNotFoundException ex) {
      throw new RuntimeException(String.format("ERROR: cannot find file '%s'%n", fileName));
    } catch (IOException ex) {
      throw new RuntimeException(String.format("ERROR: cannot read file '%s'%n", fileName));
    }
    return result;
  }
}
