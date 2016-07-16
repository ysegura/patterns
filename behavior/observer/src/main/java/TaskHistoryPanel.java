import javax.swing.*;
import java.awt.*;

public class TaskHistoryPanel extends JPanel implements TaskChangeObserver {

    private JTextArea displayRegion;

    public TaskHistoryPanel() {
        createGui();
    }

    public void createGui(){
        setLayout(new BorderLayout());
        displayRegion = new JTextArea(10, 40);
        displayRegion.setEditable(false);
        add(new JScrollPane(displayRegion));
    }

    @Override public void taskAdded(Task task) {
        displayRegion.append("Created task " + task + "\n");
    }

    @Override public void taskChanged(Task task) {
        displayRegion.append("Updated task " + task + "\n");
    }

    @Override public void taskSelected(Task task) {
        displayRegion.append("Selected task " + task + "\n");
    }
}
