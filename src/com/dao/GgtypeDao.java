package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class GgtypeDao extends SqlSessionDaoSupport{

	public List getGgtypeList(Ggtype record,int page,int rows) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		GgtypeMapper ggtypeMapper = (GgtypeMapper) app.getBean("ggtypeMapper");
		List<Ggtype> list = ggtypeMapper.selectAll(record,page,rows);
		return list;
	}
	
	public Ggtype getGgtypeById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		GgtypeMapper ggtypeMapper = (GgtypeMapper) app.getBean("ggtypeMapper");
		Ggtype ggtype = ggtypeMapper.selectByPrimaryKey(id);
		
		return ggtype;
	}

	public void update(Ggtype ggtype) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		GgtypeMapper ggtypeMapper = (GgtypeMapper) app.getBean("ggtypeMapper");
		ggtypeMapper.updateByPrimaryKey(ggtype);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		GgtypeMapper ggtypeMapper = (GgtypeMapper) context.getBean("ggtypeMapper");
		ggtypeMapper.deleteByPrimaryKey(id);
	}

	public void add(Ggtype ggtype) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		GgtypeMapper ggtypeMapper = (GgtypeMapper) context.getBean("ggtypeMapper");
		ggtypeMapper.insert(ggtype);
		
	}
}
