package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class SpgysDao extends SqlSessionDaoSupport{

	public List getSpgysList(Spgys record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpgysMapper spgysMapper = (SpgysMapper) app.getBean("spgysMapper");
		List<Spgys> list = spgysMapper.selectAll(record,page,rows,sdate, edate);
		return list;
	}
	
	public Spgys getSpgysById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpgysMapper spgysMapper = (SpgysMapper) app.getBean("spgysMapper");
		Spgys spgys = spgysMapper.selectByPrimaryKey(id);
		
		return spgys;
	}

	public void update(Spgys spgys) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpgysMapper spgysMapper = (SpgysMapper) app.getBean("spgysMapper");
		spgysMapper.updateByPrimaryKey(spgys);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpgysMapper spgysMapper = (SpgysMapper) context.getBean("spgysMapper");
		spgysMapper.deleteByPrimaryKey(id);
	}

	public void add(Spgys spgys) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		SpgysMapper spgysMapper = (SpgysMapper) context.getBean("spgysMapper");
		spgysMapper.insert(spgys);
		
	}
}
