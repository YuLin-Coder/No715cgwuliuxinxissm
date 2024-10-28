package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class UzhanneiDao extends SqlSessionDaoSupport{

	public List getUzhanneiList(Uzhannei record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UzhanneiMapper uzhanneiMapper = (UzhanneiMapper) app.getBean("uzhanneiMapper");
		List<Uzhannei> list = uzhanneiMapper.selectAll(record,page,rows,sdate,edate);
		return list;
	}
	
	public Uzhannei getUzhanneiById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UzhanneiMapper uzhanneiMapper = (UzhanneiMapper) app.getBean("uzhanneiMapper");
		Uzhannei uzhannei = uzhanneiMapper.selectByPrimaryKey(id);
		
		return uzhannei;
	}

	public void update(Uzhannei uzhannei) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UzhanneiMapper uzhanneiMapper = (UzhanneiMapper) app.getBean("uzhanneiMapper");
		uzhanneiMapper.updateByPrimaryKey(uzhannei);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UzhanneiMapper uzhanneiMapper = (UzhanneiMapper) context.getBean("uzhanneiMapper");
		uzhanneiMapper.deleteByPrimaryKey(id);
	}

	public void add(Uzhannei uzhannei) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UzhanneiMapper uzhanneiMapper = (UzhanneiMapper) context.getBean("uzhanneiMapper");
		uzhanneiMapper.insert(uzhannei);
		
	}
}
