package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class UtaolunDao extends SqlSessionDaoSupport{

	public List getUtaolunList(Utaolun record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UtaolunMapper utaolunMapper = (UtaolunMapper) app.getBean("utaolunMapper");
		List<Utaolun> list = utaolunMapper.selectAll(record,page,rows,sdate,edate);
		return list;
	}
	
	public Utaolun getUtaolunById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UtaolunMapper utaolunMapper = (UtaolunMapper) app.getBean("utaolunMapper");
		Utaolun utaolun = utaolunMapper.selectByPrimaryKey(id);
		
		return utaolun;
	}

	public void update(Utaolun utaolun) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UtaolunMapper utaolunMapper = (UtaolunMapper) app.getBean("utaolunMapper");
		utaolunMapper.updateByPrimaryKey(utaolun);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UtaolunMapper utaolunMapper = (UtaolunMapper) context.getBean("utaolunMapper");
		utaolunMapper.deleteByPrimaryKey(id);
	}

	public void add(Utaolun utaolun) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UtaolunMapper utaolunMapper = (UtaolunMapper) context.getBean("utaolunMapper");
		utaolunMapper.insert(utaolun);
		
	}
}
