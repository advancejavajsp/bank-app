package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jsp.model.Customer;
import com.jsp.model.Employee;

public class EmployeeDaoImplementation implements EmployeeDao {
	Connection connection = DBConfig.createConnection();

	@Override
	public boolean saveEmployee(Employee employee) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into employee(name,email,password) values(?,?,?)");

			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getPassword());
			int update = preparedStatement.executeUpdate();

			if (update > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Employee login(String username, String password) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from employee where email=? and password=?");

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					return new Employee();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean createCustomer(Customer customer) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into customer(name,email,password,balance,accountnumber,address,ifsc,pin) values(?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getEmail());
			preparedStatement.setString(3, customer.getPassword());
			preparedStatement.setDouble(4, customer.getBalance());
			preparedStatement.setLong(5, customer.getAccountNumber());
			preparedStatement.setString(6, customer.getAddress());
			preparedStatement.setString(7, customer.getIFSC());
			preparedStatement.setInt(8, customer.getPin());
			int update = preparedStatement.executeUpdate();

			if (update > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateCustomerNameById(String name, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findCustomerBy(long accNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
