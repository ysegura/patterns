import java.io.Serializable;
import java.util.ArrayList;

public class ContactList implements Serializable {

    private ArrayList contacts = new ArrayList();

    private SummarizingStrategy summarizer;

    public ArrayList getContacts() {
        return contacts;
    }

    public Contact[] getContactsAsArray() {
        return (Contact[])(contacts.toArray(new Contact[1]));
    }

    public void addContact(Contact element){
        if (!contacts.contains(element)){
            contacts.add(element);
        }
    }

    public void removeContact(Contact element){
        contacts.remove(element);
    }

    public void setSummarizer(SummarizingStrategy summarizer){
        this.summarizer = summarizer;
    }

    public String summarize(){
        return summarizer.summarize(getContactsAsArray());
    }

    public String[] makeSummarizedString(){
        return summarizer.makeSummarizedList(getContactsAsArray());
    }

}
