
package app.service;

import app.domain.Address;
import app.repository.AddressRepositoryImpl;
import app.repository.IAddressRepository;

/**
 * @author luungocha bui
 *
 */
public class AddressServiceImpl implements IAddressService {
	
	private IAddressRepository addressRepository;
	
	public AddressServiceImpl() {
		addressRepository = new AddressRepositoryImpl();
	}

	@Override
	public Address createAddress(String street, String city, String zipcode, String state, String country) {
		return addressRepository.createAddress(street, city, zipcode, state, country);
	}
	
	

}
