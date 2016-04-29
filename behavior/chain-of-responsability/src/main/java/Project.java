import java.util.ArrayList;

public class Project implements ProjectItem {

    private String name;

    private Contact owner;

    private String details;

    private ArrayList projectItems = new ArrayList();

    public Project() {
    }

    public Project(String name, String details, Contact owner) {
        this.name = name;
        this.owner = owner;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getOwner() {
        return owner;
    }

    public void setOwner(Contact owner) {
        this.owner = owner;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ArrayList getProjectItems() {
        return projectItems;
    }

    public ProjectItem getParent() {
        return null;
    }

    public void addProjectItem(ProjectItem item) {
        if (!projectItems.contains(item)) {
            projectItems.add(item);
        }
    }

    public void removeProjectItem(ProjectItem item) {
        projectItems.remove(item);
    }

    @Override
    public String toString() {
        return name;
    }
}
