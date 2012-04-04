package com.openthinks.ae.profile.service;

import java.util.Collection;

import com.openthinks.ae.profile.User;
import com.openthinks.dao.SectionResult;

/**
 * Service interface of persons
 * 
 * @author Zhang Junlong
 * 
 */
public interface UserService {

	/**
	 * Create a new person.
	 * 
	 * @param person
	 */
	void create(User person) throws Exception;

	/**
	 * Create a list of persons
	 * 
	 * @param persons
	 * @throws Exception
	 */
	void create(Collection<User> persons) throws Exception;

	/**
	 * Find out all persons
	 * 
	 * @return
	 */
	Collection<User> find() throws Exception;

	SectionResult<User> find(int size, int section) throws Exception;

	SectionResult<Object> find(String accountId, String keywords,
			String personSeason, String personStyle, int orderType, int size,
			int section) throws Exception;

	/**
	 * Find a person by id
	 * 
	 * @param id
	 * @return
	 */
	User find(long id) throws Exception;

	void update(User person) throws Exception;

	void delete(long id) throws Exception;

}
