package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class UxtypeDao extends SqlSessionDaoSupport{

	public List getUxtypeList(Uxtype record,int page,int rows) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UxtypeMapper uxtypeMapper = (UxtypeMapper) app.getBean("uxtypeMapper");
		List<Uxtype> list = uxtypeMapper.selectAll(record,page,rows);
		return list;
	}
	
	public Uxtype getUxtypeById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UxtypeMapper uxtypeMapper = (UxtypeMapper) app.getBean("uxtypeMapper");
		Uxtype uxtype = uxtypeMapper.selectByPrimaryKey(id);
		
		return uxtype;
	}

	public void update(Uxtype uxtype) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UxtypeMapper uxtypeMapper = (UxtypeMapper) app.getBean("uxtypeMapper");
		uxtypeMapper.updateByPrimaryKey(uxtype);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UxtypeMapper uxtypeMapper = (UxtypeMapper) context.getBean("uxtypeMapper");
		uxtypeMapper.deleteByPrimaryKey(id);
	}

	public void add(Uxtype uxtype) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UxtypeMapper uxtypeMapper = (UxtypeMapper) context.getBean("uxtypeMapper");
		uxtypeMapper.insert(uxtype);
		
	}
}
