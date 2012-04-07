package com.openthinks.ae.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.openthinks.ae.account.Account;

/**
 * Individual user of the system. Be subordinate to tenants.
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class User extends Account implements Profile {

	@Column(length = 10, unique = true)
	private String gender;

	@Column(length = 128)
	private String picture;

	@ManyToOne
	private Tenant tenant;

	@Column(length = 100)
	private String remark;

	public User() {
		super();
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
