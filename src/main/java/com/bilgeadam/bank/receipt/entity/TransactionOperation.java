package com.bilgeadam.bank.receipt.entity;

import jakarta.persistence.Column;
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
@Table(name = "transaction_operations")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class TransactionOperation
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long oid;
	
	@Column(name = "transaction_operation")
	private String transactionOperation;
	
	@OneToOne
	@JoinColumn(name = "transaction_type_oid", referencedColumnName = "oid")
	private TransactionType transactionType;

	public TransactionOperation(String transactionOperation, TransactionType transactionType)
	{
		super();
		this.transactionOperation = transactionOperation;
		this.transactionType = transactionType;
	}
}
