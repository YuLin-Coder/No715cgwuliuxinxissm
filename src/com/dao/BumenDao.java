package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class BumenDao extends SqlSessionDaoSupport{

	public List getBumenList(Bumen record,int page,int rows) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		BumenMapper bumenMapper = (BumenMapper) app.getBean("bumenMapper");
		List<Bumen> list = bumenMapper.selectAll(record,page,rows);
		return list;
	}
	
	public Bumen getBumenById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		BumenMapper bumenMapper = (BumenMapper) app.getBean("bumenMapper");
		Bumen bumen = bumenMapper.selectByPrimaryKey(id);
		
		return bumen;
	}

	public void update(Bumen bumen) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		BumenMapper bumenMapper = (BumenMapper) app.getBean("bumenMapper");
		bumenMapper.updateByPrimaryKey(bumen);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		BumenMapper bumenMapper = (BumenMapper) context.getBean("bumenMapper");
		bumenMapper.deleteByPrimaryKey(id);
	}

	public void add(Bumen bumen) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		BumenMapper bumenMapper = (BumenMapper) context.getBean("bumenMapper");
		bumenMapper.insert(bumen);
		
	}
}
