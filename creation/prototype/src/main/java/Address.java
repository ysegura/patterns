public class Address implements Copyable {

    private String type;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    public static final String EOL_STRING = System.getProperty("line.separator");
    public static final String COMMA = ",";
    public static final String HOME = "home";
    public static final String WORK = "work";

    public Address(String type, String street, String city, String state, String zipCode) {
        this.type = type;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(String street, String city, String state, String zipCode) {
        this(WORK,street, city,state,zipCode);
    }

    public Address(String type) {
        this.type = type;
    }

    public Address() {
    }

    public String getType() {
        return type;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Object copy() {
        return new Address(street,city,state,zipCode);
    }

    @Override public String toString() {
        return "\t" + street + COMMA + " " + EOL_STRING +
                "\t" + city + COMMA + " " + state + " " + zipCode;
    }
}
