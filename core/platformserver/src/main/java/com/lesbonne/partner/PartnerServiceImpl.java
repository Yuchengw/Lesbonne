package com.lesbonne.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yucheng
 * @since 1
 * */
@Service("PartnerService")
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	PartnerDAO partnerDAO;
	
	@Override
	@Transactional
	public void persistPartner(Partner partner) {
		partnerDAO.persistPartner(partner);
	}

	@Override
	public Partner getPartnerById(String partnerId) {
		return partnerDAO.getPartnerById(partnerId);
	}

	@Override
	public Partner updateParnter(Partner partner) {
		partnerDAO.updatePartner(partner);
		return partner;
	}

	@Override
	public void deletePartner(Partner partner) {
		partnerDAO.deletePartner(partner);
	}
}
