package address.usa;

import address.Address;
import address.AddressFactory;
import address.PhoneNumber;

public class USAddressFactory implements AddressFactory {
    public Address createAddress() {
        return new USAddress();
    }

    public PhoneNumber createPhoneNumber() {
        return new USPhoneNumber();
    }
}
