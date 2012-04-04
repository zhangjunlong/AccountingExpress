package com.openthinks.ae.report.service;

import com.openthinks.ae.report.ColorReport;

public interface ColorReportService {

	/**
	 * Generates ordering report of color.
	 * 
	 * @param accountId
	 * @return
	 */
	ColorReport analyzeColor(String accountId, String brand) throws Exception;
}
