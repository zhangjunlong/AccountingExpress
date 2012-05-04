package com.openthinks.ae.bill.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.openthinks.SpringTestSupport;
import com.openthinks.ae.account.Account;
import com.openthinks.ae.account.dao.AccountDao;
import com.openthinks.ae.bill.Bill;

@Transactional
public class BillStatisticDaoTest extends SpringTestSupport {

	@Autowired
	BillDao billDao;

	@Autowired
	AccountDao accountDao;

	@Autowired
	BillStatisticsDao billStatDao;

	private Account tAcc;

	@Before
	public void initTestData() throws Exception {
		Account acc = new Account();
		acc.setUname("test");

		accountDao.create(acc);

		tAcc = acc;

		Bill bill = new Bill();

		bill.setAmount(100);
		bill.setOperator(acc);
		billDao.create(bill);

		bill = new Bill();
		bill.setAmount(50);
		bill.setOperator(acc);
		billDao.create(bill);
	}

	@Test
	public void testSumAmount() {

		long amount = billStatDao.sumAmount("2012-05-01", "2012-06-01",
				tAcc.getId());

		assertEquals(150, amount);
	}
}
