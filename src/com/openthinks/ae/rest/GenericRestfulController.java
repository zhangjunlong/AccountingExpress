package com.openthinks.ae.rest;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;

/**
 * Generic controller
 * 
 * @author Zhang Junlong
 * 
 */
public abstract class GenericRestfulController extends ValidationAwareSupport
		implements ModelDriven<Object>, Validateable, SessionAware {

	/**
	 * Default Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * HTTP Header of code 202
	 */
	protected static HttpHeaders ACCEPTED;

	protected static HttpHeaders INTERNAL_SERVER_ERROR;

	protected Map<String, Object> session;

	/**
	 * Default response content
	 */
	protected ResponseContent responseContent;

	/**
	 * Model of request
	 */
	protected Object model;

	// Flag of returning type
	boolean returnResponseContent = false;

	static {
		ACCEPTED = new DefaultHttpHeaders();
		ACCEPTED.setStatus(202);

		INTERNAL_SERVER_ERROR = new DefaultHttpHeaders();
		INTERNAL_SERVER_ERROR.setStatus(500);
	}

	/**
	 * Type of model must be specified used the Constructor
	 * 
	 * @param model
	 */
	public GenericRestfulController(Object model) {
		this.model = model;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * Method GET
	 * 
	 * URI: /{id}
	 */
	abstract public HttpHeaders show();

	/**
	 * List all
	 * 
	 * Method: GET
	 * 
	 * URI: /
	 * 
	 * @return
	 */
	abstract public HttpHeaders index();

	/**
	 * Create a new order
	 * 
	 * Method: POST
	 * 
	 * URI: /order
	 * 
	 * @return
	 */
	abstract public HttpHeaders create();

	/**
	 * Update
	 * 
	 * Method: PUT
	 * 
	 * URI: /{id}
	 * 
	 * @return
	 */
	abstract public String update();

	/**
	 * Delete
	 * 
	 * Method: DELETE
	 * 
	 * URI: /{ID}
	 * 
	 * @return
	 */
	abstract public String destroy();

	@Override
	public Object getModel() {
		if (returnResponseContent)
			return responseContent;
		else
			return model;
	}

	/**
	 * Set a successful response content with data in model
	 */
	protected void setSuccessfulResponseContent() {
		this.returnResponseContent = true;
		responseContent = new ResponseContent(ResponseContent.SUCCESS);

		responseContent.setData(model);
	}

	/**
	 * Set a successful response content with data in model
	 * 
	 * @param description
	 */
	protected void setSuccessfulResponseContent(String description) {
		this.returnResponseContent = true;
		responseContent = new ResponseContent(ResponseContent.SUCCESS);

		responseContent.setData(model);
	}

	/**
	 * Set a failed response content
	 * 
	 * @param description
	 */
	protected void setFailedResponseContent(String description) {
		this.returnResponseContent = true;
		responseContent = new ResponseContent(ResponseContent.FAILURE);
		responseContent.setDescription(description);
	}

	/**
	 * Set a failed response content
	 */
	protected void setFailedResponseContent() {
		this.returnResponseContent = true;
		responseContent = new ResponseContent(ResponseContent.FAILURE);
	}

}