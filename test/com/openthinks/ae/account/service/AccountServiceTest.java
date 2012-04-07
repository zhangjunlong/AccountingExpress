package com.openthinks.ae.account.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.openthinks.SpringTestSupport;
import com.openthinks.ae.account.Account;
import com.openthinks.ae.account.service.AccountService;

@Transactional
public class AccountServiceTest extends SpringTestSupport {
	@Autowired
	private AccountService accountService;

	@Test
	public void testCreate() {
		Account account = new Account();
		account.setUname("sa");
		account.setPassword("sa");

		try {
			accountService.create(account);

			assertEquals(account.getUname(),
					accountService.find(account.getId()).getUname());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
