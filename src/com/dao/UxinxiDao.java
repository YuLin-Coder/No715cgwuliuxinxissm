package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class UxinxiDao extends SqlSessionDaoSupport{

	public List getUxinxiList(Uxinxi record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UxinxiMapper uxinxiMapper = (UxinxiMapper) app.getBean("uxinxiMapper");
		List<Uxinxi> list = uxinxiMapper.selectAll(record,page,rows,sdate,edate);
		return list;
	}
	
	public Uxinxi getUxinxiById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UxinxiMapper uxinxiMapper = (UxinxiMapper) app.getBean("uxinxiMapper");
		Uxinxi uxinxi = uxinxiMapper.selectByPrimaryKey(id);
		
		return uxinxi;
	}

	public void update(Uxinxi uxinxi) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UxinxiMapper uxinxiMapper = (UxinxiMapper) app.getBean("uxinxiMapper");
		uxinxiMapper.updateByPrimaryKey(uxinxi);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UxinxiMapper uxinxiMapper = (UxinxiMapper) context.getBean("uxinxiMapper");
		uxinxiMapper.deleteByPrimaryKey(id);
	}

	public void add(Uxinxi uxinxi) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UxinxiMapper uxinxiMapper = (UxinxiMapper) context.getBean("uxinxiMapper");
		uxinxiMapper.insert(uxinxi);
		
	}
}
