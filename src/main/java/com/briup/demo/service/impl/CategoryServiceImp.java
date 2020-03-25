package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.ArticleExample.Criteria;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.mapper.ex.CategoryExMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;
/**
 * 	处理栏目的实现类
 * @author 用户名
 *
 */
@Service
public class CategoryServiceImp implements ICategoryService {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private CategoryMapper categorymapper;

	@Autowired
	private CategoryExMapper categoryExMapper;
	
	@Override	
	public List<Category> findAllCategorys() throws CustomerException {
		CategoryExample example = new CategoryExample();
		List<Category> list = categorymapper.selectByExample(example);
		return list;
//		return categorymapper.selectByExample(new CategoryExample());
	}

	@Override
	public void saveOrUpdateCategory(Category category) throws CustomerException {
		if(category == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}else {
			CategoryExample example = new CategoryExample();
			example.createCriteria().andCodeEqualTo(category.getCode()).andNameEqualTo(category.getName());
			List<Category> list = categorymapper.selectByExample(example);
			if(category.getId() == null) {
				if(list.size()==0) {
					categorymapper.insert(category);
				}else {
					throw new CustomerException(StatusCodeUtil.ERROR_CODE, "栏目已存在");
				}
			}else {
				if(list.size()==0) {
					categorymapper.updateByPrimaryKey(category);
				}else {
					throw new CustomerException(StatusCodeUtil.ERROR_CODE, "栏目已存在");
				}
			}
		}
	}

	@Override
	public void deleteCategoryById(int id) throws CustomerException {
		//删除栏目时	同时要删除与之相关的信息
		ArticleExample example = new ArticleExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(id);
		articleMapper.deleteByExample(example);
		
		categorymapper.deleteByPrimaryKey(id);
	}

	@Override
	public Category findCategoryById(int id) throws CustomerException {
		if("".equals(String.valueOf(id))) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}else {
			Category category = categorymapper.selectByPrimaryKey(id);
			if(category == null) {
				throw new CustomerException(StatusCodeUtil.NOFOUND_CODE, "没有查询到对应数据");
			}else {
				return category;
			}
		}
	}

	@Override
	public List<CategoryEx> findAllCategoryEx() throws CustomerException {
		return categoryExMapper.findAllCategoryExs();
	}

	@Override
	public CategoryEx findCategoryExById(int id) throws CustomerException {
		return categoryExMapper.findCategoryExById(id);
	}

}
