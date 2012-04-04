package com.openthinks.woms.product.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.openthinks.SpringTestSupport;
import com.openthinks.ae.profile.User;
import com.openthinks.ae.profile.dao.UserDao;

@Transactional
public class PersonDaoTest extends SpringTestSupport {
	@Autowired
	private UserDao productDao;

	@Test
	public void testCrud() throws Exception {

		User person = new User();
		person.setName("name");

		productDao.create(person);
		User persistedProduct = productDao.read(person.getId());
		assertEquals(person.getName(), persistedProduct.getName());

		person.setGender("male");
		productDao.update(person);
		persistedProduct = productDao.read(person.getId());
		assertEquals(person.getGender(), persistedProduct.getGender(), 0.0);

		productDao.delete(person);
		persistedProduct = productDao.read(person.getId());
		assertNull(persistedProduct);

	}
}
