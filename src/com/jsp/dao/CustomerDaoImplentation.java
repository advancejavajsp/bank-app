package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.model.Customer;
import com.jsp.view.CustomerDao;

public class CustomerDaoImplentation implements CustomerDao {
	Connection connection = DBConfig.createConnection();

	@Override
	public Customer login(String username, String password) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from customer where email=? and password=?");

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					return new Customer();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deposit(long accNo, double amount) {
		try {
			boolean isAccountPresent = checkAccountNumber(accNo);
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into transaction(deposit,time) values(?,?)");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	private boolean checkAccountNumber(long accNo) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean withdraw(long accNo, double amount, int pin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double checkBalance(long accNo) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select balance from customer where accountnumber=?");

			preparedStatement.setLong(1, accNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					return resultSet.getDouble(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
