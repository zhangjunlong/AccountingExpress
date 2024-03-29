package com.openthinks.ae.report.dao;

import java.util.List;

import com.openthinks.ae.report.BrandBigtypeReportItem;
import com.openthinks.ae.report.BrandReportItem;
import com.openthinks.ae.report.QuantityByCategory;
import com.openthinks.ae.report.SeasonCategoryReportItem;
import com.openthinks.ae.report.SeasonReportItem;
import com.openthinks.ae.report.SeriesReportItem;

/**
 * Data access interface of reporting
 * 
 * @author Zhang Junlong
 * 
 */
public interface ReportDao {

	/**
	 * Count the total of all serial numbers in database.
	 * 
	 * @return
	 */
	long countSn(String deliveryTime, String brand) throws Exception;

	/**
	 * Count the number of ordered products with different sn
	 * 
	 * @return
	 */
	long countOrderedSn(String deliveryTime, String accountId, String brand)
			throws Exception;

	/**
	 * Count the total of all products in database.
	 * 
	 * @return
	 */
	long countProduct(String deliveryTime, String brand) throws Exception;

	/**
	 * Count the number of ordered products
	 * 
	 * @return
	 */
	long countOrderedProduct(String deliveryTime, String accountId, String brand)
			throws Exception;

	/**
	 * Read delivery times of all product.
	 * 
	 * @return
	 */
	List<String> readAllDeliveryTime(String brand) throws Exception;

	/**
	 * Compute quantity by size
	 * 
	 * @param accountId
	 * @return
	 */
	List sumQuantity(String accountId, String brand) throws Exception;

	/**
	 * Compute quantity by category
	 * 
	 * @param accountid
	 * @return
	 */
	List<QuantityByCategory> sumQuantityByCategory(String accountid,
			String brand) throws Exception;

	

	List<SeasonCategoryReportItem> countQuantityBySeasonWithCategory(
			String accountId, String brand) throws Exception;

	List<SeasonCategoryReportItem> countQuantityBySeasonWithBigType(
			String accountId, String brand) throws Exception;

	List<SeasonCategoryReportItem> countQuantityBySeasonWithColor(
			String accountId, String brand) throws Exception;

	List<BrandBigtypeReportItem> sumQuantityWithBrandBigtype(String accountId)
			throws Exception;

	List<BrandReportItem> sumQuantityByBrand(String accountId) throws Exception;
}
