package com.openthinks.ae.report.service;

import com.openthinks.ae.report.CategoryReport;

public interface CategoryReportService {

	/**
	 * Generates ordering report of color.
	 * 
	 * @param accountId
	 * @return
	 */
	CategoryReport analyzeCategory(String accountId, String brand) throws Exception;
}
