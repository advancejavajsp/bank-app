package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
			if (isAccountPresent) {
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into transaction(deposit,time) values(?,?)");
				preparedStatement.setDouble(1, amount);
				preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
				int update = preparedStatement.executeUpdate();
				if (update > 0) {
					double balance = 0;
					PreparedStatement preparedStatement2 = connection
							.prepareStatement("update customer set balance=? where accountnumber=?");
					PreparedStatement preparedStatement3 = connection
							.prepareStatement("select balance from customer where accountnumber=?");

					preparedStatement3.setLong(1, accNo);
					ResultSet resultSet = preparedStatement3.executeQuery();
					
					if (resultSet != null) {
						while (resultSet.next()) {
							balance = resultSet.getDouble(1);
						}
						preparedStatement2.setDouble(1, amount+balance);
						preparedStatement2.setLong(2, accNo);
						preparedStatement2.executeUpdate();
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	private boolean checkAccountNumber(long accNo) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from customer where accountnumber=?");
			preparedStatement.setLong(1, accNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return true;
			}

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
