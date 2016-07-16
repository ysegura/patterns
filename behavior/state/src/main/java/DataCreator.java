import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DataCreator {

    private static final String DEFAULT_FILE = "data.ser";
    private static Calendar dateCreator = Calendar.getInstance();

    public static void main(String[] args) {
        String filename;
        if (args.length == 1) {
            filename = args[0];
        } else {
            filename = DEFAULT_FILE;
        }
        serialize(filename);
    }

    public static void serialize(String fileName){
        try {
            serializeToFile(createData(), fileName);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static Serializable createData(){
        ArrayList appointments = new ArrayList();
        ArrayList contacts = new ArrayList();

        contacts.add(new ContactImpl("Test","Subject","Volunteer","United Patterns Consortium"));
        Location location1 = new LocationImpl("Punxsutawney, PA");
        appointments.add(new Appointment("Slowpokes Anonymous", contacts, location1, createDate(2001, 1, 1, 12, 01), createDate(2001, 1, 1, 12, 02)));
        appointments.add(new Appointment("Java Focus Group", contacts, location1, createDate(2001, 1, 1, 12, 30), createDate(2001, 1, 1, 14, 30)));
        appointments.add(new Appointment("Something else", contacts, location1, createDate(2001, 1, 1, 12, 01), createDate(2001, 1, 1, 12, 02)));
        appointments.add(new Appointment("Yet another thingie", contacts, location1, createDate(2001, 1, 1, 12, 01), createDate(2001, 1, 1, 12, 02)));

        return appointments;
    }

    private static void serializeToFile(Serializable content, String fileName) throws IOException{
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        serOut.writeObject(content);
        serOut.close();
    }

    public static Date createDate(int year, int month, int day, int hour, int minute) {
        dateCreator.set(year, month, day, hour, minute);
        return dateCreator.getTime();
    }

}
