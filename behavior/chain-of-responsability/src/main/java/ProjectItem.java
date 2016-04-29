import java.io.Serializable;
import java.util.ArrayList;

public interface ProjectItem extends Serializable{

    static final String EOL_STRING = System.getProperty("line.separator");
    ProjectItem getParent();
    Contact getOwner();
    String getDetails();
    ArrayList getProjectItems();

}
