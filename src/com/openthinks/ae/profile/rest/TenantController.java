package com.openthinks.ae.profile.rest;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.ae.profile.Tenant;
import com.openthinks.ae.profile.service.TenantService;
import com.openthinks.ae.rest.GenericRestfulController;
import com.openthinks.ae.rest.ResponseContent;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "tenant" }) })
public class TenantController extends GenericRestfulController {

	/**
	 * Serial versionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TenantService tenantService;

	private String id;

	private Collection<Tenant> list;

	public HttpHeaders create() {
		try {
			tenantService.create(model);

			addActionMessage("New brand created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			addFieldError("clientName", "The client name is empty");

			responseContent = new ResponseContent(ResponseContent.FAILURE, e.getMessage());
		}

		return new DefaultHttpHeaders("success").setLocation(String
				.valueOf(model.getId()));
	}

	public HttpHeaders show() {
		try {
			model = tenantService.find(Integer.parseInt(id), false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("show");
	}

	@Override
	public HttpHeaders index() {
		try {
			list = tenantService.find(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public String update() {
		try {

			tenantService.update(model);

			addActionMessage("Order updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public String destroy() {
		try {
			tenantService.delete(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Object getModel() {
		if (responseContent != null)
			return responseContent;
		else
			return (list != null ? list : model);
	}

	public void setId(String id) {
		if (id != null) {
			// this.model = id;
		}
		this.id = id;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

}
