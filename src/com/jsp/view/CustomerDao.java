package com.jsp.view;


import com.jsp.model.Customer;

public interface CustomerDao {

	Customer login(String username, String password);

	boolean deposit(long accNo, double amount);

	boolean withdraw(long accNo, double amount, int pin);

	double checkBalance(long accNo);


}
