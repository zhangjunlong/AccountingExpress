package com.openthinks.ae.report.service;

import com.openthinks.ae.report.SeriesReport;

public interface SeriesReportService {
	/**
	 * Generate a category report
	 * 
	 * @param string
	 * @return
	 */
	SeriesReport analyzeSeries(String account, String brand) throws Exception;

}
