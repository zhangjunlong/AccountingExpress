package com.openthinks.ae.report.service;

import com.openthinks.ae.report.StyleReport;

public interface StyleReportService {

	StyleReport analyzeStyle(String accountId, String brand) throws Exception;

}
