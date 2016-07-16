import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TaskSelectorPanel extends JPanel implements ActionListener, TaskChangeObserver {

    private JComboBox selector = new JComboBox();
    private TaskChangeObservable notifier;

    public TaskSelectorPanel(TaskChangeObservable notifier) {
        this.notifier = notifier;
        createGui();
    }

    public void createGui(){
        selector = new JComboBox();
        selector.addActionListener(this);
        add(selector);
    }

    public void setTaskChangeObservable(TaskChangeObservable notifier){
        this.notifier = notifier;
    }

    @Override
    public void taskAdded(Task task) {
        selector.addItem(task);
    }

    @Override
    public void taskChanged(Task task) {

    }

    @Override
    public void taskSelected(Task task) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        notifier.selectTask((Task)selector.getSelectedItem());
    }
}
