import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactSelectorPanel extends JPanel implements ActionListener{

    private ContactMediator mediator;
    private JComboBox selector;

    public ContactSelectorPanel() {
        createGui();
    }

    public ContactSelectorPanel(ContactMediator mediator) {
        this.mediator = mediator;
        createGui();
    }

    public void createGui(){
        selector = new JComboBox(mediator.getAllContacts());
        selector.addActionListener(this);
        add(selector);
    }

    public void actionPerformed(ActionEvent event){
        mediator.selectContact((Contact) selector.getSelectedItem());
    }

    public void addContact(Contact contact){
        selector.addItem(contact);
        selector.setSelectedItem(contact);
    }

    public void setContactMediator(ContactMediator mediator){
        this.mediator = mediator;
    }

}
