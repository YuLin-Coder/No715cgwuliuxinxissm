package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class SpjinDao extends SqlSessionDaoSupport{

	public List getSpjinList(Spjin record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpjinMapper spjinMapper = (SpjinMapper) app.getBean("spjinMapper");
		List<Spjin> list = spjinMapper.selectAll(record,page,rows,sdate,edate);
		return list;
	}
	
	public Spjin getSpjinById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpjinMapper spjinMapper = (SpjinMapper) app.getBean("spjinMapper");
		Spjin spjin = spjinMapper.selectByPrimaryKey(id);
		
		return spjin;
	}

	public void update(Spjin spjin) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpjinMapper spjinMapper = (SpjinMapper) app.getBean("spjinMapper");
		spjinMapper.updateByPrimaryKey(spjin);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpjinMapper spjinMapper = (SpjinMapper) context.getBean("spjinMapper");
		spjinMapper.deleteByPrimaryKey(id);
	}

	public void add(Spjin spjin) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpjinMapper spjinMapper = (SpjinMapper) context.getBean("spjinMapper");
		spjinMapper.insert(spjin);
		
	}
}
