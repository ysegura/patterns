import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataCreator {

    private static final String DEFAULT_FILE = "data.ser";

    public static void main(String[] args){
        String filename;
        if (args.length == 1){
            filename = args[0];
        }else {
            filename = DEFAULT_FILE;
        }
        serialize(filename);
    }

    public static void serialize(String filename){
        try{
            serializeToFile(createData(),filename);
        }catch (IOException exc){
            exc.printStackTrace();
        }
    }

    private static Serializable createData(){
        Contact contactA = new ContactImpl("Dennis", "Moore", "Managing Director", "Highway Man, LTD");
        Contact contactB = new ContactImpl("Joseph", "Mongolfier", "High Flyer", "Lighter than Air Productions");
        Contact contactC = new ContactImpl("Erik","Njoll","Nomad without portfolio","Nordic Trek, Inc.");
        Contact contactD = new ContactImpl("Lemming","","Principal Investigator","BDA");

        Project project = new Project("Island Paradise", "Aquire a personal island paradise", contactB);

        Task task1 = new Task(project,"Fortune", "become rich", contactD, true);
        Task task2 = new Task(project,"Isle", "locate a paradise island for sale", null, true);
        Task task3 = new Task(project,"Name", "decide a name for the island", contactC, true);

        project.addProjectItem(task1);
        project.addProjectItem(task2);
        project.addProjectItem(task3);

        Task task1_1 = new Task(task1, "Fortune 1", "Use psychist hotline to predict lottery numbers", null, false);
        Task task1_2 = new Task(task1, "Fortune 2", "Invest winnings to ensure 50% annual interest", contactA, true);
        Task task2_1 = new Task(task2, "Isle 1", "Research which climate is better: Atlantinc or Pacific", contactA,
                true);
        Task task2_2 = new Task(task2, "Isle 2", "Locate an island for auction on Ebay", null, false);
        Task task2_2_1 = new Task(task2, "Isle 2a", "Negotiate for sale on the island", null, false);
        Task task3_1 = new Task(task3, "Name 1", "Research every possible name in the world", null, true);
        Task task3_2 = new Task(task3, "Name 2", "Eliminate any choices that are not coffee related", contactD, false);

        task1.addProjectItem(task1_1);
        task1.addProjectItem(task1_2);
        task2.addProjectItem(task2_1);
        task2.addProjectItem(task2_2);
        task2.addProjectItem(task2_2_1);
        task3.addProjectItem(task3_1);
        task3.addProjectItem(task3_2);

        return project;

    }

    private static void serializeToFile(Serializable content, String filename) throws IOException{
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(filename));
        serOut.writeObject(content);
        serOut.close();
    }

}
