package com.openthinks.ae.bill.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Query;

import com.openthinks.ae.bill.BillStatistics;
import com.openthinks.ae.bill.PaymentPattern;
import com.openthinks.ae.bill.dao.BillStatisticsDao;
import com.openthinks.dao.GenericJpaDaoBean;

public class BillStatisticsDaoImpl extends
		GenericJpaDaoBean<BillStatistics, Long> implements BillStatisticsDao {

	public BillStatisticsDaoImpl() {
		super(BillStatistics.class);
	}

	@Override
	public long sumAmount(String beginDate, String endDate, long uid) {
		String ql = "SELECT SUM (b.amount) FROM Bill b WHERE b.operator.id = ?0 AND b.date >= ?1 AND b.date <= ?2 GROUP BY b.id";

		Query query = em.createQuery(ql);
		query.setParameter(0, uid);
		java.text.SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			query.setParameter(1, df.parse(beginDate));
			query.setParameter(2, df.parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long amount = (Long) query.getSingleResult();

		return amount;
	}

	@Override
	public long sumCashAmount(String beginDate, String endDate, long uid) {
		String ql = "SELECT SUM (b.amount) FROM bill b WHERE b.operator.id = ?0 AND b.date >= ?1 AND b.date <= ?2 AND b.paymentPattern="
				+ PaymentPattern.CASH;

		Query query = em.createQuery(ql);
		query.setParameter(0, uid);
		query.setParameter(1, beginDate);
		query.setParameter(2, endDate);

		long amount = (Long) query.getSingleResult();

		return amount;
	}

}
