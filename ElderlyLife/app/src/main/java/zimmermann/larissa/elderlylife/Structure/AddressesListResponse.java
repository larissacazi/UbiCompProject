package zimmermann.larissa.elderlylife.Structure;

import java.util.List;

/**
 * Created by laris on 27/11/2017.
 */

public class AddressesListResponse {
    private List<Address> addresses;

    public AddressesListResponse(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
