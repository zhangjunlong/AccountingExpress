package com.openthinks.ae.report.dao;

import java.util.Collection;

import com.openthinks.ae.report.ColorReportItem;
import com.openthinks.dao.GenericDao;

public class ColorReportDaoJpaImpl implements ColorReportDao {

	private GenericDao<ColorReportItem, String> genericDao;

	public void setGenericDao(GenericDao<ColorReportItem, String> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public Collection<ColorReportItem> countColor(String accountId, String brand)
			throws Exception {
		String ql = "SELECT new com.openthinks.woms.report.ColorReportItem (o.color.code, o.color.name, SUM(o.quantity), SUM(o.product.orderingPrice*o.quantity) ) FROM OrderForm o WHERE o.account.userId LIKE ?0 AND o.product.brand.text LIKE ?1 GROUP BY o.color.code";

		return genericDao.query(ql, accountId, brand);

	}
}
