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

	private Tenant model;

	private Collection<Tenant> list;

	public TenantController() {
		super(new Tenant());
		model = (Tenant) super.getModel();
	}

	public HttpHeaders create() {
		try {
			tenantService.create(model);

			addActionMessage("New brand created successfully");

			this.setSuccessfulResponseContent();
		} catch (Exception e) {
			e.printStackTrace();
			addFieldError("clientName", "The client name is empty");

			this.setFailedResponseContent();
		}

		return new DefaultHttpHeaders("success").setLocation(String
				.valueOf(model.getId()));
	}

	public HttpHeaders show() {
		try {
			model = tenantService.find(Integer.parseInt(id), false);

			setSuccessfulResponseContent();
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
		}

		return new DefaultHttpHeaders("show");
	}

	@Override
	public HttpHeaders index() {
		try {
			list = tenantService.find(true);

			this.setResponseContent(list);
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public String update() {
		try {

			tenantService.update(model);

			addActionMessage("Order updated successfully");

			this.setSuccessfulResponseContent();
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
		}

		return "success";
	}

	@Override
	public String destroy() {
		try {
			tenantService.delete(Integer.parseInt(id));

			this.setSuccessfulResponseContent();
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
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
