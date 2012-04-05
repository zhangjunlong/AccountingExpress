package com.openthinks.ae.bill.dao;

import java.util.Collection;

import com.openthinks.ae.bill.Bill;
import com.openthinks.dao.GenericDao;

public interface BillDao extends GenericDao<Bill, Long> {

	/**
	 * Get messages of specified userId
	 * 
	 * @param uid
	 * @throws Exception 
	 */
	Collection<Bill> find(long uid) throws Exception;

}
