package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class RizhiDao extends SqlSessionDaoSupport{

	public List getRizhiList(Rizhi record,int page,int rows) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		RizhiMapper rizhiMapper = (RizhiMapper) app.getBean("rizhiMapper");
		List<Rizhi> list = rizhiMapper.selectAll(record,page,rows);
		return list;
	}
	
	public Rizhi getRizhiById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		RizhiMapper rizhiMapper = (RizhiMapper) app.getBean("rizhiMapper");
		Rizhi rizhi = rizhiMapper.selectByPrimaryKey(id);
		
		return rizhi;
	}

	public void update(Rizhi rizhi) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		RizhiMapper rizhiMapper = (RizhiMapper) app.getBean("rizhiMapper");
		rizhiMapper.updateByPrimaryKey(rizhi);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		RizhiMapper rizhiMapper = (RizhiMapper) context.getBean("rizhiMapper");
		rizhiMapper.deleteByPrimaryKey(id);
	}

	public void add(Rizhi rizhi) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		RizhiMapper rizhiMapper = (RizhiMapper) context.getBean("rizhiMapper");
		rizhiMapper.insert(rizhi);
		
	}
}
