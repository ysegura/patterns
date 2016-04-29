import java.io.File;
import java.util.Iterator;

public class RunPattern {

    public static void main(String[] args) {
        System.out.println("Example for Chain Of Responsibility pattern");
        System.out.println("Obtains the owner using chain of responsibility");
        System.out.println("If the getOwner method is not the appropriate,");
        System.out.println("the call is passed up in the chain, to the first not null");
        System.out.println("The same principle is used for details, up the project tree");
        System.out.println("until a primary task is encountered.");

        if (!new File("data.ser").exists()){
            DataCreator.serialize("data.ser");
        }

        Project project = (Project)DataRetriever.deserializeData("data.ser");

        getItemInfo(project);
    }

    private static void getItemInfo(ProjectItem item){
        System.out.println("Item: " + item);
        System.out.println("Owner: " + item.getOwner());
        System.out.println("Details: " + item.getDetails());
        System.out.println();
        if (item.getProjectItems() != null){
            Iterator<ProjectItem> subElements = item.getProjectItems().iterator();
            while (subElements.hasNext()){
                getItemInfo(subElements.next());
            }
        }
    }

}
