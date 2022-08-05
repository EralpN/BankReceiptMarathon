package com.bilgeadam.bank.receipt.test;

import java.sql.Date;
import java.time.LocalDate;

import com.bilgeadam.bank.receipt.dao.AccountDao;
import com.bilgeadam.bank.receipt.dao.AccountTypeDao;
import com.bilgeadam.bank.receipt.dao.BranchDao;
import com.bilgeadam.bank.receipt.dao.CustomerDao;
import com.bilgeadam.bank.receipt.dao.IntermediaryDao;
import com.bilgeadam.bank.receipt.dao.TransactionDao;
import com.bilgeadam.bank.receipt.dao.TransactionOperationDao;
import com.bilgeadam.bank.receipt.dao.TransactionTypeDao;
import com.bilgeadam.bank.receipt.entity.Account;
import com.bilgeadam.bank.receipt.entity.AccountType;
import com.bilgeadam.bank.receipt.entity.Branch;
import com.bilgeadam.bank.receipt.entity.Customer;
import com.bilgeadam.bank.receipt.entity.Intermediary;
import com.bilgeadam.bank.receipt.entity.Transaction;
import com.bilgeadam.bank.receipt.entity.TransactionOperation;
import com.bilgeadam.bank.receipt.entity.TransactionType;

public class FillDatabase
{

	/*
	 * 
	 * Use this class only on
	 * <property name="hbm2ddl.auto">create</property>
	 * 
	 * This class is only for initiating the database.
	 * 
	 */
	
	public static void main(String[] args)
	{

		CustomerDao cd = new CustomerDao();
		Customer customer1 = new Customer("Ali", "Kara");
		Customer customer2 = new Customer("Ayşe", "Sarı");
		cd.create(customer1);
		cd.create(customer2);
		
		
		AccountTypeDao atd = new AccountTypeDao();
		AccountType accountTypeTL = new AccountType("TL Account", "TL");
		AccountType accountTypeEUR = new AccountType("EURO Account", "EUR");
		AccountType accountTypeUSD = new AccountType("USD Account", "USD");
		atd.create(accountTypeTL);
		atd.create(accountTypeEUR);
		atd.create(accountTypeUSD);
		
		BranchDao bd = new BranchDao();
		Branch branch1 = new Branch("Zonguldak");
		Branch branch2 = new Branch("Bartın");
		Branch branch3 = new Branch("Karabük");
		bd.create(branch1);
		bd.create(branch2);
		bd.create(branch3);
		
		IntermediaryDao id = new IntermediaryDao();
		Intermediary int1 = new Intermediary("ATM");
		Intermediary int2 = new Intermediary("Internet");
		Intermediary int3 = new Intermediary("Branch");
		id.create(int1);
		id.create(int2);
		id.create(int3);
		
		TransactionTypeDao ttd = new TransactionTypeDao();
		TransactionType output = new TransactionType("Output");
		TransactionType input = new TransactionType("Input");
		ttd.create(output);
		ttd.create(input);
		
		TransactionOperationDao tod = new TransactionOperationDao();
		TransactionOperation withdraw = new TransactionOperation("Withdraw Money", output);
		TransactionOperation deposit = new TransactionOperation("Deposit Money", input);
		TransactionOperation paybill = new TransactionOperation("Bill Payment", output);
		tod.create(withdraw);
		tod.create(deposit);
		tod.create(paybill);
		
		AccountDao ad = new AccountDao();
		Account account1 = new Account(customer1, accountTypeTL, branch2);
		Account account2 = new Account(customer1, accountTypeEUR, branch1);
		Account account3 = new Account(customer2, accountTypeUSD, branch3);
		Account account4 = new Account(customer2, accountTypeTL, branch2);
		ad.create(account1);
		ad.create(account2);
		ad.create(account3);
		ad.create(account4);
		
		TransactionDao td = new TransactionDao();
		Transaction transaction1 = new Transaction(int1, deposit, account1, 400, Date.valueOf(LocalDate.of(2022, 2, 1)));
		Transaction transaction2 = new Transaction(int1, withdraw, account1, 200, Date.valueOf(LocalDate.of(2022, 1, 25)));
		Transaction transaction3 = new Transaction(int2, paybill, account1, 89, Date.valueOf(LocalDate.of(2022, 1, 20)));
		Transaction transaction4 = new Transaction(int3, deposit, account2, 200, Date.valueOf(LocalDate.of(2022, 1, 15)));
		Transaction transaction5 = new Transaction(int1, withdraw, account3, 100, Date.valueOf(LocalDate.of(2022, 2, 2)));
		Transaction transaction6 = new Transaction(int3, deposit, account4, 200, Date.valueOf(LocalDate.of(2022, 1, 20)));
		Transaction transaction7 = new Transaction(int2, paybill, account4, 115, Date.valueOf(LocalDate.of(2022, 1, 20)));
		td.create(transaction1);
		td.create(transaction2);
		td.create(transaction3);
		td.create(transaction4);
		td.create(transaction5);
		td.create(transaction6);
		td.create(transaction7);
	}

}
