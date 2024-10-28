package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class ShangpinDao extends SqlSessionDaoSupport{

	public List getShangpinList(Shangpin record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		ShangpinMapper shangpinMapper = (ShangpinMapper) app.getBean("shangpinMapper");
		List<Shangpin> list = shangpinMapper.selectAll(record,page,rows,sdate,edate);
		return list;
	}
	
	public Shangpin getShangpinById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		ShangpinMapper shangpinMapper = (ShangpinMapper) app.getBean("shangpinMapper");
		Shangpin shangpin = shangpinMapper.selectByPrimaryKey(id);
		
		return shangpin;
	}

	public void update(Shangpin shangpin) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		ShangpinMapper shangpinMapper = (ShangpinMapper) app.getBean("shangpinMapper");
		shangpinMapper.updateByPrimaryKey(shangpin);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		ShangpinMapper shangpinMapper = (ShangpinMapper) context.getBean("shangpinMapper");
		shangpinMapper.deleteByPrimaryKey(id);
	}

	public void add(Shangpin shangpin) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		ShangpinMapper shangpinMapper = (ShangpinMapper) context.getBean("shangpinMapper");
		shangpinMapper.insert(shangpin);
		
	}
}
