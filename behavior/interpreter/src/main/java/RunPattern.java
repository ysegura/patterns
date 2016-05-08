public class RunPattern {

    public static void main(String[] args) {
        System.out.println("Example for the Interpreter pattern.");
        System.out.println("In this demonstration, the syntax defined");
        System.out.println("by the Interpreter can be used to search");
        System.out.println("among a collection of Contacts, returning");
        System.out.println("the subset that matches the given search criteria.");

        ContactList candidates = makeContactList();
        Context context = new Context();

        System.out.println("Contact List contents:");
        System.out.println(candidates);
        System.out.println();

        Contact testContact = new ContactImpl();
        VariableExpression varLName = new VariableExpression(testContact, "getLastName");
        ConstantExpression constLName = new ConstantExpression("u");
        ContainsExpression eqLName = new ContainsExpression(varLName, constLName);

        System.out.println("Contents of the search on Contact List");
        System.out.println("Search 'u' on the LastName");
        Object result = candidates.getContactsMatchingExpression(eqLName, context, testContact);
        System.out.println(result);
        System.out.println();

        VariableExpression varTitle = new VariableExpression(testContact, "getTitle");
        ConstantExpression constTitle = new ConstantExpression("LT");
        EqualsExpression eqTitle = new EqualsExpression(varTitle, constTitle);
        result = candidates.getContactsMatchingExpression(eqTitle, context, testContact);

        System.out.println("Contents of the search on Contact List");
        System.out.println("Search was all 'LT' personnel.");
        System.out.println(result);
        System.out.println();

        VariableExpression varLastName = new VariableExpression(testContact, "getLastName");
        ConstantExpression constLastName = new ConstantExpression("S");
        ContainsExpression cLastName = new ContainsExpression(varLastName, constLastName);
        AndExpression andExpr = new AndExpression(eqTitle, cLastName);
        result = candidates.getContactsMatchingExpression(andExpr, context, testContact);

        System.out.println("Contents of the search on Contact List");
        System.out.println("Search was all 'LT' personnel which Last Name contains 'S'");
        System.out.println(result);
        System.out.println();
    }

    private static ContactList makeContactList() {
        ContactList contacts = new ContactList();

        contacts.addContact(new ContactImpl("James", "Kirk", "Captain", "USS Enterprise"));
        contacts.addContact(new ContactImpl("Mr.", "Spock", "Science Officer", "USS Enterprise"));
        contacts.addContact(new ContactImpl("LT", "Uhura", "LT", "USS Enterprise"));
        contacts.addContact(new ContactImpl("LT", "Sulu", "LT", "USS Enterprise"));
        contacts.addContact(new ContactImpl("Ensign", "Checkov", "Ensign", "USS Enterprise"));
        contacts.addContact(new ContactImpl("Dr.", "McCoy", "Ship's Doctor", "USS Enterprise"));
        contacts.addContact(new ContactImpl("Montgomery", "Scott", "LT", "USS Enterprise"));

        return contacts;
    }

}
