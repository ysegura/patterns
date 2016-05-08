public class LocationImpl implements Location {

    private String location;

    public LocationImpl() {
    }

    public LocationImpl(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return location;
    }
}
