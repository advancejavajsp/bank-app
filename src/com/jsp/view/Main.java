package com.jsp.view;

import java.util.List;
import java.util.Scanner;

import com.jsp.dao.CustomerDaoImplentation;
import com.jsp.dao.EmployeeDao;
import com.jsp.dao.EmployeeDaoImplementation;
import com.jsp.model.Customer;
import com.jsp.model.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeDao empDao=new EmployeeDaoImplementation();
		CustomerDao customerDao=new CustomerDaoImplentation();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome to bank");
		while(true) {
		System.out.println("1.Customer");
		System.out.println("2.Employee");
		System.out.println("select the choice");
		int choice=scanner.nextInt();
		switch(choice) {
		case 1:{
			//customer
			System.out.println("1.login");
			System.out.println("enter the choice");
			 switch(scanner.nextInt()) {
			 case 1:{//cus login
				 System.out.println("enter the email");
			 String username=scanner.next();
			 System.out.println("enter the password");
			 String password=scanner.next();
			 Customer customerlogin= customerDao.login( username, password);
			  if(customerlogin!=null) {//if cutomer
				System.out.println("1.deposit");
				System.out.println("2.withdraw");
				System.out.println("3.check balance");
				System.out.println("4.transfer");
				System.out.println("5.log out");
				switch(scanner.nextInt()) {//switch for user funtionalities
				case 1:{//switch for user funtionalities 1 deposit
					System.out.println("enter the account number ");
					long accNo=scanner.nextInt();
					System.out.println("enter the amount");
					double amount=scanner.nextDouble();
					boolean result=customerDao.deposit(accNo,amount);
					double balance=customerDao.checkBalance(accNo);
					System.out.println("available balance "+balance);
					}//switch for user funtionalities 1
				
				case 2:{//switch for user funtionalities 1 withdraw
					System.out.println("enter the account number ");
					long accNo=scanner.nextInt();
					System.out.println("enter the amount");
					double amount=scanner.nextDouble();
					System.out.println("enter the pin");
					int pin=scanner.nextInt();
					boolean result=customerDao.withdraw(accNo,amount,pin);
					if(!result) {
						System.out.println("invaliad pin");
					}
					double balance=customerDao.checkBalance(accNo);
					System.out.println("available balance "+balance);
				}//switch for user funtionalities 1
				case 3:{//switch for user funtionalities 3 checkbalance
					System.out.println("enter the account number ");
					long accNo=scanner.nextLong();
					double balance=customerDao.checkBalance(accNo);
					System.out.println("available balance "+balance);
				}//switch for user funtionalities 1
				case 4:{//switch for user funtionalities 1
					
				}//switch for user funtionalities 1
				case 5:{//switch for user funtionalities 1
					System.out.println("thank for using");
					break;
				}//switch for user funtionalities 1
				}//switch for user funtionalities
			 }//if close
			  else {
				  System.out.println("invalid credentials...");
			  }
			  
			break;
			
			 }//cus logout
			 }//switch of customer
			 break;
		}//customer
		
			//employee
		case 2:{
			
			System.out.println("1.Register");
			System.out.println("2.login");
			
			switch(scanner.nextInt()) {//emp log/register switch
			 case 1:{//register for employee
				Employee employee= Util.createEmployee(scanner,new Employee());
				       boolean result=  empDao.saveEmployee(employee);  
				       System.out.println(result);
			
			break;
			 }//register employee
			
			 case 2:{//login employee
				 System.out.println("enter the email");
				 String username=scanner.next();
				 System.out.println("enter the password");
				String  password=scanner.next();
				 Employee employeelogin= empDao.login( username, password);
				  if(employeelogin!=null) {
					  System.out.println("1.create customer");
					  System.out.println("2.update customer");
					  System.out.println("3.delete customer");
					  System.out.println("4.find customer");
					  System.out.println("5.find All customer");
					  System.out.println("6.find All Transcation");
					  System.out.println("6.logout");
					  System.out.println("enter the choice");
					  switch(scanner.nextInt()) {//employee functionalities
					  case 1:{//create cus
						  Customer customer= Util.createCustomer(scanner,new Customer());//return cutomer object
						 boolean result=  empDao.createCustomer(customer);
						 break;
					  } //create cus
					  case 2:{//update cus
						  System.out.println("enter the name");
							 String name=scanner.next();
							 System.out.println("enter the id of customer");
							 int id=scanner.nextInt();
						boolean result=  empDao.updateCustomerNameById( name,id);
						 break;
					  }//update cus
					  case 3:{//delete cus
						  System.out.println("enter the id of customer");
							 int id=scanner.nextInt();
						boolean result=  empDao.deleteCustomer(id);
						break;
					  }//delete cus
					  case 4:{//find cus
						  System.out.println("enter the id of customer");
						  long accNo=scanner.nextLong();
						  Customer customer=  empDao.findCustomerBy(accNo);
						  break;
					  }//find cus
					  case 5:{//find all cus
						  
						 List<Customer>  customers=  empDao.findCustomers();
						 System.out.println(customers);
						 break;
					  }//find all cus
					  case 6:{//logout
						  System.out.println("logout sucessfully");
						  break;
						 
					  }//logut
				  }//emp func
				  }//if
				  else {//else
					  System.out.println("invalid credentials");
				  }//else
				 break;
			 }//login
			
			
		}//emp register
		break;
		}//emp 
		default:
			System.out.println("Invalid choice!...");
		}//main switch close
		
			
		}//while
	}//main
}//class
