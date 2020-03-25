package com.briup.demo.service;

import com.briup.demo.bean.Customer;
import com.briup.demo.utils.CustomerException;

public interface ICustomerService {
	/**
	 * 	用户的登入验证	验证verify
	 */
	public boolean verifyCustomer(Customer customer) throws CustomerException;
	
	/**
	 * 	注册
	 */
	public boolean saveCustomer(Customer customer) throws CustomerException;
	
	
}
