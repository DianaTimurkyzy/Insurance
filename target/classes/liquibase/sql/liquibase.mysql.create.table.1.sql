/* Create Tables */

CREATE TABLE bank
(
    `ID`                  INT          NOT NULL AUTO_INCREMENT,
    `REGISTRATION_NUMBER` VARCHAR(100) NOT NULL,
    `NAME`                VARCHAR(50)  NOT NULL,
    `FUNDS`               INT          NULL,
    `OPENING_DATE`        DATE         NOT NULL,
    `COUNTRY`             VARCHAR(100) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE owner
(
    `ID`                   INT          NOT NULL AUTO_INCREMENT,
    `FIRST_NAME`           VARCHAR(50)  NOT NULL,
    `LAST_NAME`            VARCHAR(50)  NOT NULL,
    `EMAIL`                VARCHAR(150) NULL,
    `SIN`                  INT          NOT NULL,
    `COUNTRY_TAX_RESIDENT` VARCHAR(50)  NOT NULL,
    `BANK_ID`              INT          NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (BANK_ID) REFERENCES bank (ID) ON DELETE CASCADE
);

CREATE TABLE insurance
(
    `ID`                  INT         NOT NULL AUTO_INCREMENT,
    `TYPE`                VARCHAR(50) NULL,
    `PRICE_PER_MONTH`     INT         NOT NULL,
    `COVERAGE_PERCENTAGE` INT         NULL,
    `BANK_ID`             INT         NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (BANK_ID) REFERENCES bank (ID) ON DELETE CASCADE
);

CREATE TABLE customer
(
    `ID`                  INT         NOT NULL AUTO_INCREMENT,
    `SIN`                 VARCHAR(12) NOT NULL,
    `IS_PAID`             TINYINT     NULL,
    `SIGNING_DATE`        DATE        NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE insurance_customer
(
    `INSURANCE_ID`        INT NOT NULL,
    `CUSTOMER_ID`         INT NOT NULL,
    FOREIGN KEY (INSURANCE_ID) REFERENCES insurance (ID) ON DELETE CASCADE,
    FOREIGN KEY (CUSTOMER_ID) REFERENCES customer (ID) ON DELETE CASCADE
);
