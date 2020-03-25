package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.IndexResult;
import com.briup.demo.service.IIndexResultService;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController	//结果以json格式返回
@Api(description = "首页需要的所有数据")
public class IndexResultcontroller {
	
	@Autowired
	private IIndexResultService indexResultService;
	
	@GetMapping("/getIndexResult")
	@ApiOperation("首页展示的所有数据")
	public Message<IndexResult> getIndexResult(){
		return MessageUtil.success(indexResultService.findIndexAllResult());
	}
	
	@GetMapping("/getCategory")
	@ApiOperation("首页展示所有栏目")
	public Message<List<Category>> getCategory(){
		return null;
	}
	
	
	
}
