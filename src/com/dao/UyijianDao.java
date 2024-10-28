package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class UyijianDao extends SqlSessionDaoSupport{

	public List getUyijianList(Uyijian record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UyijianMapper uyijianMapper = (UyijianMapper) app.getBean("uyijianMapper");
		List<Uyijian> list = uyijianMapper.selectAll(record,page,rows,sdate,edate);
		return list;
	}
	
	public Uyijian getUyijianById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UyijianMapper uyijianMapper = (UyijianMapper) app.getBean("uyijianMapper");
		Uyijian uyijian = uyijianMapper.selectByPrimaryKey(id);
		
		return uyijian;
	}

	public void update(Uyijian uyijian) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UyijianMapper uyijianMapper = (UyijianMapper) app.getBean("uyijianMapper");
		uyijianMapper.updateByPrimaryKey(uyijian);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UyijianMapper uyijianMapper = (UyijianMapper) context.getBean("uyijianMapper");
		uyijianMapper.deleteByPrimaryKey(id);
	}

	public void add(Uyijian uyijian) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UyijianMapper uyijianMapper = (UyijianMapper) context.getBean("uyijianMapper");
		uyijianMapper.insert(uyijian);
		
	}
}
