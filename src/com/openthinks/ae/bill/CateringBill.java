package com.openthinks.ae.bill;

import javax.persistence.Column;

/**
 * Bill of Catering
 * 
 * @author Zhang Junlong
 * 
 */
public class CateringBill extends Bill {

	@Column(length = 20)
	private String restaurant;

	@Column(length = 20)
	private String types;

	private int numberOfGuests;

	@Column(length = 10)
	private String standard;

	@Column(length = 10)
	private String referee;

	@Column(length = 20)
	private String referSerial;

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public String getReferSerial() {
		return referSerial;
	}

	public void setReferSerial(String referSerial) {
		this.referSerial = referSerial;
	}

}
