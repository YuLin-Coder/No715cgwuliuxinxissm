package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class YxtypeDao extends SqlSessionDaoSupport{

	public List getYxtypeList(Yxtype record,int page,int rows) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YxtypeMapper yxtypeMapper = (YxtypeMapper) app.getBean("yxtypeMapper");
		List<Yxtype> list = yxtypeMapper.selectAll(record,page,rows);
		return list;
	}
	
	public Yxtype getYxtypeById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YxtypeMapper yxtypeMapper = (YxtypeMapper) app.getBean("yxtypeMapper");
		Yxtype yxtype = yxtypeMapper.selectByPrimaryKey(id);
		
		return yxtype;
	}

	public void update(Yxtype yxtype) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YxtypeMapper yxtypeMapper = (YxtypeMapper) app.getBean("yxtypeMapper");
		yxtypeMapper.updateByPrimaryKey(yxtype);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YxtypeMapper yxtypeMapper = (YxtypeMapper) context.getBean("yxtypeMapper");
		yxtypeMapper.deleteByPrimaryKey(id);
	}

	public void add(Yxtype yxtype) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YxtypeMapper yxtypeMapper = (YxtypeMapper) context.getBean("yxtypeMapper");
		yxtypeMapper.insert(yxtype);
		
	}
}
