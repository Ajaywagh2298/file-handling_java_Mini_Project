package com.ajay.explorer.io;

import com.ajay.explorer.io.exception.FileAlreadyExistsException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilesIO {

  public static void createFile(String filePath)
      throws FileAlreadyExistsException, IOException {
    if (filePath == null || filePath.isBlank()) {
      throw new IllegalArgumentException("dirPath or filePath must not be null!");
    }

    final File file = new File(filePath);
    final File folder = file.getParentFile();

    if (folder!= null && !folder.exists()) {
      folder.mkdirs();
    }

    if (file.exists()) {
      throw new FileAlreadyExistsException();
    } else {
      file.createNewFile();
    }
  }

  public static String readFile(String filePath)
      throws IOException {
    String read;
    if (filePath == null || filePath.isBlank()) {
      throw new IllegalArgumentException("fileName must not be null!");
    }

    Path path = Paths.get(filePath);
    if (Files.exists(path)) {
        read = Files.readAllLines(path).get(0);
    } else {
      throw new FileNotFoundException();
    }
    return read;
  }

  public static void writeFile(String filePath, String input)
      throws IOException {
    if (filePath == null || filePath.isBlank()) {
      throw new IllegalArgumentException("fileName must not be null!");
    }

    Path path = Paths.get(filePath);
    if (Files.exists(path)) {
        Files.writeString(path, input, StandardOpenOption.APPEND);

    } else {
      throw new FileNotFoundException();
    }
  }
}
