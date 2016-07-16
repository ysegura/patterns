import java.io.Serializable;

public interface Contact extends Serializable {

    String SPACE = " ";

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getTitle();

    void setTitle(String title);

    String getOrganization();

    void setOrganization(String organization);

}
