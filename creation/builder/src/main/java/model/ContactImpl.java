package model;

public class ContactImpl implements Contact {

    private String firstName;
    private String lastName;
    private String title;
    private String organization;

    public ContactImpl(String firstName, String lastName, String title, String organization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.organization = organization;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getOrganization() {
        return organization;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override public String toString() {
        return firstName + SPACE + lastName;
    }
}
