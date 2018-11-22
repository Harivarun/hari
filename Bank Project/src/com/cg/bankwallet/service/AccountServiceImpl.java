package com.cg.bankwallet.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.bankwallet.bean.AccountBean;
import com.cg.bankwallet.bean.WalletTransaction;
import com.cg.bankwallet.dao.AccountDAOImpl;
import com.cg.bankwallet.dao.IAccountDAO;
import com.cg.bankwallet.exception.AccountException;
import com.cg.bankwallet.exception.AccountExceptionMessage;

public class AccountServiceImpl implements IAccountService {
	IAccountDAO dao = new AccountDAOImpl();

	@Override
	public boolean createAccount(AccountBean accountBean) throws AccountException {
		boolean isCreated = false;
		if (validData(accountBean) == true) {
			isCreated = dao.createAccount(accountBean);
		}
		return isCreated;
	}

	@Override
	public List<WalletTransaction> printTransaction(int accId) {

		return dao.printTransaction(accId);
	}

	@Override
	public double showBalance(int accId) throws AccountException {
		double balance = 0.0;
		if (dao.checkAccount(accId) == true) {
			balance = dao.showBalance(accId);
		} else {
			throw new AccountException(AccountExceptionMessage.ERROR8);
		}
		return balance;
	}

	@Override
	public boolean deposit(int accId, double amount, WalletTransaction wt) throws AccountException {
		boolean isDeposited = false;
		if (dao.checkAccount(accId) == true) {
			isDeposited = dao.deposit(accId, amount, wt);
		} else {
			throw new AccountException(AccountExceptionMessage.ERROR8);
		}
		return isDeposited;
	}

	@Override
	public boolean withdraw(int accId, double amount, WalletTransaction wt) throws AccountException {
		boolean isWithdrawed = false;
		if (dao.checkAccount(accId) == true) {
			isWithdrawed = dao.withdraw(accId, amount, wt);
		} else {
			throw new AccountException(AccountExceptionMessage.ERROR8);
		}
		return isWithdrawed;
	}

	@Override
	public boolean fundTransfer(int senderAccId, int targetAccId, double amount, WalletTransaction wt,
			WalletTransaction wt2) throws AccountException {
		boolean isTransfered = false;
		if (dao.checkAccount(senderAccId) == true) {
			if (dao.checkAccount(targetAccId) == true) {
				isTransfered = dao.fundTransfer(senderAccId, targetAccId, amount, wt, wt2);
			} else {
				throw new AccountException(AccountExceptionMessage.ERROR9);
			}
		} else {
			throw new AccountException(AccountExceptionMessage.ERROR10);
		}
		return isTransfered;
	}

	private boolean validData(AccountBean accountBean) throws AccountException {
		boolean isValid = false;
		if (!(accountBean.getFirstName().matches("[a-zA-Z]{3,}"))) {
			throw new AccountException(AccountExceptionMessage.ERROR1);
		} else if (!(accountBean.getLastName().matches("[a-zA-Z]{3,}"))) {
			throw new AccountException(AccountExceptionMessage.ERROR2);
		} else if (!(accountBean.getPhoneNo().toString().matches("^[6-9][0-9]{9}"))) {

			throw new AccountException(AccountExceptionMessage.ERROR5);
		} else if (!(accountBean.getEmailId()
				.matches("[a-zA-Z][a-zA-z0-9-.]*@[a-zA-Z0-9]+([.][a-zA-Z)]+)+"))) {

			throw new AccountException(AccountExceptionMessage.ERROR3);
		} else if ((accountBean.getPanNum() == null)
				|| (!(accountBean.getPanNum().matches("^[A-Z][A-Z0-9]{9}")))) {

			throw new AccountException(AccountExceptionMessage.ERROR4);
		} else if ((accountBean.getAddress() == null)
				|| (!(accountBean.getAddress().matches("[A-Za-z]{5,50}")))) {
			throw new AccountException(AccountExceptionMessage.ERROR7);
		} else if (accountBean.getBalance() == 0 || !(accountBean.getBalance() > 0)) {
			throw new AccountException(AccountExceptionMessage.ERROR6);
		} else {
			isValid = true;
		}
		return isValid;
	}

}
