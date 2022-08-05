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
@Table(name = "branches")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Branch
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long oid;
	
	@Column(name = "city_name")
	private String cityName;

	public Branch(String cityName)
	{
		super();
		this.cityName = cityName;
	}
}
