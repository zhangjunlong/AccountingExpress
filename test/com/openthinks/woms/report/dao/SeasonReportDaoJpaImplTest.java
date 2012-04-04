package com.openthinks.woms.report.dao;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.SpringTestSupport;
import com.openthinks.ae.report.SeasonReportItem;
import com.openthinks.ae.report.dao.SeasonReportDao;

public class SeasonReportDaoJpaImplTest extends SpringTestSupport {

	@Autowired
	private SeasonReportDao seasonReportDao;

	@Test
	public void testCountSeason() {
		try {
			Collection<SeasonReportItem> result = seasonReportDao.countSeason(
					"%", "%");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
