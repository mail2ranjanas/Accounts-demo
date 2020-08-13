package com.account.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * POJO class for Transactions
 * @author ranjana
 *
 */
@Data
@Entity
@Table(name = "transactions")
public class Transactions {

	@Id
	@JsonIgnore
	@Column(name = "id")
	private int id;
	
	@ApiModelProperty(notes="Value Date")
	@Column(name = "value_date")
	private LocalDate valueDate; 
	
	@ApiModelProperty(notes="Debit Amount")
	@Column(name = "debit_amount")
	private BigDecimal debitAmount;
	
	@ApiModelProperty(notes="Opening balance - shoule be positive number")
	@Column(name = "opening_balance")
	private BigDecimal openingBalance;
	
	@ApiModelProperty(notes="Credit Amount - shoulbe be positive number")
	@Column(name = "credit_amount")
	private BigDecimal creditAmount;
	
	@Column(name = "tranaction_type")
	private String tranactionType;
	
	@Column(name = "transaction_narrative")
	private String transactionNarrative;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	
}
