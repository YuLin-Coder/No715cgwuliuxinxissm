package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.*;
import com.model.*;
@Repository
public class RoleDao extends SqlSessionDaoSupport{

	public List getRoleList(Role record,int page,int rows) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		RoleMapper roleMapper = (RoleMapper) app.getBean("roleMapper");
		List<Role> list = roleMapper.selectAll(record,page,rows);
		return list;
	}
	
	public Role getRoleById(int id){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		RoleMapper roleMapper = (RoleMapper) app.getBean("roleMapper");
		Role role = roleMapper.selectByPrimaryKey(id);
		
		return role;
	}

	public void update(Role role) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:beans.xml");
		RoleMapper roleMapper = (RoleMapper) app.getBean("roleMapper");
		roleMapper.updateByPrimaryKey(role);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		RoleMapper roleMapper = (RoleMapper) context.getBean("roleMapper");
		roleMapper.deleteByPrimaryKey(id);
	}

	public void add(Role role) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		RoleMapper roleMapper = (RoleMapper) context.getBean("roleMapper");
		roleMapper.insert(role);
		
	}
}
