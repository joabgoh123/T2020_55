package com.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Transaction {
	
	@JsonProperty("transactionId")
	private String transactionId;
	
	@JsonProperty("accountId")
	private String accountId;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("amount")
	private double amount;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("tag")
	private String tag;
	
	@JsonProperty("referenceNumber")
	private String referenceNumber;

	public Transaction(String transactionId, String accountId, String type, double amount, String date, String tag,
			String referenceNumber) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.tag = tag;
		this.referenceNumber = referenceNumber;
	}

	public Transaction() {
		super();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountId=" + accountId + ", type=" + type
				+ ", amount=" + amount + ", date=" + date + ", tag=" + tag + ", referenceNumber=" + referenceNumber
				+ "]";
	}

	
}

