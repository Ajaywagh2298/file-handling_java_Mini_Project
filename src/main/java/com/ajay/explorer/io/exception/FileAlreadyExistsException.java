package com.ajay.explorer.io.exception;

public class FileAlreadyExistsException extends Exception {

  public FileAlreadyExistsException() {
    super("File already exists, cannot create file");
  }

}
