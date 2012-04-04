package com.openthinks.ae.report.dao;

import java.util.Collection;

import com.openthinks.ae.report.ModelReportByAccountItem;

public interface ModelReportDao {

	Collection<ModelReportByAccountItem> countModeByAccount(String accountId)
			throws Exception;

}
