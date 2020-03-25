package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Link;
import com.briup.demo.utils.CustomerException;

/**
 * 关于链接的service
 * 关于链接的相关操作
 * @author 用户名
 *
 */
public interface ILinkService {
	/**
	 * 保存或修改链接信息
	 * @param link
	 */
	void saveOrUpdateLink(Link link)throws CustomerException;
	
	/**
	 * 查询所有链接
	 */
	List<Link> findAllLinks() throws CustomerException;
	
	
	/**
	 * 删除链接(通过id)
	 */
	void deleteLinkById(int id) throws CustomerException;
	/**
	 * 查询链接（模糊查询，根据链接名）
	 */
	List<Link> findLinksByName(String name) throws CustomerException;
	
}
