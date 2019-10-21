package com.dzkj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dzkj.mapper.UsersMapper;
import com.dzkj.pojo.Users;

@Controller
public class Userscontroller {
	@Autowired
	private UsersMapper um;
	
	@RequestMapping("/add")
	public String add(Users u) {
		u=new Users(3, "李志磊");
		int i = um.insert(u);
		if(i>0) {
		return "index";}
		return "list";
	}
	@RequestMapping("/delect")
	public String delect(Users u) {
		u.setS_id(1);
		if(um.delete(u)>0) {
			return "index";
		} return "list";
	}
	@RequestMapping("/update")
	public String update(Users u) {
		
		if(um.updateByPrimaryKey(u)>0) {return "index";}
		return "list";
	}
	@RequestMapping("/select")
	public String select(Map<String, Object> map) {
		List<Users> users = um.selectAll();
		map.put("user", users);
		return "list";
	}
}
