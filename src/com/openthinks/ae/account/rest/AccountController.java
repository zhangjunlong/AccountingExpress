package com.openthinks.ae.account.rest;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.openthinks.ae.account.Account;
import com.openthinks.ae.account.service.AccountService;
import com.openthinks.ae.rest.GenericRestfulController;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "account" }) })
public class AccountController extends GenericRestfulController {

	private static final long serialVersionUID = 1L;

	private Account model;

	private Collection<Account> list;

	private AccountService accountService;

	public AccountController() {
		super(new Account());
		model = (Account) this.getModel();
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	@Override
	public HttpHeaders show() {

		try {
			model = accountService.find(model.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public HttpHeaders index() {
		try {
			list = accountService.find();

			this.setlResponseContent(list);
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public HttpHeaders create() {
		try {
			accountService.create(model);

			this.setSuccessfulResponseContent();
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
		}

		return new DefaultHttpHeaders("success").setLocationId(model.getId());
	}

	@Override
	public String update() {
		try {
			accountService.update(model);

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
			accountService.delete(model.getId());

			this.setSuccessfulResponseContent();
		} catch (Exception e) {
			e.printStackTrace();

			this.setFailedResponseContent();
		}

		return "success";
	}

	public void setAccountService(AccountService accountGroupService) {
		this.accountService = accountGroupService;
	}

}
