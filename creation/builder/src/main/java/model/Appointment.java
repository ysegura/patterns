package model;

import java.util.ArrayList;
import java.util.Date;

public class Appointment {

    private Date startDate;

    private Date endDate;

    private String description;

    private ArrayList<Contact> attendees = new ArrayList();

    private Location location;

    public static final String EOL_STRING = System.getProperty("line.separator");

    public Date getStartDate(){
        return startDate;
    }

    public Date getEndDate(){
        return endDate;
    }

    public String getDescription(){
        return description;
    }

    public ArrayList getAttendees(){
        return attendees;
    }

    public Location getLocation(){
        return location;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setLocation(Location newLocation){
        this.location = newLocation;
    }

    public void setStartDate(Date newStartDate) {
        this.startDate = newStartDate;
    }

    public void setEndDate(Date newEndDate) {
        this.endDate = newEndDate;
    }

    public void setAttendees(ArrayList newAtendees){
        if (newAtendees != null) {
            this.attendees = newAtendees;
        }
    }

    public void addAtendee(Contact attendee){
        if (!attendees.contains(attendee)){
            attendees.add(attendee);
        }
    }

    public void removeAtendee(Contact attendee){
        attendees.remove(attendee);
    }

    @Override
    public String toString(){
        return " Description: " + description + EOL_STRING +
                " Start Date: " + startDate + EOL_STRING +
                " End Date: " + endDate + EOL_STRING +
                " Location: " + location + EOL_STRING +
                " Attendees: " + attendees;
    }
}
