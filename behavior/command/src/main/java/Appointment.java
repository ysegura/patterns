import java.util.Date;

public class Appointment {

    private String reason;

    private Contact[] contacts;

    private Location location;

    private Date startDate;

    private Date endDate;

    public Appointment(String reason, Contact[] contacts, Location location, Date startDate, Date endDate) {
        this.reason = reason;
        this.contacts = contacts;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String toString() {
        return "Appointment: " + "\n\tReason: " + reason + "\n\tLocation: " + location + "\n\tStart: " + startDate
                + "\n\tEnd: " + endDate;
    }
}
