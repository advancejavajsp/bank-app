package com.jsp.dao;

import java.util.List;

import com.jsp.model.Customer;
import com.jsp.model.Employee;

public interface EmployeeDao {

	boolean saveEmployee(Employee employee);

	Employee login(String username, String password);

	boolean createCustomer(Customer customer);



	boolean updateCustomerNameById(String name, int id);

	boolean deleteCustomer(int id);

	Customer findCustomerBy(long accNo);

	List<Customer> findCustomers(); 
}
