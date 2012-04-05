package com.openthinks.ae.bill.rest;

import java.util.Collection;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ActionContext;
import com.openthinks.ae.account.service.AccountService;
import com.openthinks.ae.bill.Bill;
import com.openthinks.ae.bill.service.BillService;
import com.openthinks.ae.rest.GenericRestfulController;
import com.openthinks.ae.rest.Message;
import common.Logger;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "bill" }) })
public class BillController extends GenericRestfulController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(BillController.class);

	Bill model = new Bill();

	Collection<Bill> bills;

	Message msg;

	BillService billService;

	AccountService accountService;

	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public Object getModel() {
		if (msg != null)
			return msg;
		else
			return (null != bills ? bills : model);
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	@Override
	public HttpHeaders show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders index() {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			long uid = (Long) session.get("id");

			bills = billService.retrieveMsgs(uid);

			msg = new com.openthinks.ae.rest.Message(
					com.openthinks.ae.rest.Message.SUCCESS);

			msg.setExtend(bills);

			return new DefaultHttpHeaders("index").disableCaching();

		} catch (Exception e) {
			logger.debug(e);

			msg = new com.openthinks.ae.rest.Message(
					com.openthinks.ae.rest.Message.FAILURE);

			return INTERNAL_SERVER_ERROR;
		}

	}

	@Override
	public HttpHeaders create() {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			long accountId = (Long) session.get("id");

			model = billService.create(model, accountId);

			msg = new com.openthinks.ae.rest.Message(
					com.openthinks.ae.rest.Message.SUCCESS);

			return new DefaultHttpHeaders("success").setLocationId(model
					.getId());
		} catch (Exception e) {
			logger.debug(e);

			msg = new com.openthinks.ae.rest.Message(
					com.openthinks.ae.rest.Message.FAILURE);

			return ACCEPTED;
		}
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String destroy() {
		// TODO Auto-generated method stub
		return null;
	}

}
