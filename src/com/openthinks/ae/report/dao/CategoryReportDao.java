package com.openthinks.ae.report.dao;

import java.util.Collection;

import com.openthinks.ae.report.CategoryReportItem;

public interface CategoryReportDao {
	/**
	 * Count summary of different color
	 * 
	 * @param accountId
	 * @return
	 */
	Collection<CategoryReportItem> countCategory(String accountId, String brand)
			throws Exception;
}
