package builder;

import exceptions.InformationRequiredException;
import model.Appointment;
import model.Location;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentBuilder {

    public static final int START_DATE_REQUIRED = 1;
    public static final int END_DATE_REQUIRED = 2;
    public static final int DESCRIPTION = 4;
    public static final int ATENDEE_REQUIRED = 8;
    public static final int LOCATION_REQUIRED = 16;

    protected Appointment appointment;

    protected int requiredElements;

    public void buildAppointment(){
        appointment = new Appointment();
    }

    public void buildDates(Date startDate, Date endDate){
        Date currentDate = new Date();
        if ((startDate != null) && (startDate.after(currentDate))){
            appointment.setStartDate(startDate);
        }
        if ((endDate != null) && (endDate.after(startDate))){
            appointment.setEndDate(endDate);
        }
    }

    public void buildDescription(String newDescription){
        appointment.setDescription(newDescription);
    }

    public void buildAttendees(ArrayList atendees){
        appointment.setAttendees(atendees);
    }

    public void buildLocation(Location newLocation){
        appointment.setLocation(newLocation);
    }

    public Appointment getAppointment() throws InformationRequiredException {
        requiredElements = 0;

        if (appointment.getStartDate() == null){
            requiredElements += START_DATE_REQUIRED;
        }

        if (appointment.getLocation() == null){
            requiredElements += LOCATION_REQUIRED;
        }

        if (appointment.getAttendees() == null){
            requiredElements += ATENDEE_REQUIRED;
        }

        if (requiredElements > 0){
            throw new InformationRequiredException(requiredElements);
        }

        return appointment;
    }

    public int getRequiredElements(){
        return requiredElements;
    }
}
