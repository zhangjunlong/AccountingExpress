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

	public AccountController() {
		super(new Account());
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	private Collection<Account> list;

	private AccountService accountService;

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	@Override
	public HttpHeaders show() {

		try {
			model = accountService.find(((Account) model).getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public HttpHeaders index() {
		try {
			list = accountService.find();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public HttpHeaders create() {
		try {
			accountService.create((Account) model);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("success")
				.setLocationId(((Account) model).getId());
	}

	@Override
	public String update() {
		try {
			accountService.update((Account) model);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public String destroy() {
		try {
			accountService.delete(((Account) model).getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public Object getModel() {
		if (responseContent != null)
			return responseContent;
		else
			return (list != null ? list : model);
	}

	public void setAccountService(AccountService accountGroupService) {
		this.accountService = accountGroupService;
	}

}
