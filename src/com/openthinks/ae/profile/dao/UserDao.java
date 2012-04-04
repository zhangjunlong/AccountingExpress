package com.openthinks.ae.profile.dao;

import java.util.List;

import com.openthinks.ae.profile.User;
import com.openthinks.dao.GenericDao;
import com.openthinks.dao.SectionResult;

public interface UserDao extends GenericDao<User, Long> {
	/**
	 * Read out all people
	 * 
	 * @param section
	 * @return
	 */
	List<User> read() throws Exception;

	SectionResult<User> read(int size, int section) throws Exception;

	SectionResult<Object> read(String accountId, String keywords,
			String productSeason, String productStyle, int orderType, int size,
			int section) throws Exception;
}