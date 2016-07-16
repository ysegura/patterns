public class RunPattern {

    public static void main(String[] args) {
        System.out.println("Example for the Memento pattern");
        System.out.println();

        System.out
                .println("Will use the AddressBook to demonstrate how a Memento can be used to save and restore state.");
        System.out.println(
                "The Address book has an inner class, AddressBookMemento, that is used to store the AdressBook state... in this case, it's internal list of contacts.");
        System.out.println();

        System.out.println("Creating the AddressBook");
        AddressBook book = new AddressBook();

        System.out.println("Adding Contact entries for the AddressBook");
        book.addContact(new ContactImpl("Peter", "Taggart", "Commander", "NSEA Protection", new AddressImpl()));
        book.addContact(new ContactImpl("Tawny", "Madison", "Lieutenant", "NSEA Protection", new AddressImpl()));
        book.addContact(new ContactImpl("Dr.", "Lazarus", "Dr.", "NSEA Protection", new AddressImpl()));
        book.addContact(new ContactImpl("Tech Sargent", "Chen", "Tech Sargent", "NSEA Protection", new AddressImpl()));

        System.out.println("Contacts added. Current contact list:");
        System.out.println(book);
        System.out.println();

        System.out.println("Creating a memento for the Address book");
        Object memento = book.getMemento();
        System.out.println("Now that a memento exists, it can be used to restore state or set the state of a new one");
        System.out.println();

        System.out.println("Removing all contacts from AddressBook and creating new ones");
        book.removeAllContacts();

        book.addContact(new ContactImpl("Jason", "Nesmith", "", "Actor's Guild", new AddressImpl()));
        book.addContact(new ContactImpl("Gwen", "DeMarco", "", "Actor's Guild", new AddressImpl()));
        book.addContact(new ContactImpl("Alexander", "Dane", "", "Actor's Guild", new AddressImpl()));
        book.addContact(new ContactImpl("Fred", "Kwan", "", "Actor's Guild", new AddressImpl()));

        System.out.println("Contacts added. Current contact list:");
        System.out.println(book);
        System.out.println();
        System.out.println("Restoring state via memento object");
        book.setMemento(memento);
        System.out.println("AddressBook restored. Current contact list:");
        System.out.println(book);

    }

}
