package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class SptypeDao extends SqlSessionDaoSupport{

	public List getSptypeList(Sptype record,int page,int rows) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SptypeMapper sptypeMapper = (SptypeMapper) app.getBean("sptypeMapper");
		List<Sptype> list = sptypeMapper.selectAll(record,page,rows);
		return list;
	}
	
	public Sptype getSptypeById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SptypeMapper sptypeMapper = (SptypeMapper) app.getBean("sptypeMapper");
		Sptype sptype = sptypeMapper.selectByPrimaryKey(id);
		
		return sptype;
	}

	public void update(Sptype sptype) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SptypeMapper sptypeMapper = (SptypeMapper) app.getBean("sptypeMapper");
		sptypeMapper.updateByPrimaryKey(sptype);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SptypeMapper sptypeMapper = (SptypeMapper) context.getBean("sptypeMapper");
		sptypeMapper.deleteByPrimaryKey(id);
	}

	public void add(Sptype sptype) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SptypeMapper sptypeMapper = (SptypeMapper) context.getBean("sptypeMapper");
		sptypeMapper.insert(sptype);
		
	}
}
