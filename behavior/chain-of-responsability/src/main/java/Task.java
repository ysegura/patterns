import java.util.ArrayList;

public class Task implements ProjectItem {

    private String name;

    private ArrayList projectItems = new ArrayList();
    private Contact owner;
    private String details;
    private ProjectItem parent;
    private boolean primaryTask;

    public Task(ProjectItem parent) {
        this.parent = parent;
    }

    public Task(ProjectItem parent, String name, String details, Contact owner, boolean primaryTask){
        this.parent = parent;
        this.name = name;
        this.details = details;
        this.owner = owner;
        this.primaryTask = primaryTask;
    }

    public Contact getOwner(){
        if (owner == null){
            return parent.getOwner();
        }
        return owner;
    }

    public String getDetails(){
        if (primaryTask){
            return details;
        }else {
            return parent.getDetails() + EOL_STRING + "\t" + details;
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList getProjectItems() {
        return projectItems;
    }

    public ProjectItem getParent() {
        return parent;
    }

    public boolean isPrimaryTask() {
        return primaryTask;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Contact owner) {
        this.owner = owner;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setParent(ProjectItem parent) {
        this.parent = parent;
    }

    public void setPrimaryTask(boolean primaryTask) {
        this.primaryTask = primaryTask;
    }

    public void addProjectItem(ProjectItem item){
        if (!projectItems.contains(item)){
            projectItems.add(item);
        }
    }

    public void removeProjectItem(ProjectItem item){
        projectItems.remove(item);
    }

    @Override public String toString() {
        return name;
    }
}
