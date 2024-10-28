package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class UserDao extends SqlSessionDaoSupport{

	public List getUserList(User record,String username,int page,int rows,String sdate, String edate) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UserMapper userMapper = (UserMapper) app.getBean("userMapper");
		List<User> list = userMapper.selectAll(record,username,page,rows,sdate,edate);
		return list;
	}
	
	public User getUserById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UserMapper userMapper = (UserMapper) app.getBean("userMapper");
		User user = userMapper.selectByPrimaryKey(id);
		
		return user;
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UserMapper userMapper = (UserMapper) app.getBean("userMapper");
		userMapper.updateByPrimaryKey(user);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		userMapper.deleteByPrimaryKey(id);
	}

	public void add(User user) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		userMapper.insert(user);
		
	}
}
