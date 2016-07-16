import java.io.File;
import java.util.ArrayList;

public class CalendarEditor {

    private static final String DEFAULT_APPOINTMENT_FILE = "appointments.ser";

    private State currentState;

    private File appointmentFile;

    private ArrayList appointments = new ArrayList();

    public CalendarEditor() {
        this(DEFAULT_APPOINTMENT_FILE);
    }

    public CalendarEditor(String appointmentFileName) {
        appointmentFile = new File(appointmentFileName);
        try {
            appointments = (ArrayList)FileLoader.loadData(appointmentFile);
        } catch (ClassCastException ex) {
            System.err.println("Unable to load information. The file does not contain a list of appointments.");
        }
        currentState = new CleanState();
    }

    public void save() {
        currentState.save();
    }

    public void edit() {
        currentState.edit();
    }

    public ArrayList getAppointments(){
        return appointments;
    }

    public void addAppointment(Appointment appointment){
        if(!appointments.contains(appointment)){
            appointments.add(appointment);
        }
    }

    public void removeAppointment(Appointment appointment){
        appointments.remove(appointment);
    }

    private class CleanState implements State {

        private State nextState = new DirtyState(this);

        @Override
        public void save() {

        }

        @Override
        public void edit() {
            currentState = nextState;
        }
    }

    private class DirtyState implements State {

        private State nextState;

        public DirtyState(State nextState) {
            this.nextState = nextState;
        }

        @Override
        public void save() {
            FileLoader.storeData(appointmentFile, appointments);
            currentState = nextState;
        }

        @Override
        public void edit() {
            currentState.edit();
        }
    }

}
