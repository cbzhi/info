package com.cbz.info.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbz.info.dao.BaseDao;
import com.cbz.info.service.BaseService;


@Service
public class BaseServiceImpl implements BaseService{

	@Resource
	protected BaseDao baseDao ;
	
}
