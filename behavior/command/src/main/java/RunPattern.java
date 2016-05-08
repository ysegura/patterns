import java.util.Calendar;
import java.util.Date;

public class RunPattern {

    private static Calendar dateCreator = Calendar.getInstance();

    public static void main(String[] args){
        System.out.println("Example for the Command Pattern");
        System.out.println();
        System.out.println("This example uses a command class called");
        System.out.println("ChangeLocationCommand to update the Location");
        System.out.println("of an Appointment object.");
        System.out.println();
        System.out.println("The ChangeLocationCommand has the extra abilities to");
        System.out.println("undo and redo the changes made to the original value.");
        System.out.println();

        System.out.println("Creating an Appointment for using in the demo.");
        Contact[] people = {new ContactImpl(), new ContactImpl()};
        Appointment appointment = new Appointment("Java Twister Semi-Finals", people, new LocationImpl(""), createDate(2001,10,31,14,30), createDate(2001,10,31,14,31));

        System.out.println("Creating the CangeLocationCommand");
        ChangeLocationCommand cmd = new ChangeLocationCommand();
        cmd.setAppointment(appointment);

        System.out.println("Creating the GUI");
        CommandGUI application = new CommandGUI(cmd);
        application.setAppointment(appointment);
        cmd.setLocationEditor(application);
        application.createGui();
    }

    private static Date createDate(int year, int month, int day, int hour, int minutes){
        dateCreator.set(year, month, day, hour, minutes);
        return dateCreator.getTime();
    }

}
