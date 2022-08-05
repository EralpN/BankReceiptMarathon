package com.bilgeadam.bank.receipt.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Transaction
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long oid;
	
	@OneToOne
	@JoinColumn(name = "intermediary_oid", referencedColumnName = "oid")
	private Intermediary intermediary;
	
	@OneToOne
	@JoinColumn(name = "transaction_operation_oid", referencedColumnName = "oid")
	private TransactionOperation transactionOperation;
	
	@OneToOne
	@JoinColumn(name = "account_oid", referencedColumnName = "oid")
	private Account account;
	
	@Column(name = "transaction_amount")
	private double transactionAmount;
	
	@Column(name = "transaction_date")
	@Temporal(TemporalType.DATE)
	private Date transactionDate;

	public Transaction(Intermediary intermediary, TransactionOperation transactionOperation, Account account,
			double transactionAmount, Date transactionDate)
	{
		super();
		this.intermediary = intermediary;
		this.transactionOperation = transactionOperation;
		this.account = account;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}
}
