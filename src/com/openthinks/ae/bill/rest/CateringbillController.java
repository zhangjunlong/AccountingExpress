package com.openthinks.ae.bill.rest;

import java.util.Collection;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.openthinks.ae.account.service.AccountService;
import com.openthinks.ae.bill.Bill;
import com.openthinks.ae.bill.CateringBill;
import com.openthinks.ae.bill.service.BillService;
import com.openthinks.ae.rest.GenericRestfulController;
import common.Logger;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "Cateringbill" }) })
public class CateringbillController extends GenericRestfulController {

	public CateringbillController() {
		super(new CateringBill());
		this.model = (CateringBill) super.getModel();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(CateringbillController.class);

	private CateringBill model;

	@Autowired
	private AccountService accountService;

	@Autowired
	private BillService billService;

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	@Override
	public HttpHeaders show() {
		try {
			model = (CateringBill) billService.find(model.getId());

			this.setResponseContent(model);

			return DISABLE_CACHING_SHOW;
		} catch (Exception e) {
			return INTERNAL_SERVER_ERROR;
		}
	}

	@Override
	public HttpHeaders index() {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			long uid = (Long) session.get("id");

			Collection<Bill> bills = billService.find(uid);

			this.setResponseContent(bills);

			return DISABLE_CACHING_INDEX;

		} catch (Exception e) {
			logger.debug(e);

			this.setFailedResponseContent();

			return INTERNAL_SERVER_ERROR;
		}
	}

	@Override
	public HttpHeaders create() {
		long uid = (Long) session.get("id");
		try {
			billService.create(model, uid);

			return getHttpHeaderOfCreated(model.getId());
		} catch (Exception e) {
			e.printStackTrace();

			return ACCEPTED;
		}
	}

	@Override
	public String update() {
		long uid = (Long) session.get("id");
		try {
			billService.update(model, uid);

		} catch (Exception e) {
			e.printStackTrace();

			logger.error(e);
		}

		return "success";
	}

	@Override
	public String destroy() {
		// TODO Auto-generated method stub
		return null;
	}

}
