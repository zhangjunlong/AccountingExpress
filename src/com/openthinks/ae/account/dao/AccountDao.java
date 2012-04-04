package com.openthinks.ae.account.dao;

import java.util.Collection;

import com.openthinks.ae.account.Account;
import com.openthinks.dao.GenericDao;

/**
 * Data access interface for account
 * 
 * @author Zhang Junlong
 * 
 */
public interface AccountDao extends GenericDao<Account, Long> {

	/**
	 * Read user by User ID
	 * 
	 * @param userId
	 * @return
	 * @throws Exceptoin
	 */
	Account read(String userId) throws Exception;

	/**
	 * Read out all persisted Accounts
	 * 
	 * @return
	 * @throws Exception
	 */
	Collection<Account> read() throws Exception;

	double sumFinishOrderAmount(String id) throws Exception;

}