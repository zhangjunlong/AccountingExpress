package com.openthinks.ae.report;

import java.util.
			Collection;

import com.openthinks.ae.account.Account;

/**
 * Model of color reporting
 * 
 * @author Zhang Junlong
 * 
 */
public class CategoryReport {
	private Account account;

	private 
			Collection<CategoryReportItem> CategoryReportItems;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public 
			Collection<CategoryReportItem> getCategoryReportItems() {
		return CategoryReportItems;
	}

	public void setCategoryReportItems(
			Collection<CategoryReportItem> colorReportItems) {
		CategoryReportItems = colorReportItems;
	}

}
