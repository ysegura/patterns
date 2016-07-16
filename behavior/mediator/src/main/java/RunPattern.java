public class RunPattern {

    public static void main(String[] args){
        Contact contact = new ContactImpl("", "", "", "");
        Contact contact1 = new ContactImpl("Duke", "", "Java Advocate", "The Patterns Guild");

        ContactMediatorImpl mediator = new ContactMediatorImpl();

        mediator.addContact(contact);
        mediator.addContact(contact1);

        MediatorGUI gui = new MediatorGUI();
        gui.setContactMediator(mediator);
        gui.createGui();
    }

}
