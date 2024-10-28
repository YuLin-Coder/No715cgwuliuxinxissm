package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class SpcangkuDao extends SqlSessionDaoSupport{

	public List getSpcangkuList(Spcangku record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpcangkuMapper spcangkuMapper = (SpcangkuMapper) app.getBean("spcangkuMapper");
		List<Spcangku> list = spcangkuMapper.selectAll(record,page,rows,sdate, edate);
		return list;
	}
	
	public Spcangku getSpcangkuById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpcangkuMapper spcangkuMapper = (SpcangkuMapper) app.getBean("spcangkuMapper");
		Spcangku spcangku = spcangkuMapper.selectByPrimaryKey(id);
		
		return spcangku;
	}

	public void update(Spcangku spcangku) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpcangkuMapper spcangkuMapper = (SpcangkuMapper) app.getBean("spcangkuMapper");
		spcangkuMapper.updateByPrimaryKey(spcangku);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpcangkuMapper spcangkuMapper = (SpcangkuMapper) context.getBean("spcangkuMapper");
		spcangkuMapper.deleteByPrimaryKey(id);
	}

	public void add(Spcangku spcangku) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpcangkuMapper spcangkuMapper = (SpcangkuMapper) context.getBean("spcangkuMapper");
		spcangkuMapper.insert(spcangku);
		
	}
}
