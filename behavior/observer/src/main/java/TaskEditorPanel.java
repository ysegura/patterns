import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TaskEditorPanel extends JPanel implements ActionListener, TaskChangeObserver {

    private JPanel controlPanel, editPanel;

    private JButton add, update, exit;

    private JTextField taskName, taskNotes, taskTime;

    private TaskChangeObservable notifier;

    private Task editTask;

    public TaskEditorPanel(TaskChangeObservable notifier) {
        this.notifier = notifier;
        createGui();
    }

    public void createGui() {
        setLayout(new BorderLayout());
        editPanel = new JPanel();
        editPanel.setLayout(new GridLayout(3, 2));
        taskName = new JTextField(20);
        taskNotes = new JTextField(20);
        taskTime = new JTextField(20);
        editPanel.add(new JLabel("Task Name"));
        editPanel.add(taskName);
        editPanel.add(new JLabel("Task Notes"));
        editPanel.add(taskNotes);
        editPanel.add(new JLabel("Time Required"));
        editPanel.add(taskTime);

        controlPanel = new JPanel();
        add = new JButton("Add task");
        update = new JButton("Update Task");
        exit = new JButton("Exit");
        controlPanel.add(add);
        controlPanel.add(update);
        controlPanel.add(exit);
        add.addActionListener(this);
        update.addActionListener(this);
        exit.addActionListener(this);

        add(controlPanel, BorderLayout.SOUTH);
        add(editPanel, BorderLayout.CENTER);
    }

    public void setTaskChangeObservable(TaskChangeObservable notifier) {
        this.notifier = notifier;
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == add) {
            double timeRequired = 0.0;
            try {
                timeRequired = Double.parseDouble(taskTime.getText());
            } catch (NumberFormatException ex) {
            }
            notifier.addTask(new Task(taskName.getText(), taskNotes.getText(), timeRequired));
        } else if (source == update) {
            editTask.setName(taskName.getText());
            editTask.setNotes(taskNotes.getText());
            try {
                editTask.setTimeRequired(Double.parseDouble(taskTime.getText()));
            } catch (NumberFormatException ex) {
            }
            notifier.updateTask(editTask);
        } else if (source == exit) {
            System.exit(0);
        }
    }

    @Override
    public void taskAdded(Task task) {
    }

    @Override
    public void taskChanged(Task task) {
    }

    @Override
    public void taskSelected(Task task) {
        editTask = task;
        taskName.setText(task.getName());
        taskNotes.setText(task.getNotes());
        taskTime.setText(task.getTimeRequired().toString());
    }
}
