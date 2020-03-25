package com.briup.demo.service;

import java.util.List;

import javax.swing.undo.CannotUndoException;

import com.briup.demo.bean.Article;
import com.briup.demo.utils.CustomerException;

public interface IArticleService {
	/**
	 * 新增/修改文章
	 */
	public void saveOrUpdateArticle(Article article ) throws CustomerException;
	
	/**
	 * 删除文章
	 */
	public void deleteArticleById(int id) throws CannotUndoException;
	
	/**
	 * 根据条件查询文章
	 */
	public List<Article> findArticleByCondition(String keyStr,String condition) throws CustomerException;
	
	/**
	 * 根据id查询文章
	 */
	public Article findArticleById(int id) throws CannotUndoException;
	
	
}

























