package com.openthinks.ae.system.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.openthinks.ae.account.Account;
import com.openthinks.ae.account.Role;
import com.openthinks.ae.account.service.AccountService;
import com.openthinks.ae.system.configuration.PropertiesReader;
import common.Logger;

/**
 * Listener to initialize system configurations on startup
 * 
 * @author Zhang Junlong
 * 
 */
public class InitializationListener implements ServletContextListener {

	private static final Logger logger = Logger
			.getLogger(InitializationListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {

		ServletContext context = event.getServletContext();

		WebApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(context);

		AccountService accountService = (AccountService) applicationContext
				.getBean("accountService");

		PropertiesReader pr = new PropertiesReader("system.properties");
		String id = pr.getProperties("admin.userid");
		String un = pr.getProperties("admin.name");
		String pw = pr.getProperties("admin.password");

		Account account = new Account();
		account.setUname(id);
		account.setName(un);
		account.setPassword(pw);
		account.setRole(Role.ADMIN);

		try {
			accountService.create(account);

			logger.info("Default Account for system administration initialized.");
		} catch (Exception e) {
			logger.error("Faild to initialize default account.", e);

			e.printStackTrace();
		}

	}

}
