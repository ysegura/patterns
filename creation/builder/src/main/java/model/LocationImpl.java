package model;

public class LocationImpl implements Location{

    private String location;

    public LocationImpl() {
    }

    public LocationImpl(String newLocation) {
        this.location = newLocation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    @Override
    public String toString(){
        return location;
    }
}
