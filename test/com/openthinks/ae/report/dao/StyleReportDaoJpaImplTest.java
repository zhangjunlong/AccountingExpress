package com.openthinks.ae.report.dao;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.SpringTestSupport;
import com.openthinks.ae.report.StyleReportItem;
import com.openthinks.ae.report.dao.StyleReportDao;

public class StyleReportDaoJpaImplTest extends SpringTestSupport {

	@Autowired
	private StyleReportDao styleReportDao;

	@Test
	public void testCountStyle() {
		try {
			Collection<StyleReportItem> result = styleReportDao.countStyle("%",
					"%");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
