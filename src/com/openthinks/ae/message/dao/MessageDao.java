package com.openthinks.ae.message.dao;

import java.util.Collection;

import com.openthinks.ae.message.Message;
import com.openthinks.dao.GenericDao;

public interface MessageDao extends GenericDao<Message, Long> {

	/**
	 * Get messages of specified userId
	 * 
	 * @param uid
	 * @throws Exception 
	 */
	Collection<Message> find(long uid) throws Exception;

}
