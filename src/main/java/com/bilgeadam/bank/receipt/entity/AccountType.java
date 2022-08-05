package com.bilgeadam.bank.receipt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "account_types")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccountType
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long oid;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "money_type")
	private String moneyType;

	public AccountType(String accountType, String moneyType)
	{
		super();
		this.accountType = accountType;
		this.moneyType = moneyType;
	}
}
