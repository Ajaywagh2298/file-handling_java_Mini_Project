package com.ajay.explorer.ui.home;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame {

  static JFrame homeFrame;

  static JButton createFileButton;
  static JButton readFileButton;
  static JButton writeFileButton;
  static JLabel headerLabel;

  public static void start() {
    homeFrame = new JFrame();

    headerLabel = new JLabel("Simple File Operations");
    headerLabel.setVerticalAlignment(JLabel.CENTER);
    headerLabel.setHorizontalAlignment(JLabel.CENTER);

    createFileButton = new JButton("Create a File");
    createFileButton.addActionListener(new CreateFileHomeButtonListener());
    readFileButton = new JButton("Read a File");
    readFileButton.addActionListener(new ReadFileHomeButtonListener());
    writeFileButton = new JButton("Write to a File");
    writeFileButton.addActionListener(new WriteFileHomeButtonListener());

    JPanel panel = new JPanel(new GridLayout(2, 1,0,0));
    panel.add(headerLabel);
    JPanel buttonsGrid =  new JPanel(new GridLayout(1, 3,10,10));
    buttonsGrid.add(createFileButton);
    buttonsGrid.add(readFileButton);
    buttonsGrid.add(writeFileButton);

    panel.add(buttonsGrid);
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    homeFrame.add(panel);

    homeFrame.setSize(600, 200);
    homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    homeFrame.setVisible(true);

  }

}
