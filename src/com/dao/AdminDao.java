package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class AdminDao extends SqlSessionDaoSupport{

	public List getAdminList(Admin record,int page,int rows) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		AdminMapper adminMapper = (AdminMapper) app.getBean("adminMapper");
		List<Admin> list = adminMapper.selectAll(record,page,rows);
		return list;
	}
	
	public Admin getAdminById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		AdminMapper adminMapper = (AdminMapper) app.getBean("adminMapper");
		Admin admin = adminMapper.selectByPrimaryKey(id);
		
		return admin;
	}

	public void update(Admin admin) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		AdminMapper adminMapper = (AdminMapper) app.getBean("adminMapper");
		adminMapper.updateByPrimaryKey(admin);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		AdminMapper adminMapper = (AdminMapper) context.getBean("adminMapper");
		adminMapper.deleteByPrimaryKey(id);
	}

	public void add(Admin admin) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		AdminMapper adminMapper = (AdminMapper) context.getBean("adminMapper");
		adminMapper.insert(admin);
		
	}
}
