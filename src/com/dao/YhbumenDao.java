package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class YhbumenDao extends SqlSessionDaoSupport{

	public List getYhbumenList(Yhbumen record,int page,int rows) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YhbumenMapper yhbumenMapper = (YhbumenMapper) app.getBean("yhbumenMapper");
		List<Yhbumen> list = yhbumenMapper.selectAll(record,page,rows);
		return list;
	}
	
	public Yhbumen getYhbumenById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YhbumenMapper yhbumenMapper = (YhbumenMapper) app.getBean("yhbumenMapper");
		Yhbumen yhbumen = yhbumenMapper.selectByPrimaryKey(id);
		
		return yhbumen;
	}

	public void update(Yhbumen yhbumen) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YhbumenMapper yhbumenMapper = (YhbumenMapper) app.getBean("yhbumenMapper");
		yhbumenMapper.updateByPrimaryKey(yhbumen);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YhbumenMapper yhbumenMapper = (YhbumenMapper) context.getBean("yhbumenMapper");
		yhbumenMapper.deleteByPrimaryKey(id);
	}

	public void add(Yhbumen yhbumen) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YhbumenMapper yhbumenMapper = (YhbumenMapper) context.getBean("yhbumenMapper");
		yhbumenMapper.insert(yhbumen);
		
	}
}
