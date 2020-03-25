package com.briup.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Customer;
import com.briup.demo.mapper.ex.CustomerExMapper;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.CustomerException;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerExMapper customerExMapper;

	@Override
	public boolean verifyCustomer(Customer customer) throws CustomerException {
		Customer customer2 = customerExMapper.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());
		if(customer2==null) {
			return false;
		}
		return true;
		/*
		方式1：通过jap中的方法获取所有用户信息
		List<Customer> list = customerExMapper.findAll();
		if(list.size()>0) {	//判断数据库是否有用户信息
			for (Customer c : list) {
					//判断用户名和用户密码的对应情况
				if(c.getUsername().equals(customer.getUsername())&&c.getPassword().equals(customer.getPassword())) {
					return true;
				}
			}
			return false;
		}
		return false;
		 */
		//方式2：自定义方法对直接传入的用户名和密码	进行登录判断
		
		
	}

	@Override
	public boolean saveCustomer(Customer customer) throws CustomerException {
		if(customerExMapper.findByUsername(customer.getUsername())==null) {
			//注册
			customerExMapper.save(customer);
			return true;
		}
		return false;
	}
	

}
