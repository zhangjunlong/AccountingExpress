package com.openthinks.ae.report.dao;

import java.util.Collection;

import com.openthinks.ae.report.SeasonReportItem;

public interface SeasonReportDao {

	/**
	 * Count summary of different season
	 * 
	 * @param accountId
	 * @return
	 */
	Collection<SeasonReportItem> countSeason(String accountId, String brand)
			throws Exception;
}
