package com.openthinks.ae.bill.service;

import com.openthinks.ae.bill.BillStatistics;

public interface BillStatisticsService {
	BillStatistics countGeneralStatistics(String beginDate, String endDate,
			String uid);
}
