package com.openthinks.ae.bill.dao.impl;

import java.util.Collection;

import com.openthinks.ae.bill.Bill;
import com.openthinks.ae.bill.dao.BillDao;
import com.openthinks.dao.GenericJpaDaoBean;

/**
 * A implementation of JPA data access for account
 * 
 * @author Zhang Junlong
 * 
 */
public class BillDaoJpaImpl extends GenericJpaDaoBean<Bill, Long>
		implements BillDao {

	public BillDaoJpaImpl() {
		super(Bill.class);
	}

	@Override
	public Collection<Bill> find(long uid) throws Exception {
		String ql = "SELECT m FROM Message m WHERE m.receiver.id = ?0";

		return this.query(ql, uid);
	}
}
