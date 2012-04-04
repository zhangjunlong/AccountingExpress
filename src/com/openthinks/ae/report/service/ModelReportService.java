package com.openthinks.ae.report.service;

import java.util.Collection;

import com.openthinks.ae.report.ModelReportByAccountItem;

public interface ModelReportService {
	Collection<ModelReportByAccountItem> analyzeModelByAccount(String account)
			throws Exception;
}
