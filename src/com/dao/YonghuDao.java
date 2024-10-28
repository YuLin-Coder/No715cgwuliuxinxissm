package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class YonghuDao extends SqlSessionDaoSupport{

	public List getYonghuList(Yonghu record,String yonghuname,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YonghuMapper yonghuMapper = (YonghuMapper) app.getBean("yonghuMapper");
		List<Yonghu> list = yonghuMapper.selectAll(record,yonghuname,page,rows,sdate,edate);
		return list;
	}
	
	public Yonghu getYonghuById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YonghuMapper yonghuMapper = (YonghuMapper) app.getBean("yonghuMapper");
		Yonghu yonghu = yonghuMapper.selectByPrimaryKey(id);
		
		return yonghu;
	}

	public void update(Yonghu yonghu) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YonghuMapper yonghuMapper = (YonghuMapper) app.getBean("yonghuMapper");
		yonghuMapper.updateByPrimaryKey(yonghu);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YonghuMapper yonghuMapper = (YonghuMapper) context.getBean("yonghuMapper");
		yonghuMapper.deleteByPrimaryKey(id);
	}

	public void add(Yonghu yonghu) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		YonghuMapper yonghuMapper = (YonghuMapper) context.getBean("yonghuMapper");
		yonghuMapper.insert(yonghu);
		
	}
}
