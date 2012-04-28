package com.openthinks.ae.bill.dao;

public interface BillStatisticsDao {
	long sumAmount(String beginDate, String endDate, long uid);

	long sumCashAmount(String beginDate, String endDate, long uid);
}
