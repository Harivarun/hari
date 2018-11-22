package com.cg.bankwallet.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Bank_W_Transactions")
public class WalletTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;

	private double transactionAmt;

	private int transactionType;
	// 1- depostit 2- withdraw 3-fund transfer

	private int beneficiaryAccountId;

	private int accountId;
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Temporal(TemporalType.DATE)
	private Date transactionDate;

	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	

	public int getBeneficiaryAccountId() {
		return beneficiaryAccountId;
	}

	public void setBeneficiaryAccountId(int beneficiaryAccountId) {
		this.beneficiaryAccountId = beneficiaryAccountId;
	}
	
	@Override
	public String toString() {
		return "WalletTransaction [transactionId=" + transactionId + ", transactionAmt=" + transactionAmt
				+ ", transactionType=" + transactionType + ", beneficiaryAccountId=" + beneficiaryAccountId
				+ ", transactionDate=" + transactionDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WalletTransaction other = (WalletTransaction) obj;
		if (accountId != other.accountId)
			return false;
		return true;
	}

	
	
	
}
