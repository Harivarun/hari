package com.cg.bankwallet.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Bank_Accounts")
public class AccountBean {

	@Id
	private int accountId;

	private double balance;

	private String firstName;

	private String lastName;

	private String emailId;

	private String phoneNo;

	private String panNum;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date dateOfOpening;

	private double initialDeposit;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<WalletTransaction> allTransactions;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	public Date getDateOfOpening() {
		return dateOfOpening;
	}

	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}

	public double getInitialDeposit() {
		return initialDeposit;
	}

	public void setInitialDeposit(double initialDeposit) {
		this.initialDeposit = initialDeposit;
	}

	public List<WalletTransaction> getAllTransactions() {
		return allTransactions;
	}

	public void setAllTransactions(List<WalletTransaction> allTransactions) {
		this.allTransactions = allTransactions;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPanNum() {
		return panNum;
	}

	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	@Override
	public String toString() {
		return "AccountBean [accountId=" + accountId + ", balance=" + balance
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", panNum="
				+ panNum + ", address=" + address + ", dateOfOpening="
				+ dateOfOpening + ", initialDeposit=" + initialDeposit
				+ ", allTransactions=" + allTransactions + "]";
	}

	public void addTransation(WalletTransaction wt) {
		this.allTransactions.add(wt);
	}

}