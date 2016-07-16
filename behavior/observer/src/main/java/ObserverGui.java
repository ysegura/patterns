import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ObserverGui {

    public void createGui() {

        JFrame mainFrame = new JFrame("Observer pattern example");
        Container container = mainFrame.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        TaskChangeObservable observable = new TaskChangeObservable();
        TaskSelectorPanel selectorPanel = new TaskSelectorPanel(observable);
        TaskHistoryPanel historyPanel = new TaskHistoryPanel();
        TaskEditorPanel editorPanel = new TaskEditorPanel(observable);

        observable.addTaskChangeObserver(selectorPanel);
        observable.addTaskChangeObserver(historyPanel);
        observable.addTaskChangeObserver(editorPanel);

        observable.addTask(new Task());

        container.add(selectorPanel);
        container.add(historyPanel);
        container.add(editorPanel);

        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private class WindowCloseManager extends WindowAdapter {

        public void windowClosing(WindowEvent event) {
            System.exit(0);
        }

    }

}
