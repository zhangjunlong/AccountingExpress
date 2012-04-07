package com.openthinks.ae.account.service;

import java.util.Collection;

import com.openthinks.ae.account.Account;

/**
 * Account Service Interface
 * 
 * @author Zhang Junlong
 * 
 */
public interface AccountService {
	/**
	 * Authorize a account
	 * 
	 * @return
	 */
	Account authorize(String uname, String password) throws Exception;

	/**
	 * Find out an account by account's id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Account find(long id) throws Exception;

	/**
	 * Find out all accounts
	 * 
	 * @return
	 */
	Collection<Account> find() throws Exception;

	void create(Account account) throws Exception;

	void update(Account account) throws Exception;

	void delete(long id) throws Exception;

	/**
	 * Find an account by uname
	 * 
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	Account find(String uname) throws Exception;

}
