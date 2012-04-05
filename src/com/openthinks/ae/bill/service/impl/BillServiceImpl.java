package com.openthinks.ae.bill.service.impl;

import java.util.Collection;
import java.util.Date;

import com.openthinks.ae.account.dao.AccountDao;
import com.openthinks.ae.bill.Bill;
import com.openthinks.ae.bill.dao.BillDao;
import com.openthinks.ae.bill.service.BillService;

public class BillServiceImpl implements BillService {

	BillDao billDao;

	AccountDao accountDao;

	public void setMessageDao(BillDao billDao) {
		this.billDao = billDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public Bill create(Bill bill, long operatorId) throws Exception {

		bill.setOperator(accountDao.read(operatorId));
		bill.setTimestamp(new Date());

		billDao.create(bill);

		return bill;
	}

	@Override
	public Collection<Bill> retrieveMsgs(long uid) throws Exception {

		return billDao.find(uid);

	}

	@Override
	public void delete(long msgId) throws Exception {
		Bill msg = billDao.read(msgId);
		billDao.delete(msg);
	}

}
