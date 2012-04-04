package com.openthinks.ae.profile;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Class of a person
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class Tenant implements Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String picture;

	@Column(length = 100)
	private String name;

	@OneToMany(fetch = FetchType.EAGER)
	private List<User> users;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
