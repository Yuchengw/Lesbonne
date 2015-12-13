package com.lesbonne.partner;

/**
 * @author yucheng
 * @since 1
 * */
public interface PartnerDAO {

	void persistPartner(Partner partner);
	
	Partner getPartnerById(String partnerId);
	
	Partner updatePartner(Partner partner);
	
	void deletePartner(Partner partner);
}
