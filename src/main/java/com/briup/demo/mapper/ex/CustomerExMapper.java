package com.briup.demo.mapper.ex;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.demo.bean.Customer;

public interface CustomerExMapper extends JpaRepository<Customer, Integer>{
	/**
	 * springdate-jpa的使用
	 * @param example
	 * @return
	 */
	Customer findByUsernameAndPassword(String username,String password);
	
	Customer findByUsername(String username);
}
	
	
//	@Query("select c from Customer c where c.username = ?1 and c.password = ?2")
//	Customer findByUsernameAndPassword(String username,String password);
//	
//	@Query(value = "select c from cms_customer c where c.username = ?1 and c.password = ?2",nativeQuery = true)
//	Customer findt(String username,String password);

