package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditorGUI implements ActionListener{

    private JFrame mainFrame;
    private JTextArea display;
    private JButton update, exit;
    private JPanel controlPanel, displayPanel, editorPanel;
    private ItemEditor editor;

    public EditorGUI(ItemEditor editor){
        this.editor = editor;
    }

    public void createGui(){
        mainFrame = new JFrame("Factory Pattern Example");
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        editorPanel = new JPanel();
        editorPanel.add(editor.getGUI());
        content.add(editorPanel);

        displayPanel = new JPanel();
        display = new JTextArea(10, 40);
        display.setEditable(false);
        displayPanel.add(display);
        content.add(displayPanel);

        controlPanel = new JPanel();
        update = new JButton("Update Item");
        exit = new JButton("Exit");

        controlPanel.add(update);
        controlPanel.add(exit);
        content.add(controlPanel);

        update.addActionListener(this);
        exit.addActionListener(this);

        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent event){
        Object originator = event.getSource();
        if (originator == update){
            updateItem();
        }else if (originator == exit){
            exitApplication();
        }
    }

    private class WindowCloseManager extends WindowAdapter{

        @Override public void windowClosing(WindowEvent e) {
            exitApplication();
        }
    }

    private void updateItem(){
        editor.commitChanges();
        display.setText(editor.toString());
    }

    private void exitApplication(){
        System.exit(0);
    }
}
