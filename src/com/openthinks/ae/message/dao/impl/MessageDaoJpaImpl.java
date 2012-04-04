package com.openthinks.ae.message.dao.impl;

import java.util.Collection;

import com.openthinks.ae.message.Message;
import com.openthinks.ae.message.dao.MessageDao;
import com.openthinks.dao.GenericJpaDaoBean;

/**
 * A implementation of JPA data access for account
 * 
 * @author Zhang Junlong
 * 
 */
public class MessageDaoJpaImpl extends GenericJpaDaoBean<Message, Long>
		implements MessageDao {

	public MessageDaoJpaImpl() {
		super(Message.class);
	}

	@Override
	public Collection<Message> find(long uid) throws Exception {
		String ql = "SELECT m FROM Message m WHERE m.receiver.id = ?0";

		return this.query(ql, uid);
	}
}
