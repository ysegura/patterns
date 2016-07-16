import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MediatorGUI {

    private ContactMediator mediator;

    public void setContactMediator(ContactMediator mediator){
        this.mediator = mediator;
    }

    public void createGui(){
        JFrame mainFrame = new JFrame("Mediator Example");
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        ContactSelectorPanel select = new ContactSelectorPanel(mediator);
        ContactDisplayPanel display = new ContactDisplayPanel(mediator);
        ContactEditorPanel editor = new ContactEditorPanel(mediator);

        content.add(select);
        content.add(display);
        content.add(editor);

        mediator.setContactSelectorPanel(select);
        mediator.setContactDisplayPanel(display);
        mediator.setContactEditorPanel(editor);

        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    private class WindowCloseManager extends WindowAdapter{
        public void windowClosing(WindowEvent event){
            System.exit(0);
        }
    }

}
