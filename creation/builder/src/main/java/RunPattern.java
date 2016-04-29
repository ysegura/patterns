import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.Appointment;
import model.Contact;
import model.ContactImpl;
import model.LocationImpl;
import scheduler.Scheduler;
import builder.AppointmentBuilder;
import builder.MeetingBuilder;
import exceptions.InformationRequiredException;

public class RunPattern {

    private static Calendar dateCreator = Calendar.getInstance();

    public static void main(String[] args) {
        Appointment appointment = null;

        System.out.println("Example for the builder pattern");
        System.out.println();
        System.out.println("This example demonstrates the use of the Builder");
        System.out.println("pattern to create Appointment objects for the PIM.");
        System.out.println();

        System.out.println("Creating a Scheduler for the example.");
        Scheduler scheduler = new Scheduler();

        System.out.println("Creating an AppointmentBuilder for the example.");
        System.out.println();
        AppointmentBuilder appointmentBuilder = new AppointmentBuilder();
        try {
            System.out.println("Creating an Appointment with an AppointmentBuilder.");
            appointment = scheduler.createAppointment(appointmentBuilder, createDate(2066, 9, 22, 12, 30), null,
                    "Trek Convention", new LocationImpl("Fargo, ND"), createAttendees(4));
            System.out.println("Successfully created an Appointment");
            System.out.println("Appointment information");
            System.out.println(appointment);
            System.out.println();
        } catch (InformationRequiredException exc) {
            printExceptions(exc);
        }

        System.out.println("Creating a MeetingBuilder for the example.");
        MeetingBuilder meetingBuilder = new MeetingBuilder();
        try {
            System.out.println("Creating a new Appointment with a MeetingBuilder.");
            System.out.println("Exception will be thrown with the same arguments as");
            System.out.println("an EndDate is required.");
            appointment = scheduler.createAppointment(meetingBuilder, createDate(2066, 9, 22, 12, 30), null,
                    "Trek Convention", new LocationImpl("Fargo, ND"), createAttendees(4));
            System.out.println("Appointment created");
            System.out.println("Information:");
            System.out.println(appointment);
            System.out.println();
        } catch (InformationRequiredException exc) {
            printExceptions(exc);
        }

        System.out.println("Creating a MeetingBuilder for the example.");
        try {
            System.out.println("Creating a new Appointment with a MeetingBuilder.");
            System.out.println("We are providing an EndDate, so no Exception is thrown");
            appointment = scheduler.createAppointment(meetingBuilder, createDate(2002, 4, 1, 10, 0),
                    createDate(2002, 4, 1, 11, 30), "OOO Meeting", new LocationImpl("Butte, MT"), createAttendees(2));
            System.out.println("Appointment created");
            System.out.println("Information:");
            System.out.println(appointment);
            System.out.println();
        } catch (InformationRequiredException exc) {
            printExceptions(exc);
        }

    }

    public static Date createDate(int year, int month, int day, int hour, int minute) {
        dateCreator.set(year, month, day, hour, minute);
        return dateCreator.getTime();
    }

    public static ArrayList<Contact> createAttendees(int numberToCreate) {
        ArrayList<Contact> group = new ArrayList<Contact>();
        for (int i = 0; i < numberToCreate; i++) {
            group.add(new ContactImpl("John", getLastName(i), "Employee (non - exempt)", "Yoyodyne Corporation"));
        }
        return group;
    }

    public static String getLastName(int index) {
        switch (index % 6) {
        case 1:
            return "Worfin";
        case 2:
            return "Smallberries";
        case 3:
            return "Bigbootee";
        case 4:
            return "Haugland";
        case 5:
            return "Maasen";
        case 6:
            return "Sterling";
        }
        return "";
    }

    public static void printExceptions(InformationRequiredException exc){
        int statusCode = exc.getInformationRequired();

        System.out.println("Unable to create Appointment. More information:");

        if ((statusCode & InformationRequiredException.START_DATE_REQUIRED) > 0){
            System.out.println("START_DATE REQUIRED");
        }
        if ((statusCode & InformationRequiredException.END_DATE_REQUIRED) > 0){
            System.out.println("END_DATE REQUIRED");
        }
        if ((statusCode & InformationRequiredException.ATENDEE_REQUIRED) > 0){
            System.out.println("ATTENDEE REQUIRED");
        }
        if ((statusCode & InformationRequiredException.DESCRIPTION) > 0){
            System.out.println("DESCRIPTION REQUIRED");
        }
        if ((statusCode & InformationRequiredException.LOCATION_REQUIRED) > 0){
            System.out.println("LOCATION REQUIRED");
        }
        System.out.println();
    }
}
