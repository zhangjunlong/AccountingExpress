package com.openthinks.ae.account.service.impl;

import java.util.Collection;

import com.openthinks.ae.account.Account;
import com.openthinks.ae.account.dao.AccountDao;
import com.openthinks.ae.account.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public Account find(long id) throws Exception {
		return accountDao.read(id);
	}

	@Override
	public Account find(String uname) throws Exception {
		return accountDao.read(uname);
	}

	@Override
	public Account authorize(String uname, String password) throws Exception {
		Account account = accountDao.read(uname);
		if (account != null) {
			if (password.equals(account.getPassword())) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> find() throws Exception {
		return accountDao.read();

	}

	public void create(Account account) throws Exception {
		accountDao.create(account);
	}

	public void update(Account account) throws Exception {
		accountDao.update(account);
	}

	@Override
	public void delete(long id) throws Exception {
		Account persistedAccount = accountDao.read(id);
		accountDao.delete(persistedAccount);
	}

}
