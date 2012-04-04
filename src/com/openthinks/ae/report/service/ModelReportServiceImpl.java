package com.openthinks.ae.report.service;

import java.util.Collection;

import com.openthinks.ae.report.ModelReportByAccountItem;
import com.openthinks.ae.report.dao.ModelReportDao;

public class ModelReportServiceImpl implements ModelReportService {

	private ModelReportDao modelReportDao;

	public void setModelReportDao(ModelReportDao modelReportDao) {
		this.modelReportDao = modelReportDao;
	}

	@Override
	public Collection<ModelReportByAccountItem> analyzeModelByAccount(
			String accountId) throws Exception {
		return modelReportDao.countModeByAccount(accountId);
	}
}
