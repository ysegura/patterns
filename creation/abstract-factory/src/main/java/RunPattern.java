import address.Address;
import address.AddressFactory;
import address.PhoneNumber;
import address.french.FrenchAddressFactory;
import address.usa.USAddressFactory;

public class RunPattern {

    public static void main(String[] args){
        System.out.println("Example for the AbstractFactory pattern");
        System.out.println();
        System.out.println(" (take a look in the RunPattern code. Notice that you can");
        System.out.println(" use the Address and address.PhoneNumber classes when writing");
        System.out.println(" almost all of the code. This allows you to write a very");
        System.out.println(" generic framework, and plug in Concrete Factories");
        System.out.println(" and Products to specialize the behavior of your code.");
        System.out.println();

        System.out.println("Creating US. Address and Phone Number:");
        AddressFactory usAddressFactory = new USAddressFactory();
        Address usAddress = usAddressFactory.createAddress();
        PhoneNumber usPhoneNumber = usAddressFactory.createPhoneNumber();

        usAddress.setStreet("142 Lois Lane");
        usAddress.setCity("Metropolis");
        usAddress.setRegion("WY");
        usAddress.setPostalCode("54321");
        usPhoneNumber.setPhoneNumber("7039214722");

        System.out.println("U.S. Address:");
        System.out.println(usAddress.getFullAddress());
        System.out.println("U.S. Phone Number:");
        System.out.println(usPhoneNumber.getPhoneNumber());
        System.out.println();
        System.out.println();

        System.out.println("Creating French Address and Phone Number:");
        AddressFactory frenchAddressFactory = new FrenchAddressFactory();
        Address frencAddress = frenchAddressFactory.createAddress();
        PhoneNumber frenchPhoneNumber = frenchAddressFactory.createPhoneNumber();

        frencAddress.setStreet("21 Rue Victor Hugo");
        frencAddress.setCity("Courbevoie");
        frencAddress.setPostalCode("40792");
        frenchPhoneNumber.setPhoneNumber("011324290");

        System.out.println("French Address:");
        System.out.println(frencAddress.getFullAddress());
        System.out.println("French Phone Number:");
        System.out.println(frenchPhoneNumber.getPhoneNumber());
        System.out.println();
        System.out.println();

    }
}
