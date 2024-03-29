package com.openthinks.ae.profile.rest;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;
import com.openthinks.ae.profile.User;
import com.openthinks.ae.profile.service.UserService;
import com.openthinks.ae.system.SystemConstant;
import com.openthinks.dao.SectionResult;

/**
 * 产品热度排行控制器
 * 
 * Restful 请求方式
 * 
 * @author Zhang Wenlong
 * 
 */
@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "rank" }) })
public class RankController extends ValidationAwareSupport implements
		Validateable {

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(RankController.class);

	private String id;

	private SectionResult<User> productSr;

	@Autowired
	private UserService productService;

	/**
	 * 参数验证
	 */
	public void validate() {
	}

	public void setId(String id) {
		this.id = id;
	}

	public SectionResult<User> getProductSr() {
		return productSr;
	}

	public String sortByClickCount() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentSection = Integer.parseInt(id);

		// FIX to be implement
		/**
		 * productSr = productService
		 * .retrieveProductsSortByClickCount(currentSection);
		 */
		request.setAttribute("currentSection", currentSection);
		request.setAttribute("totalSection", productSr.getTotalSection());
		request.setAttribute("pageSize", SystemConstant.CLICKCOUNT_PAGE_SIZE);

		return "sortByClickCount";
	}

}
