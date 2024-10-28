package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class YxinxiDao extends SqlSessionDaoSupport{

	public List getYxinxiList(Yxinxi record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YxinxiMapper yxinxiMapper = (YxinxiMapper) app.getBean("yxinxiMapper");
		List<Yxinxi> list = yxinxiMapper.selectAll(record,page,rows,sdate,edate);
		return list;
	}
	
	public Yxinxi getYxinxiById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YxinxiMapper yxinxiMapper = (YxinxiMapper) app.getBean("yxinxiMapper");
		Yxinxi yxinxi = yxinxiMapper.selectByPrimaryKey(id);
		
		return yxinxi;
	}

	public void update(Yxinxi yxinxi) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YxinxiMapper yxinxiMapper = (YxinxiMapper) app.getBean("yxinxiMapper");
		yxinxiMapper.updateByPrimaryKey(yxinxi);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YxinxiMapper yxinxiMapper = (YxinxiMapper) context.getBean("yxinxiMapper");
		yxinxiMapper.deleteByPrimaryKey(id);
	}

	public void add(Yxinxi yxinxi) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YxinxiMapper yxinxiMapper = (YxinxiMapper) context.getBean("yxinxiMapper");
		yxinxiMapper.insert(yxinxi);
		
	}
}
