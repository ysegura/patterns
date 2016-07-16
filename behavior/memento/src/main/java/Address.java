import java.io.Serializable;

public interface Address extends Serializable {

    String EOL_STRING = System.lineSeparator();

    String SPACE = " ";

    String COMMA = ",";

    String getType();

    String getDescription();

    String getStreet();

    String getCity();

    String getState();

    String getZipCode();

    void setType(String type);

    void setDescription(String description);

    void setStreet(String street);

    void setCity(String city);

    void setState(String state);

    void setZipCode(String zipCode);

}
