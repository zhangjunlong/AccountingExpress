package com.openthinks.ae.account.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.openthinks.SpringTestSupport;
import com.openthinks.ae.account.Account;
import com.openthinks.ae.account.dao.AccountDao;

/**
 * @author Zhang Junlong
 * 
 */

@Transactional
public class AccountDaoTest extends SpringTestSupport {
	@Autowired
	private AccountDao accountDao;

	@Test
	public void testCrud() throws Exception {
		String userId = "zhangjunlong";

		Account account = new Account();
		account.setUname(userId);
		account.setPassword("ithink");
		account.setDescription("new");

		accountDao.create(account);

		Account persistedAccount = accountDao.read(userId);
		assertEquals(account.getId(), persistedAccount.getId());

		account.setDescription("modifed");
		accountDao.update(account);

		persistedAccount = accountDao.read(userId);
		assertEquals(account.getDescription(),
				persistedAccount.getDescription());

		accountDao.delete(account);
		persistedAccount = accountDao.read(userId);
		assertNull(persistedAccount);
	}
}
