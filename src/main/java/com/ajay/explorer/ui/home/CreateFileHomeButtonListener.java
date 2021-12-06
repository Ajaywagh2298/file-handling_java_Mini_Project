package com.ajay.explorer.ui.home;

import com.ajay.explorer.io.FilesIO;
import com.ajay.explorer.io.exception.FileAlreadyExistsException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateFileHomeButtonListener implements ActionListener {

  JFrame f;

  @Override
  public void actionPerformed(ActionEvent e) {
    f = new JFrame();
    String filePath = JOptionPane.showInputDialog(f, "Enter the absolute file path");
    try {
      FilesIO.createFile(filePath);
    } catch (FileAlreadyExistsException ex) {
      JOptionPane.showMessageDialog(f, ex.getMessage());
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}

