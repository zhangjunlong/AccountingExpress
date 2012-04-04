package com.openthinks.ae.profile.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.ae.profile.Tenant;
import com.openthinks.ae.profile.User;
import com.openthinks.ae.profile.dao.TenantDao;
import com.openthinks.ae.profile.service.TenantService;

public class TenantServiceImpl implements TenantService {

	@Autowired
	private TenantDao tenantDao;

	@Override
	public void create(Tenant category) throws Exception {
		tenantDao.create(category);
	}

	@Override
	public Tenant find(int id, boolean simply) throws Exception {

		Tenant cls = tenantDao.read(id);

		if (simply) {
			cls.setUsers(null);
		} else {
			for (User cm : cls.getUsers()) {
				cm.getId();
			}

		}

		return cls;
	}

	@Override
	public Collection<Tenant> find(boolean simply) throws Exception {
		Collection<Tenant> clses = tenantDao.read();
		if (simply) {
			for (Tenant cls : clses) {
				cls.setUsers(null);
			}
		} else {
			for (Tenant cls : clses) {
				// Fetch classes
				for (User cm : cls.getUsers()) {
					cm.getId();
				}
			}
		}
		return tenantDao.read();
	}

	@Override
	public void update(Tenant category) throws Exception {
		tenantDao.update(category);
	}

	@Override
	public void delete(int id) throws Exception {
		Tenant category = tenantDao.read(id);
		tenantDao.delete(category);
	}

}
