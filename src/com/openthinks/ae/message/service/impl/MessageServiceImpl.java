package com.openthinks.ae.message.service.impl;

import java.util.Collection;
import java.util.Date;

import com.openthinks.ae.account.dao.AccountDao;
import com.openthinks.ae.message.Message;
import com.openthinks.ae.message.dao.MessageDao;
import com.openthinks.ae.message.service.MessageService;

public class MessageServiceImpl implements MessageService {

	MessageDao messageDao;

	AccountDao accountDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public Message create(String content, long senderId, long receiverId)
			throws Exception {
		Message msg = new Message();
		msg.setSender(accountDao.read(senderId));
		msg.setReceiver(accountDao.read(receiverId));
		msg.setContent(content);
		msg.setDate(new Date());

		messageDao.create(msg);

		return msg;
	}

	@Override
	public Collection<Message> retrieveMsgs(long uid) throws Exception {

		return messageDao.find(uid);

	}

	@Override
	public void delete(long msgId) throws Exception {
		Message msg = messageDao.read(msgId);
		messageDao.delete(msg);
	}

}
