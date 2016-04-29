import gui.Contact;
import gui.EditorGUI;

public class RunPattern {

    public static void main(String[] args){
        System.out.println("Example for the Factory Method pattern");
        System.out.println();
        Contact someone = new Contact();

        System.out.println("Creating a new GUI for the contact");
        System.out.println();
        System.out.println("The GUI defined in the EditorGUI is a truly generic editor");
        System.out.println("It accepts an argument of type ItemEditor and delegates");
        System.out.println("all editing tasks to its ItemEditor and the asociated GUI");
        System.out.println("The getEditor() Factory Method is used to obtain the ItemEditor");
        System.out.println("for the example");
        System.out.println();
        System.out.println("Notice the editor in the top portion of the GUI is,");
        System.out.println("in fact, returned by the ItemEditor belonging to the");
        System.out.println("Contact class, and has appropriate fields for that class");

        EditorGUI runner = new EditorGUI(someone.getEditor());
        runner.createGui();
    }

}
