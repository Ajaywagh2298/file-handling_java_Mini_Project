package com.ajay.explorer.ui.home;

import com.ajay.explorer.io.FilesIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadFileHomeButtonListener implements ActionListener {
  private JFrame frame = new JFrame("My JFrame Example");
  @Override
  public void actionPerformed(ActionEvent e) {

    JFileChooser fileChooser = new JFileChooser();
    File selectedFile = null;
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    int result = fileChooser.showOpenDialog(null);
    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt");
    fileChooser.setFileFilter(filter);
    if (result == JFileChooser.APPROVE_OPTION) {
      selectedFile = fileChooser.getSelectedFile();
      System.out.println("Selected file: " + selectedFile.getAbsolutePath());
    }
    String text= "";
    try {
      text = FilesIO.readFile(selectedFile.getAbsolutePath());
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    JTextArea textArea = new JTextArea(6, 25);
    textArea.setText(text);
    textArea.setEditable(false);

    // wrap a scrollpane around it
    JScrollPane scrollPane = new JScrollPane(textArea);

    // display them in a message dialog
    JOptionPane.showMessageDialog(frame, scrollPane);
    System.out.println(textArea.getText());

  }
}
