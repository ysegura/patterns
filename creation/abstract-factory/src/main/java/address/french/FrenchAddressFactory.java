package address.french;

import address.Address;
import address.AddressFactory;
import address.PhoneNumber;

public class FrenchAddressFactory implements AddressFactory {

    public Address createAddress() {
        return new FrenchAddress();
    }

    public PhoneNumber createPhoneNumber() {
        return new FrenchPhoneNumber();
    }
}
