/**
 * 
 */
package app.service;

import app.domain.Address;

/**
 * @author luungocha bui
 *
 */
public interface IAddressService {
	public Address createAddress(String street, String city, String zipcode, String state, String country );
}
