package com.openthinks.ae.bill;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.openthinks.ae.account.Account;

/**
 * A Generic Bill
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String serial;

	@Column(length = 50)
	private String client;

	private String commodity;

	private double amount;

	@Column(length = 10)
	private String paymentPattern;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String remark;

	@ManyToOne
	private Account operator;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Account getOperator() {
		return operator;
	}

	public void setOperator(Account operator) {
		this.operator = operator;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentPattern() {
		return paymentPattern;
	}

	public void setPaymentPattern(String paymentPattern) {
		this.paymentPattern = paymentPattern;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

}
