package com.bilgeadam.bank.receipt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Account
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long oid;
	
	@OneToOne
	@JoinColumn(name = "customer_oid", referencedColumnName = "oid")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "account_type_oid", referencedColumnName = "oid")
	private AccountType accountType;
	
	@OneToOne
	@JoinColumn(name = "branch_oid", referencedColumnName = "oid")
	private Branch branch;

	public Account(Customer customer, AccountType accountType, Branch branch)
	{
		super();
		this.customer = customer;
		this.accountType = accountType;
		this.branch = branch;
	}
}
