package com.openthinks.ae.profile.service;

import java.util.Collection;

import com.openthinks.ae.profile.Tenant;

public interface TenantService {
	void create(Tenant category) throws Exception;

	Tenant find(int id, boolean simply) throws Exception;

	Collection<Tenant> find(boolean simply) throws Exception;

	void update(Tenant category) throws Exception;

	void delete(int id) throws Exception;
}
