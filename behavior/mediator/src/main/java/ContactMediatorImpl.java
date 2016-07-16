import java.util.ArrayList;

public class ContactMediatorImpl implements ContactMediator {

    private ContactDisplayPanel displayPanel;

    private ContactSelectorPanel selectorPanel;

    private ContactEditorPanel editorPanel;

    private ArrayList contacts = new ArrayList();

    private int contactIndex;

    @Override
    public void setContactDisplayPanel(ContactDisplayPanel displayPanel) {
        this.displayPanel = displayPanel;
    }

    @Override
    public void setContactEditorPanel(ContactEditorPanel editorPanel) {
        this.editorPanel = editorPanel;
    }

    @Override
    public void setContactSelectorPanel(ContactSelectorPanel selectorPanel) {
        this.selectorPanel = selectorPanel;
    }

    @Override
    public void createContact(String firstName, String lastName, String title, String organization) {
        Contact newContact = new ContactImpl(firstName, lastName, title, organization);
        addContact(newContact);
        selectorPanel.addContact(newContact);
        displayPanel.contactChanged(newContact);
    }

    @Override
    public void updateContact(String firstName, String lastName, String title, String organization) {
        Contact updatedContact = (Contact)contacts.get(contactIndex);
        if (updatedContact != null) {
            updatedContact.setFirstName(firstName);
            updatedContact.setLastName(lastName);
            updatedContact.setTitle(title);
            updatedContact.setOrganization(organization);
            displayPanel.contactChanged(updatedContact);
        }
    }

    @Override
    public void selectContact(Contact contact) {
        if (contacts.contains(contact)) {
            contactIndex = contacts.indexOf(contact);
            displayPanel.contactChanged(contact);
            editorPanel.setContactFields(contact);
        }
    }

    @Override
    public Contact[] getAllContacts() {
        return (Contact[]) contacts.toArray(new Contact[1]);
    }

    public void addContact(Contact contact){
        if(!contacts.contains(contact)){
            contacts.add(contact);
        }
    }

}
