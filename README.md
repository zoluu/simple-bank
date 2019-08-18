# Simple-Bank-Application

A simple application that handles new customer bank account requests.

## Introduction

The application does the following:
- Reads a .csv file with data in the following order:
  - Name
  - National insurance number
  - Account type
  - Initial deposit
- The savings and current account share the following properties:
  - Deposit
  - Withdraw
  - Transfer
  - ShowInfo
- Creates an 11-digit account number that is created by the process of appending:
  - Prefix of 1 or 2 depending on whether it is a savings or current account
  - The third-last and second-last digits of the NI number
  - A unique 5-digit number
  - Random 3-digit number
  
## BankAccountApp.java
This is the main class for this application and reads the .csv file to create new accounts based on the data.

## Account.java
This is the parent class for **Savings.java** and **Current.java**.
The account number that comes after the prefix of 1 or 2 is set in this class.
The accrued interest is calculated here and the account balance is updated here.

## Savings.java
This is a child class of **Account.java**. 
Savings account holders are given a Safety Deposit Box which:
  - Are identified by a 3-digit number
  - Can be accessed with a 4-digit code

## Current.java
This is also a child class of **Account.java**.
Current accounts holders are assigned a debit card with:
  - A 12-digit card number
  - A 4-digit PIN

## IBaseRate.java
Both the savings and current accounts use an interface that determines the base interest rate:
  - Savings accounts will use 0.25 less than the base rate
  - Checking accounts will use 15% of the base rate
  
