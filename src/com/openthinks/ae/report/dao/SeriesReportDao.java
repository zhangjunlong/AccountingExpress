package com.openthinks.ae.report.dao;

import java.util.Collection;

import com.openthinks.ae.report.SeriesReportItem;

public interface SeriesReportDao {
	Collection<SeriesReportItem> countSeries(String accountId, String brand)
			throws Exception;
}
