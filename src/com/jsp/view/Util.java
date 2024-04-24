package com.jsp.view;

import java.util.Scanner;

import com.jsp.model.Customer;
import com.jsp.model.Employee;

public class Util {

	public static Customer createCustomer(Scanner scanner, Customer customer) {
		scanner.nextLine();
		System.out.println("enter the name");
		customer.setName(scanner.nextLine());
		System.out.println("enter the email");
		customer.setEmail(scanner.next());
		System.out.println("enter the password");
		customer.setPassword(scanner.next());
		System.out.println("enter the account number");
		customer.setAccountNumber(scanner.nextLong());
		System.out.println("enter the address");
		scanner.nextLine();
		customer.setAddress(scanner.nextLine());
		System.out.println("enter IFSC");
		customer.setIFSC(scanner.next());
		System.out.println("enter the pin");
		customer.setPin(scanner.nextInt());
		return customer;
	}
	public static Employee createEmployee(Scanner scanner,Employee employee) {
		scanner.nextLine();
		System.out.println("enter the name");
		employee.setName(scanner.nextLine());
		System.out.println("enter the email");
		employee.setEmail(scanner.next());
		System.out.println("enter the password");
		employee.setPassword(scanner.next());
		return employee;
	}

}
