public interface ContactMediator {

    void setContactDisplayPanel(ContactDisplayPanel displayPanel);

    void setContactEditorPanel(ContactEditorPanel editorPanel);

    void setContactSelectorPanel(ContactSelectorPanel selectorPanel);

    void createContact(String firstName, String lastName, String title, String organization);

    void updateContact(String firstName, String lastName, String title, String organization);

    Contact[] getAllContacts();

    void selectContact(Contact contact);
}
