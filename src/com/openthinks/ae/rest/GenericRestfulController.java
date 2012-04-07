package com.openthinks.ae.rest;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;

/**
 * Generic Restful Controller
 * 
 * @author Zhang Junlong
 * 
 * @param <T>
 *            Request Object Type
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
	protected static final HttpHeaders ACCEPTED;

	protected static final HttpHeaders INTERNAL_SERVER_ERROR;

	protected static final HttpHeaders OK = new DefaultHttpHeaders("success");

	protected static final DefaultHttpHeaders DISABLE_CACHING_INDEX = new DefaultHttpHeaders(
			"index").disableCaching();

	protected static final DefaultHttpHeaders DISABLE_CACHING_SHOW = new DefaultHttpHeaders(
			"show").disableCaching();

	protected Map<String, Object> session;

	/**
	 * Default response content
	 */
	protected ResponseContent responseContent;

	/**
	 * Model of request
	 */
	private Object model;

	// Flag of returning type
	boolean returnResponseContent = false;

	static {
		ACCEPTED = new DefaultHttpHeaders();
		ACCEPTED.setStatus(202);

		INTERNAL_SERVER_ERROR = new DefaultHttpHeaders();
		INTERNAL_SERVER_ERROR.setStatus(500);
	}

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
	 * Set an instance for model
	 * 
	 * @param model
	 */
	public void setModel(Object model) {
		this.model = model;
	}

	/**
	 * Set a successful response content with data in model
	 */
	protected void setSuccessfulResponseContent() {
		this.returnResponseContent = true;
		responseContent = new ResponseContent(ResponseContent.SUCCESS);

		responseContent.setExtend(model);
	}

	/**
	 * Set a successful response content with data in model
	 * 
	 * @param data
	 */
	protected void setResponseContent(Object data) {
		this.returnResponseContent = false;

		setModel(data);
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

	protected DefaultHttpHeaders getHttpHeaderOfCreated(Object id) {
		return new DefaultHttpHeaders("success").setLocationId(id);
	}
}