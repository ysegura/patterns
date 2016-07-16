import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

public class OrganizationSummarizer implements SummarizingStrategy {

    private Comparator comparator = new OrganizationComparator();

    @Override
    public String summarize(Contact[] contacts) {
        StringBuffer product = new StringBuffer();
        Arrays.sort(contacts, comparator);
        for (int i = 0; i < contacts.length; i++) {
            product.append(contacts[i].getOrganization()).append(DELIMITER).append(SPACE)
                    .append(contacts[i].getFirstName()).append(SPACE).append(contacts[i].getLastName())
                    .append(EOL_STRING);
        }
        return product.toString();
    }

    @Override
    public String[] makeSummarizedList(Contact[] contacts) {
        Arrays.sort(contacts, comparator);
        String[] product = new String[contacts.length];
        for (int i = 0; i < contacts.length; i++) {
            product[i] = new StringBuilder().append(contacts[i].getOrganization()).append(DELIMITER).append(SPACE)
                    .append(contacts[i].getFirstName()).append(SPACE).append(contacts[i].getLastName())
                    .append(EOL_STRING).toString();
        }
        return new String[0];
    }

    private class OrganizationComparator implements Comparator {

        private Collator textComparator = Collator.getInstance();

        @Override
        public int compare(Object o1, Object o2) {
            Contact c1, c2;
            if ((o1 instanceof Contact) && (o2 instanceof Contact)) {
                c1 = (Contact)o1;
                c2 = (Contact)o2;
                int compareResult = textComparator.compare(c1.getOrganization(), c2.getOrganization());
                if (compareResult == 0) {
                    compareResult = textComparator.compare(c1.getLastName(), c2.getLastName());
                }
                return compareResult;
            } else {
                return textComparator.compare(o1, o2);
            }
        }

        @Override
        public boolean equals(Object obj) {
            return textComparator.equals(obj);
        }
    }
}
