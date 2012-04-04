package com.openthinks.ae.report.service;

import java.util.List;

import com.openthinks.ae.report.BrandBigtypeReport;
import com.openthinks.ae.report.BrandReport;
import com.openthinks.ae.report.DeliveryTimeReport;
import com.openthinks.ae.report.IntegrationReport;
import com.openthinks.ae.report.SeasonCategoryReport;
import com.openthinks.ae.report.SeasonReport;
import com.openthinks.ae.report.SeriesReport;
import com.openthinks.ae.report.StructureReport;
import com.openthinks.ae.report.StyleReport;

/**
 * Service interface of generating order reports
 * 
 * @author Zhang Junlong
 * 
 */
public interface ReportService {

	StructureReport analyzeStructure() throws Exception;

	/**
	 * Generate product's report of deliver time.
	 * 
	 * @return
	 */
	DeliveryTimeReport analyzeDeliveryTime(String accountId, String brand)
			throws Exception;

	/**
	 * Generate a integration report including size report, category report,
	 * total amount etc.
	 * 
	 * @param accountId
	 * @return
	 */
	IntegrationReport analyzeIntegration(String accountId, String brand)
			throws Exception;

	
	/**
	 * Generate a season-category report list
	 * 
	 * @param accountId
	 * @return
	 */
	List<SeasonCategoryReport> analyzeSeasonCategory(String accountId,
			String brand) throws Exception;

	List<SeasonCategoryReport> analyzeSeasonBigType(String id, String brand)
			throws Exception;

	List<SeasonCategoryReport> analyzeSeasonColor(String id, String brand)
			throws Exception;

	List<BrandBigtypeReport> analyzeBrandBigtype(String accountId)
			throws Exception;

	BrandReport analyzeBrand(String accountId) throws Exception;

}
