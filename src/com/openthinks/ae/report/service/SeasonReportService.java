package com.openthinks.ae.report.service;

import com.openthinks.ae.report.SeasonReport;

public interface SeasonReportService {
	/**
	 * Generate ordering report of season.
	 * 
	 * @param accountId
	 * @return
	 */
	SeasonReport analyzeSeason(String accountId, String brand) throws Exception;

}
