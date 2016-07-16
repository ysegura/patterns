import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Appointment implements Serializable {

    private String reason;
    private ArrayList contacts;
    private Location location;
    private Date startDate;
    private Date endDate;

    public Appointment(String reason, ArrayList contacts, Location location, Date startDate, Date endDate){
        this.reason = reason;
        this.contacts = contacts;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ArrayList getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList contacts) {
        this.contacts = contacts;
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

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
