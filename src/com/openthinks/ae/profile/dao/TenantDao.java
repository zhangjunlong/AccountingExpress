package com.openthinks.ae.profile.dao;

import java.util.Collection;

import com.openthinks.ae.profile.Tenant;
import com.openthinks.dao.GenericDao;

public interface TenantDao extends GenericDao<Tenant, Integer> {
	/**
	 * Read all records
	 * 
	 * @return
	 */
	Collection<Tenant> read() throws Exception;
}
