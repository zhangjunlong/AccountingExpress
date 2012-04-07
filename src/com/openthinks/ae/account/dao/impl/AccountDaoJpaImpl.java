package com.openthinks.ae.account.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.openthinks.ae.account.Account;
import com.openthinks.ae.account.dao.AccountDao;
import com.openthinks.dao.GenericJpaDaoBean;

/**
 * A implementation of JPA data access for account
 * 
 * @author Zhang Junlong
 * 
 */
public class AccountDaoJpaImpl extends GenericJpaDaoBean<Account, Long>
		implements AccountDao {

	public AccountDaoJpaImpl() {
		super(Account.class);
	}

	@Override
	public double sumFinishOrderAmount(String id) {
		double amount = 0.0;
		String sql = "SELECT sum(amount) FROM orderform where account_username like ?1";
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, id);

		List<Object> queryList = query.getResultList();

		for (int i = 0; i < queryList.size(); i++) {
			Object res = queryList.get(i);
			amount = res == null ? 0 : (Double) res;
		}
		return amount;
	}

	@Override
	public Collection<Account> read() throws Exception {
		String ql = "select a from Account a";

		return readSpecifiedSection(ql, 0, 1).getResultList();
	}

	@Override
	public Account read(String uname) throws Exception {
		String ql = "select a from Account a where a.uname = ?0";
		Query query = em.createQuery(ql);
		query.setParameter(0, uname);

		try {
			return (Account) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
