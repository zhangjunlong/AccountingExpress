package com.openthinks.ae.profile.rest;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.ae.profile.User;
import com.openthinks.ae.profile.service.UserService;
import com.openthinks.ae.rest.GenericRestfulController;

/**
 * Controller for view of products
 * 
 * @author Zhang Junlong
 * 
 */
@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "user" }) })
public class UserController extends GenericRestfulController {

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;

	private Collection<User> list;

	private User model;

	@Autowired
	private UserService userService;

	public UserController() {
		super(new User());
		model = (User) super.getModel();
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	public HttpHeaders show() {
		try {
			model = userService.find(model.getId());

			this.setResponseContent(model);
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
		}

		return new DefaultHttpHeaders("show");
	}

	public HttpHeaders index() {

		try {
			list = userService.find();

			this.setResponseContent(list);
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public HttpHeaders create() {
		try {
			userService.create(model);

			this.setResponseContent(model);

		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
		}

		return new DefaultHttpHeaders("success").setLocationId(model.getId());
	}

	@Override
	public String update() {
		try {
			userService.update(model);

			this.setResponseContent(model);
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
		}

		return "success";
	}

	@Override
	public String destroy() {

		try {
			userService.delete(model.getId());

			this.setSuccessfulResponseContent();
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent(e.getMessage());
		}

		return "success";
	}

}
