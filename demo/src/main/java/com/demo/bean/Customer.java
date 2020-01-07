package com.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Customer {
	
	@JsonProperty("customerId")
	private String customerId;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("lastLogIn")
	private String lastLogIn;
	
	@JsonProperty("dateOfBirth")
	private String dateOfBirth;
	
	@JsonProperty("riskLevel")
	private String riskLevel;
	public Customer(String customerId, String gender, String firstName, String lastName, String lastLogIn,
			String dateOfBirth, String riskLevel) {
		super();
		this.customerId = customerId;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastLogIn = lastLogIn;
		this.dateOfBirth = dateOfBirth;
		this.riskLevel = riskLevel;
	}
	public Customer() {
		super();
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastLogIn() {
		return lastLogIn;
	}
	public void setLastLogIn(String lastLogIn) {
		this.lastLogIn = lastLogIn;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", gender=" + gender + ", firstName=" + firstName + ", lastName="
				+ lastName + ", lastLogIn=" + lastLogIn + ", dateOfBirth=" + dateOfBirth + ", riskLevel=" + riskLevel
				+ "]";
	}
	
	
	
}
