package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class YhroleDao extends SqlSessionDaoSupport{

	public List getYhroleList(Yhrole record,int page,int rows) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YhroleMapper yhroleMapper = (YhroleMapper) app.getBean("yhroleMapper");
		List<Yhrole> list = yhroleMapper.selectAll(record,page,rows);
		return list;
	}
	
	public Yhrole getYhroleById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YhroleMapper yhroleMapper = (YhroleMapper) app.getBean("yhroleMapper");
		Yhrole yhrole = yhroleMapper.selectByPrimaryKey(id);
		
		return yhrole;
	}

	public void update(Yhrole yhrole) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YhroleMapper yhroleMapper = (YhroleMapper) app.getBean("yhroleMapper");
		yhroleMapper.updateByPrimaryKey(yhrole);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YhroleMapper yhroleMapper = (YhroleMapper) context.getBean("yhroleMapper");
		yhroleMapper.deleteByPrimaryKey(id);
	}

	public void add(Yhrole yhrole) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YhroleMapper yhroleMapper = (YhroleMapper) context.getBean("yhroleMapper");
		yhroleMapper.insert(yhrole);
		
	}
}
