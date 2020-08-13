
CREATE TABLE users (
    id            bigint auto_increment,
    user_name    NVARCHAR(20) NOT NULL,
    password    NVARCHAR(20) NOT NULL,
    primary key(id)
  
);
CREATE TABLE accounts (
	id           bigint auto_increment, 
    account_id     NVARCHAR(20) NOT NULL,
    account_name    NVARCHAR(20) NOT NULL,
    account_type    NVARCHAR(20) NOT NULL,
    balance_date    DATETIME,
    currency    NVARCHAR(20) NOT NULL,
    opening_balance     DECIMAL(19,4) NULL DEFAULT '0.0000',
    user_id int unsigned NOT NULL,
    
    CONSTRAINT id PRIMARY KEY(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE transactions (

	id           bigint auto_increment, 
	value_date DATETIME, 
    debit_amount      DECIMAL(19,4) NULL DEFAULT '0.0000',
    opening_balance     DECIMAL(19,4) NULL DEFAULT '0.0000',
    credit_amount     DECIMAL(19,4) NULL DEFAULT '0.0000',
    tranaction_type     NVARCHAR(20) NOT NULL,
    transaction_narrative NVARCHAR(20),
    account_id int unsigned NOT NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);


	

