package com.openthinks.ae.profile.service.impl;

import java.util.Collection;
import java.util.List;

import com.openthinks.ae.profile.User;
import com.openthinks.ae.profile.dao.TenantDao;
import com.openthinks.ae.profile.dao.UserDao;
import com.openthinks.ae.profile.service.UserService;
import com.openthinks.dao.SectionResult;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	private TenantDao tenantDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setTenantDao(TenantDao tenantDao) {
		this.tenantDao = tenantDao;
	}

	@Override
	public List<User> find() throws Exception {
		return userDao.read();
	}

	@Override
	public SectionResult<User> find(int size, int section) throws Exception {
		return userDao.read(size, section);
	}

	@Override
	public SectionResult<Object> find(String accountId, String keywords,
			String productSeason, String productStyle, int orderType, int size,
			int section) throws Exception {
		return userDao.read(accountId, keywords, productSeason, productStyle,
				orderType, size, section);
	}

	@Override
	public User find(long id) throws Exception {
		return userDao.read(id);
	}

	public void create(User user) throws Exception {
		if (user.getTenant() != null)
			user.setTenant(tenantDao.read(user.getTenant().getId()));
		userDao.create(user);
	}

	public void create(Collection<User> people) throws Exception {
		try {
			for (User person : people) {
				userDao.create(person);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(User person) throws Exception {
		userDao.update(person);
	}

	@Override
	public void delete(long id) throws Exception {
		User persistentPerson = userDao.read(id);
		userDao.delete(persistentPerson);
	}

}
