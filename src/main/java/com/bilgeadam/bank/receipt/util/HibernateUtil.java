package com.bilgeadam.bank.receipt.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.bank.receipt.entity.Account;
import com.bilgeadam.bank.receipt.entity.AccountType;
import com.bilgeadam.bank.receipt.entity.Branch;
import com.bilgeadam.bank.receipt.entity.Customer;
import com.bilgeadam.bank.receipt.entity.Intermediary;
import com.bilgeadam.bank.receipt.entity.Transaction;
import com.bilgeadam.bank.receipt.entity.TransactionOperation;
import com.bilgeadam.bank.receipt.entity.TransactionType;

public class HibernateUtil
{
	private static final SessionFactory sessionFactory = sessionFactory();
	
	private static SessionFactory sessionFactory()
	{
		SessionFactory factory = null;
		try
		{
			Configuration configuration = new Configuration();
			
			// Register your classes here!
			configuration.addAnnotatedClass(Account.class);
			configuration.addAnnotatedClass(AccountType.class);
			configuration.addAnnotatedClass(Branch.class);
			configuration.addAnnotatedClass(Customer.class);
			configuration.addAnnotatedClass(Intermediary.class);
			configuration.addAnnotatedClass(Transaction.class);
			configuration.addAnnotatedClass(TransactionOperation.class);
			configuration.addAnnotatedClass(TransactionType.class);
			
			factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();			
			System.out.println("Success!");
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return factory;
	}

	public static SessionFactory getSessionfactory()
	{
		return sessionFactory;
	}
}
