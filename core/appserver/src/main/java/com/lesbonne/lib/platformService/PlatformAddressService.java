package com.lesbonne.lib.platformService;

import org.springframework.stereotype.Service;

import com.lesbonne.api.rest.AppRestAddressClientImpl;
import com.lesbonne.business.bean.Address;

/**
 * This is the service layer concatenate platform UserEntityObject with appserver UserEntityProvider
 * 
 * Use Strategy pattern to decouple different ways of communicating with Platform code
 * 
 * @author shuchun.yang
 * @since 1
 * */
@Service
public abstract class PlatformAddressService implements PlatformService {
	
	public AppRestAddressClientImpl getAddressRestClient() {
		return new AppRestAddressClientImpl(Address.class);
	}
	
	public AppRestAddressClientImpl getAddressArrayRestClient() {
		return new AppRestAddressClientImpl(Address[].class);
	}
}
