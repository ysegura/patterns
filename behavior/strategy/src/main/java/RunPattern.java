import java.io.File;

public class RunPattern {

    private static final String FILENAME = "strategy.ser";

    public static void main(String[] args){
        System.out.println("Example for the Strategy pattern");
        System.out.println();

        System.out.println("This code uses two strategy classes, NameSummarizer and OrganizationSummarizer to provide a sorted sumarized list for ContactList");
        System.out.println("The ContactList object delegates the representation to another object implementing SummarizingStrategy");

        System.out.println("Deserializing ContactList data from data.ser");
        System.out.println();

        if (!(new File(FILENAME).exists())){
            DataCreator.serialize(FILENAME);
        }

        ContactList list = (ContactList) (DataRetriever.deserializeData(FILENAME));

        System.out.println("Creating NameSummarizer (Shows only last and first name, sorted last -> first");
        list.setSummarizer(new NameSummarizer());
        System.out.println("Output for NameSummarizer:");
        System.out.println(list.summarize());
        System.out.println();

        System.out.println(
                "Creating OrganizationSummarizer (Shows organization and first name, sorted organization -> last name");
        list.setSummarizer(new OrganizationSummarizer());
        System.out.println("Output for OrganizationSummarizer:");
        System.out.println(list.summarize());
        System.out.println();
    }

}
