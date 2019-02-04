package app.repository;

import app.domain.Address;

public class AddressRepositoryImpl implements IAddressRepository {

	public AddressRepositoryImpl() {}

	@Override
	public Address createAddress(String street, String city, String zipcode, String state, String country) {
		return new Address( street, city, zipcode, state, country);
	}

}
