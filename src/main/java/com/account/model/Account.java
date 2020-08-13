package com.account.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * The Entity class for Account
 * @author ranjana
 *
 */
@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@Column(name = "id")
	@JsonIgnore
	private int id;

	@ApiModelProperty(notes="Account Number should contain atleast 5 characters")
	@Size(min=5, message="Account Number should contain atleast 5 characters")
	@Column(name = "account_id")
	private String accountid;

	@ApiModelProperty(notes="Account Name should contain atleast 5 characters")
	@Size(min=2, message="Account Name should contain atleast 5 characters")
	@Column(name = "account_name")
	private String accontName;
	
	@ApiModelProperty(notes="Account Type")
	@Column(name = "account_type")
	private String accontType;

	private enum ResponseStatusEnum {
		SUCCESS, ERROR, WARNING, NO_ACCESS
	};

	@ApiModelProperty(notes="Balance created dates")
	@Column(name = "balance_date")
	private LocalDate balanceDate;

	@ApiModelProperty(notes="Curency type")
	@Column(name = "currency")
	private String currency;

	@ApiModelProperty(notes="Open balance amount")
	@Column(name = "opening_balance")
	private BigDecimal openingBalance;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Account() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public LocalDate getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccontName() {
		return accontName;
	}

	public void setAccontName(String accontName) {
		this.accontName = accontName;
	}

}
