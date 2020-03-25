package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 	与栏目相关的	web层
 * @author 用户名
 *
 */
@RestController
@Api(description = "栏目相关接口")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@PostMapping("/saveCategory")
	@ApiOperation("新增栏目")	
	public Message<String> saveCategory(Category category) {
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "新增出错"+e.getMessage());
		}
	}
	@PostMapping("/updateCategoryById")
	@ApiOperation("修改栏目")	
	public Message<String> updateCategoryById(Category category) {
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "新增出错"+e.getMessage());
		}
	}
	
	@PostMapping("/delectCategoryById")
	@ApiOperation("根据删除栏目")	
	public Message<String> delectCategoryById(int id) {
		categoryService.deleteCategoryById(id);
		return MessageUtil.success();
	}
	
	@PostMapping("/selectAllCategory")
	@ApiOperation("查询所有栏目")	
	public Message<List<Category>> selectAllCategory() {
		List<Category> list = categoryService.findAllCategorys();
		return MessageUtil.success(list);
	}
	
	@PostMapping("/selectCategoryById")
	@ApiOperation("查询一个栏目信息")	
	public Message<Category> selectCategoryById(int id) {
		Category categoryById = categoryService.findCategoryById(id);
		return MessageUtil.success(categoryById);
	}
	
	@GetMapping("/findCategoryExById")
	@ApiOperation("根据id查询栏目信息及其文章信息")	
	public Message<CategoryEx> findCategoryExById(int id) {
		return MessageUtil.success(categoryService.findCategoryExById(id));
	}
	
	
	
}
