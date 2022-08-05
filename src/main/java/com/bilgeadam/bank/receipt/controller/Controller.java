package com.bilgeadam.bank.receipt.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bilgeadam.bank.receipt.dao.CustomerDao;
import com.bilgeadam.bank.receipt.dao.TransactionDao;
import com.bilgeadam.bank.receipt.entity.Customer;
import com.bilgeadam.bank.receipt.entity.Transaction;

public class Controller
{
	private Scanner sc = new Scanner(System.in);
	private CustomerDao customerDao = new CustomerDao();
	private TransactionDao transactionDao = new TransactionDao();
	
	
	public static void initiateBankReceiptApp()
	{
		while(true)
		{
			Controller cont = new Controller();
			cont.showReceipt(cont.chooseCustomer());
		}
	}
	
	private Customer chooseCustomer()
	{
		ArrayList<Customer> customers = customerDao.listAll();
		for (Customer customer : customers)
		{
			System.out.println("ID: " + customer.getOid() + " " + customer.getFirstName() + " " + customer.getLastName());
		}
		System.out.println("\n\nChoose ID of the customer (0 to exit).");
		int selection = sc.nextInt();
		
		if (selection == 0)
		{
			System.out.println("Bye bye.");
			System.exit(0);
		}
		
		return customerDao.find(selection);
	}
	
	private void showReceipt(Customer customer)
	{
		ArrayList<Transaction> transactions = userTransactions(customer);
		showTlReceipt(transactions);
		showEurReceipt(transactions);
		showUsdReceipt(transactions);
	}
	
	private ArrayList<Transaction> userTransactions(Customer customer)
	{
		return (ArrayList<Transaction>) transactionDao.listAll().stream()
				.filter(t -> t.getAccount().getCustomer().getOid() == customer.getOid()).collect(Collectors.toList());
	}
	

	private void showTlReceipt(ArrayList<Transaction> transactions)
	{
		ArrayList<Transaction> tlTransactions = (ArrayList<Transaction>) transactions.stream()
				.filter(tra -> tra.getAccount().getAccountType().getMoneyType().equals("TL")).collect(Collectors.toList());
		
		System.out.println("\nTL Transactions:");
		for (Transaction transaction : tlTransactions)
		{
			System.out.println("No:" + transaction.getOid() + " " + transaction.getTransactionOperation().getTransactionOperation() + " " 
		+ transaction.getTransactionAmount() + transaction.getAccount().getAccountType().getMoneyType() + " via " + transaction.getIntermediary().getIntermediaryName() + " on " + transaction.getTransactionDate().toString());
		}
		
		if (tlTransactions == null)
		{
			System.out.println("No TL transactions.");
		}
	}
	private void showEurReceipt(ArrayList<Transaction> transactions)
	{
		ArrayList<Transaction> eurTransactions = (ArrayList<Transaction>) transactions.stream()
				.filter(tra -> tra.getAccount().getAccountType().getMoneyType().equals("EUR")).collect(Collectors.toList());
		
		System.out.println("\nEURO Transactions:");
		for (Transaction transaction : eurTransactions)
		{
			System.out.println("No:" + transaction.getOid() + " " + transaction.getTransactionOperation().getTransactionOperation() + " " 
		+ transaction.getTransactionAmount() + transaction.getAccount().getAccountType().getMoneyType() + " via " + transaction.getIntermediary().getIntermediaryName() + " on " + transaction.getTransactionDate().toString());
		}
		
		if (eurTransactions == null)
		{
			System.out.println("No EUR transactions.");
		}
	}
	private void showUsdReceipt(ArrayList<Transaction> transactions)
	{
		ArrayList<Transaction> usdTransactions = (ArrayList<Transaction>) transactions.stream()
				.filter(tra -> tra.getAccount().getAccountType().getMoneyType().equals("USD")).collect(Collectors.toList());
		
		System.out.println("\nUSD Transactions:");
		for (Transaction transaction : usdTransactions)
		{
			System.out.println("No:" + transaction.getOid() + " " + transaction.getTransactionOperation().getTransactionOperation() + " " 
		+ transaction.getTransactionAmount() + transaction.getAccount().getAccountType().getMoneyType() + " via " + transaction.getIntermediary().getIntermediaryName() + " on " + transaction.getTransactionDate().toString());
		}
		
		if (usdTransactions == null)
		{
			System.out.println("No USD transactions.");
		}
	}


}
