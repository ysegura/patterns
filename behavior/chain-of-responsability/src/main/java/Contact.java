import java.io.Serializable;

public interface Contact extends Serializable {

    static final String SPACE = " ";
    String getFirstName();
    String getLastName();
    String getTitle();
    String getOrganization();

    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setTitle(String title);
    void setOrganization(String organization);

}
