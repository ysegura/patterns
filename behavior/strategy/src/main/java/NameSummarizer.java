import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

public class NameSummarizer implements SummarizingStrategy {

    private Comparator comparator = new NameComparator();

    @Override
    public String summarize(Contact[] contacts) {
        StringBuffer product = new StringBuffer();
        Arrays.sort(contacts, comparator);
        for (int i = 0; i < contacts.length; i++) {
            product.append(contacts[i].getLastName()).append(COMMA).append(SPACE).append(contacts[i].getFirstName())
                    .append(EOL_STRING);
        }
        return product.toString();
    }

    @Override
    public String[] makeSummarizedList(Contact[] contacts) {
        Arrays.sort(contacts, comparator);
        String[] product = new String[contacts.length];
        for (int i = 0; i < contacts.length; i++) {
            product[i] = new StringBuilder().append(contacts[i].getLastName()).append(COMMA).append(SPACE)
                    .append(contacts[i].getFirstName()).append(EOL_STRING).toString();
        }
        return new String[0];
    }

    private class NameComparator implements Comparator {

        private Collator textComparator = Collator.getInstance();

        @Override
        public int compare(Object o1, Object o2) {
            Contact c1, c2;
            if ((o1 instanceof Contact) && (o2 instanceof Contact)){
                c1 = (Contact) o1;
                c2 = (Contact) o2;
                int compareResult = textComparator.compare(c1.getLastName(), c2.getLastName());
                if (compareResult == 0){
                    compareResult = textComparator.compare(c1.getFirstName(), c2.getFirstName());
                }
                return compareResult;
            }else{
                return textComparator.compare(o1,o2);
            }
        }

        @Override
        public boolean equals(Object obj) {
            return textComparator.equals(obj);
        }
    }
}
