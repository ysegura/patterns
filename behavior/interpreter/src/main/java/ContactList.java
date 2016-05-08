import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ContactList implements Serializable {

    private ArrayList contacts = new ArrayList();

    public ArrayList getContacts() {
        return contacts;
    }
    public Contact[] getContactsAsArray(){
        return (Contact[])(contacts.toArray(new Contact[1]));
    }

    public ArrayList getContactsMatchingExpression(Expression expression, Context context, Object key){
        ArrayList results = new ArrayList();
        Iterator elements = contacts.iterator();
        while (elements.hasNext()){
            Object currentElement = elements.next();
            context.addVariable(key, currentElement);
            expression.interpret(context);
            Object interpretResult = context.get(expression);
            if ((interpretResult != null) && (interpretResult.equals(Boolean.TRUE))) {
                results.add(currentElement);
            }
        }
        return results;
    }

    public void setContacts(ArrayList contacts){
        this.contacts = contacts;
    }

    public void addContact(Contact contact){
        if (!contacts.contains(contact)) {
            contacts.add(contact);
        }
    }

    public void removeContact(Contact contact){
        contacts.remove(contact);
    }

    public String toString(){
        return contacts.toString();
    }
}
