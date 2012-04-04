package com.openthinks.ae.profile.dao.impl;

import java.util.Collection;

import com.openthinks.ae.profile.Tenant;
import com.openthinks.ae.profile.dao.TenantDao;
import com.openthinks.dao.GenericJpaDaoBean;

public class TenantDaoJpaImpl extends GenericJpaDaoBean<Tenant, Integer>
		implements TenantDao {

	public TenantDaoJpaImpl() {
		super(Tenant.class);
	}

	@Override
	public Collection<Tenant> read() throws Exception {
		String ql = "select c from Tenant c";
		return this.readSpecifiedSection(ql, 0, 1).getResultList();
	}

}
