package com.lesbonne.partner;

/**
 * @author yucheng
 * @since 1
 * */
public interface PartnerService {
	
	void persistPartner(Partner partner);
	
	Partner getPartnerById(String partnerId);
	
	Partner updateParnter(Partner partner);
	
	void deletePartner(Partner partner);
}
