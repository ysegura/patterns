import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class StateGui implements ActionListener {

    private JFrame mainFrame;

    private JPanel controlPanel, editPanel;

    private CalendarEditor calendarEditor;

    private JButton save, exit;

    public StateGui(CalendarEditor calendarEditor) {
        this.calendarEditor = calendarEditor;
    }

    public void createGui() {
        mainFrame = new JFrame("State pattern example");
        Container container = mainFrame.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        editPanel = new JPanel();
        editPanel.setLayout(new BorderLayout());
        JTable appointmentsTable = new JTable(
                new StateTableModel((Appointment[])calendarEditor.getAppointments().toArray(new Appointment[1])));
        editPanel.add(new JScrollPane(appointmentsTable));
        container.add(editPanel);

        controlPanel = new JPanel();
        save = new JButton("Save appointment");
        exit = new JButton("Exit");
        controlPanel.add(save);
        controlPanel.add(exit);
        container.add(controlPanel);

        save.addActionListener(this);
        exit.addActionListener(this);

        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object originator = event.getSource();
        if (originator == save) {
            saveAppointments();
        } else if (originator == exit) {
            exitApplication();
        }
    }

    private void saveAppointments() {
        calendarEditor.save();
    }

    private void exitApplication() {
        System.exit(0);
    }

    private class WindowCloseManager extends WindowAdapter {

        public void windowClosing(WindowEvent event) {
            exitApplication();
        }
    }

    private class StateTableModel extends AbstractTableModel {

        private final String[] columnNames = { "Appointment", "Contacts", "Location", "Start Date", "End Date" };

        private Appointment[] data;

        public StateTableModel(Appointment[] data) {
            this.data = data;
        }

        public String getColumnName(int column) {
            return columnNames[column];
        }

        public int getRowCount() {
            return data.length;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int row, int column) {
            Object value = null;
            switch (column) {
            case 0:
                value = data[row].getReason();
                break;
            case 1:
                value = data[row].getContacts();
                break;
            case 2:
                value = data[row].getLocation();
                break;
            case 3:
                value = data[row].getStartDate();
                break;
            case 4:
                value = data[row].getEndDate();
                break;
            }

            return value;
        }

        public boolean isCellEditable(int row, int column) {
            return ((column == 0) || (column == 2));
        }

        public void setValueAt(Object value, int row, int column) {
            switch (column) {
            case 0:
                data[row].setReason((String)value);
                calendarEditor.edit();
                break;
            case 1:
                break;
            case 2:
                data[row].setLocation(new LocationImpl((String)value));
                calendarEditor.edit();
                break;
            case 3:
                break;
            case 4:
                break;
            }
        }

    }

}
