package com.openthinks.ae.profile.service;

import com.openthinks.ae.profile.User;
import com.openthinks.dao.SectionResult;

public interface SimplifiedPersonService {
	SectionResult<User> find(String keywords, int pageSize,
			int page) throws Exception;
}
