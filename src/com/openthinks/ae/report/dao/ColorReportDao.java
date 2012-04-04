package com.openthinks.ae.report.dao;

import java.util.Collection;

import com.openthinks.ae.report.ColorReportItem;

public interface ColorReportDao {
	/**
	 * Count summary of different color
	 * 
	 * @param accountId
	 * @return
	 */
	Collection<ColorReportItem> countColor(String accountId, String brand)
			throws Exception;
}
