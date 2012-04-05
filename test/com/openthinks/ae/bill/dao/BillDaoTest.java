package com.openthinks.ae.bill.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.openthinks.SpringTestSupport;
import com.openthinks.ae.bill.Bill;
import com.openthinks.ae.bill.dao.BillDao;

@Transactional
public class BillDaoTest extends SpringTestSupport {

	@Autowired
	private BillDao billDao;

	@Test
	public void testRead() throws Exception {
		Bill msg = new Bill();
		msg.setClient("test message");
		msg.setAmount(9);

		billDao.create(msg);
		Bill persistedMsg = billDao.read(msg.getId());
		assertEquals(msg.getClient(), persistedMsg.getClient());

		// Read
		Bill msg1 = billDao.read(msg.getId());
		msg1.setAmount(0);

		Bill msg2 = billDao.read(msg1.getId());

		assertEquals(msg1.getAmount(), msg2.getAmount(), 0.01);
	}

	@Test
	public void testCrud() throws Exception {
		Bill msg = new Bill();
		msg.setClient("test message");

		billDao.create(msg);
		Bill persistedMsg = billDao.read(msg.getId());
		assertEquals(msg.getClient(), persistedMsg.getClient());

		msg.setClient("modified");
		billDao.update(msg);
		persistedMsg = billDao.read(msg.getId());
		assertEquals(msg.getClient(), persistedMsg.getClient());

		billDao.delete(msg);
		assertNull(billDao.read(msg.getId()));

	}
}
