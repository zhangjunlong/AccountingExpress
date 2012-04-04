package com.openthinks.woms.message.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.openthinks.SpringTestSupport;
import com.openthinks.ae.message.Message;
import com.openthinks.ae.message.dao.MessageDao;

@Transactional
public class MessageDaoTest extends SpringTestSupport {

	@Autowired
	private MessageDao messageDao;

	@Test
	public void testRead() throws Exception {
		Message msg = new Message();
		msg.setContent("test message");
		msg.setCurrentNoticeVersion(9);

		messageDao.create(msg);
		Message persistedMsg = messageDao.read(msg.getId());
		assertEquals(msg.getContent(), persistedMsg.getContent());

		// Read
		Message msg1 = messageDao.read(msg.getId());
		msg1.setCurrentNoticeVersion(0);

		Message msg2 = messageDao.read(msg1.getId());

		assertEquals(msg1.getCurrentNoticeVersion(),
				msg2.getCurrentNoticeVersion());
	}

	@Test
	public void testCrud() throws Exception {
		Message msg = new Message();
		msg.setContent("test message");

		messageDao.create(msg);
		Message persistedMsg = messageDao.read(msg.getId());
		assertEquals(msg.getContent(), persistedMsg.getContent());

		msg.setContent("modified");
		messageDao.update(msg);
		persistedMsg = messageDao.read(msg.getId());
		assertEquals(msg.getContent(), persistedMsg.getContent());

		messageDao.delete(msg);
		assertNull(messageDao.read(msg.getId()));

	}
}
