import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class SingletonGui implements ActionListener {

    private static int historyCount;

    private JFrame mainFrame;

    private JTextArea display;

    private JButton newContact, newAppointment, undo, refresh, exit;

    private JPanel controlPanel, displayPanel;

    public void createGui(){
        mainFrame = new JFrame("Singleton Pattern Example");
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));

        displayPanel = new JPanel();
        display = new JTextArea(20, 60);
        display.setEditable(false);
        displayPanel.add(display);
        content.add(displayPanel);

        controlPanel = new JPanel();
        newContact = new JButton("Create Contact");
        newAppointment = new JButton("Create Appointment");
        undo = new JButton("UNDO");
        refresh = new JButton("Refresh");
        exit = new JButton("Exit");
        controlPanel.add(newContact);
        controlPanel.add(newAppointment);
        controlPanel.add(undo);
        controlPanel.add(refresh);
        controlPanel.add(exit);
        content.add(controlPanel);

        newContact.addActionListener(this);
        newAppointment.addActionListener(this);
        undo.addActionListener(this);
        refresh.addActionListener(this);
        exit.addActionListener(this);

        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        Object originator = e.getSource();

        if (originator == newContact) {
            addCommand(" New Contact");
        } else if (originator == newAppointment) {
            addCommand(" New Appointment");
        } else if (originator == undo) {
            undoCommand();
        } else if (originator == refresh) {
            refreshDisplay("");
        } else if (originator == exit) {
            exitApplication();
        }
    }

    private void addCommand(String command) {
        HistoryList.getInstance().addCommand((++historyCount) + ": " + command);
        refreshDisplay("Add command: " + command);
    }

    private void undoCommand() {
        Object result = HistoryList.getInstance().undoCommand();
        historyCount--;
        refreshDisplay("Undo command: " + result);
    }

    private void refreshDisplay(String actionMessage) {
        display.setText(actionMessage + "\nCOMMAND HISTORY:\n" + HistoryList.getInstance().toString());
    }

    private void exitApplication() {
        System.exit(0);
    }

    private class WindowCloseManager extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            exitApplication();
        }
    }
}
