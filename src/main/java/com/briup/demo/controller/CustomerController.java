package com.briup.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Customer;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "用户登录界面")
public class CustomerController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@PostMapping("/loginCustomer")
	@ApiOperation("用户登录")	
	public Message<String> loginCustomer(Customer customer){
		if(iCustomerService.verifyCustomer(customer)) {
			//根据返回的true，可知用户名和密码正确，即登陆成功
			return MessageUtil.success("登录成功");
		}
		return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "密码或用户名错误");
	}
	
	@PostMapping("/registerCustomer")
	@ApiOperation("用户注册")	
	public Message<String> registerCustomer(Customer customer){
		if(iCustomerService.saveCustomer(customer)) {
			//根据返回的true，可知用户名和密码正确，即登陆成功
			return MessageUtil.success("注册成功");
		}
		return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "注册失败");
	}
	
//	@PostMapping("/changeCustomer")
//	@ApiOperation("用户注册")	
//	public Message<String> changeCustomer(Customer customer){
//		if(iCustomerService.saveCustomer(customer)) {
//			//根据返回的true，可知用户名和密码正确，即登陆成功
//			return MessageUtil.success("注册成功");
//		}
//		return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "注册失败");
//	}
}
