package gui;

import javax.swing.*;

public interface ItemEditor {

    JComponent getGUI();
    void commitChanges();

}
