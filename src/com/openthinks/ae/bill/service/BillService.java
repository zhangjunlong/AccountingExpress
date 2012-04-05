package com.openthinks.ae.bill.service;

import java.util.Collection;

import com.openthinks.ae.bill.Bill;

public interface BillService {

	Bill create(Bill bill, long operatorId) throws Exception;

	/**
	 * Retrieve an user's messages
	 * 
	 * @param uid
	 * @return
	 */
	Collection<Bill> retrieveMsgs(long uid) throws Exception;

	void delete(long msgId) throws Exception;

}
