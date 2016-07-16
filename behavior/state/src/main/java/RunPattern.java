import java.io.File;

public class RunPattern {

    public static void main(String[] args){
        System.out.println("Example for the State pattern.");
        System.out.println();

        if (!(new File("appointments.ser").exists())) {
            DataCreator.serialize("appointments.ser");
        }

        System.out.println("Creating CalendarEditor");
        CalendarEditor appointmentBook = new CalendarEditor();
        System.out.println();

        System.out.println("Created appointments:");
        System.out.println(appointmentBook.getAppointments());

        System.out.println("Creating Gui");
        StateGui application = new StateGui(appointmentBook);
        application.createGui();
        System.out.println();
    }

}
