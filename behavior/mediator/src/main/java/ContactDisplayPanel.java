import java.awt.*;

import javax.swing.*;

public class ContactDisplayPanel extends JPanel {

    private ContactMediator mediator;

    private JTextArea displayRegion;

    public ContactDisplayPanel() {
        createGui();
    }

    private void createGui() {
        setLayout(new BorderLayout());
        displayRegion = new JTextArea(10, 40);
        displayRegion.setEditable(false);
        add(new JScrollPane(displayRegion));
    }

    public ContactDisplayPanel(ContactMediator newMediator) {
        setContactMediator(newMediator);
        createGui();
    }

    public void setContactMediator(ContactMediator mediator) {
        this.mediator = mediator;
    }

    public void contactChanged(Contact contact) {
        displayRegion.setText("Contact\n\tName: " + contact.getFirstName() + " " + contact.getLastName() + "\n\tTitle: "
                + contact.getTitle() + "\n\tOrganization: " + contact.getOrganization());
    }
}
