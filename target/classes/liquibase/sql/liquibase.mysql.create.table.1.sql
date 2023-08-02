/* Create Tables */

CREATE TABLE bank_account
(
    `ID`             INT NOT NULL AUTO_INCREMENT,
    `ACCOUNT_NUMBER` INT NULL,
    `NAME`           VARCHAR(50) NULL,
    `FUNDS`          INT NULL,
    `OPENING_DATE`   DATE NULL,
    `COUNTRY`        VARCHAR(100) NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE owners
(
    `ID`                   INT NOT NULL AUTO_INCREMENT,
    `FIRST_NAME`           VARCHAR(50) NULL,
    `LAST_NAME`            VARCHAR(50) NULL,
    `EMAIL`                VARCHAR(50) NULL,
    `SIN`                  VARCHAR(10) NULL,
    `COUNTRY_TAX_RESIDENT` VARCHAR(100) NULL,
    `BANK_ID`              INT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (BANK_ID) REFERENCES bank_account (ID)
);

CREATE TABLE insurance
(
    `ID`                  INT NOT NULL AUTO_INCREMENT,
    `TYPE`                VARCHAR(50) NULL,
    `PRICE_PER_MONTH`     INT NULL,
    `COVERAGE_PERCENTAGE` INT NULL,
    `BANK_ID`             INT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (BANK_ID) REFERENCES bank_account (ID)
);

CREATE TABLE customer
(
    `ID`           INT         NOT NULL AUTO_INCREMENT,
    `SIN`          VARCHAR(10) NOT NULL,
    `IS_PAID`      TINYINT(1) NULL,
    `SIGNING_DATE` DATE        NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE insurance_customer
(
    `INSURANCE_ID` INT NOT NULL,
    `CUSTOMER_ID`  INT NOT NULL,
    FOREIGN KEY (INSURANCE_ID) REFERENCES insurance (ID),
    FOREIGN KEY (CUSTOMER_ID) REFERENCES customer (ID)
);
