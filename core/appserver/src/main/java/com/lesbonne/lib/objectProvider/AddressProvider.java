package com.lesbonne.lib.objectProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesbonne.business.bean.Address;
import com.lesbonne.lib.platformService.PlatformAddressServiceImpl;

/**
 * @author shuchun.yang
 * @since 1
 * */
@Service
public class AddressProvider {

	@Autowired
	private PlatformAddressServiceImpl platformAddressServiceImpl;
	
	public PlatformAddressServiceImpl getAddressServiceImpl() {
		return (PlatformAddressServiceImpl) this.platformAddressServiceImpl;
	}
	
	public Address add(Address address) {
		return this.platformAddressServiceImpl.createAddress(address);
	}

	public boolean remove(Address address) {
		try {
			return new PlatformAddressServiceImpl().deleteAddress(address);
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * update is expensive, think before do it
	 * */
	public void update(Address address) {
		this.platformAddressServiceImpl.updateAddress(address);
	}
}
