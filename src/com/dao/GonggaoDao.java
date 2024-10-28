package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class GonggaoDao extends SqlSessionDaoSupport{

	public List getGonggaoList(Gonggao record,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		GonggaoMapper gonggaoMapper = (GonggaoMapper) app.getBean("gonggaoMapper");
		List<Gonggao> list = gonggaoMapper.selectAll(record,page,rows,sdate,edate);
		return list;
	}
	
	public Gonggao getGonggaoById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		GonggaoMapper gonggaoMapper = (GonggaoMapper) app.getBean("gonggaoMapper");
		Gonggao gonggao = gonggaoMapper.selectByPrimaryKey(id);
		
		return gonggao;
	}

	public void update(Gonggao gonggao) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		GonggaoMapper gonggaoMapper = (GonggaoMapper) app.getBean("gonggaoMapper");
		gonggaoMapper.updateByPrimaryKey(gonggao);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		GonggaoMapper gonggaoMapper = (GonggaoMapper) context.getBean("gonggaoMapper");
		gonggaoMapper.deleteByPrimaryKey(id);
	}

	public void add(Gonggao gonggao) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		GonggaoMapper gonggaoMapper = (GonggaoMapper) context.getBean("gonggaoMapper");
		gonggaoMapper.insert(gonggao);
		
	}
}
