package app.repository;

import app.domain.Address;

public interface IAddressRepository {
	public Address createAddress(String street, String city, String zipcode, String state, String country );
}
