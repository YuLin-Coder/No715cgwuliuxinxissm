package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class SpchuDao extends SqlSessionDaoSupport{

	public List getSpchuList(Spchu record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpchuMapper spchuMapper = (SpchuMapper) app.getBean("spchuMapper");
		List<Spchu> list = spchuMapper.selectAll(record,page,rows,sdate,edate);
		return list;
	}
	
	public Spchu getSpchuById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpchuMapper spchuMapper = (SpchuMapper) app.getBean("spchuMapper");
		Spchu spchu = spchuMapper.selectByPrimaryKey(id);
		
		return spchu;
	}

	public void update(Spchu spchu) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpchuMapper spchuMapper = (SpchuMapper) app.getBean("spchuMapper");
		spchuMapper.updateByPrimaryKey(spchu);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpchuMapper spchuMapper = (SpchuMapper) context.getBean("spchuMapper");
		spchuMapper.deleteByPrimaryKey(id);
	}

	public void add(Spchu spchu) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpchuMapper spchuMapper = (SpchuMapper) context.getBean("spchuMapper");
		spchuMapper.insert(spchu);
		
	}
}
