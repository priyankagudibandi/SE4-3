package com.core.swng.app.model;

public class UserBean {
	private int id;
	private String name;
	private String cpf;
	private String phone;
	private String email;
	
	
	public UserBean() {
	}

	public UserBean(int id, String name, String cpf, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
		this.email = email;
	}
	public UserBean(String name, String cpf, String phone, String email) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
		this.email = email;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
