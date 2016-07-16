import java.io.*;

public class DataCreator implements Serializable {

    private static final String DEFAULT_FILE = "data.ser";

    public static void main(String[] args) {
        String fileName;
        if (args.length == 1) {
            fileName = args[0];
        } else {
            fileName = DEFAULT_FILE;
        }

        serialize(fileName);
    }

    public static void serialize(String fileName) {
        try {
            serializeToFile(makeContactList(), fileName);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void serializeToFile(Serializable data, String fileName) throws IOException {
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        serOut.writeObject(data);
        serOut.close();
    }

    private static Serializable makeContactList() {
        ContactList list = new ContactList();
        list.addContact(new ContactImpl("David", "St. Hubbins", "Lead Guitar", "The New Originals"));
        list.addContact(new ContactImpl("Mick", "Shimpton", "Drummer", "The New Originals"));
        list.addContact(new ContactImpl("Nigel", "Tufnel", "Lead Guitar", "The New Originals"));
        list.addContact(new ContactImpl("Derek", "Smalls", "Bass", "The New Originals"));
        list.addContact(new ContactImpl("Viv", "Savage", "Keyboards", "The New Originals"));
        list.addContact(new ContactImpl("Nick", "Shrimpton", "CEO", "Fishy Business, LTD"));
        list.addContact(new ContactImpl("Nikolai", "Lobachevski", "Senior Packer", "Fishy Business, LTD"));
        list.addContact(new ContactImpl("Alan", "Robertson", "Controller", "Universal Exports"));
        list.addContact(new ContactImpl("William", "Telle", "President", "Universal Exports"));
        list.addContact(new ContactImpl("Harvey", "Manfredjensenden", "Inspector", "Universal Imports"));
        list.addContact(new ContactImpl("Deidre", "Pine", "Chief Mechanic", "The Universal Joint"));
        list.addContact(new ContactImpl("Martha", "Crump-Pinnett", "Lead Developer", "Avatar Inc."));
        list.addContact(new ContactImpl("Bryan", "Basham", "CTO", "IOVA"));

        return list;
    }

}
