package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IUserDao;
import com.faith.model.User;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class UserController {
	@Autowired
	private IUserDao dao;
	
	//get all users
	
	@RequestMapping (value = "/userdetails", method = RequestMethod.GET)
	public List getUserDetails (){
		List list ;
		System.out.println("get all user details");
		list = dao.getAllDetails();
		
		return list;
	}

	//get by names
	
	@RequestMapping (value = "/userdetbyname/{userName}/{password}", method = RequestMethod.GET)
	public User getUserDetails (@PathVariable("userName") String userName,@PathVariable("password") String password){
		
		User user = (User)dao.searchUserDetails(userName,password);
		System.out.println("get all user details by username and password");
		return user;
	}	

//get by userid

@RequestMapping (value = "/userdetbyid/{userId}", method = RequestMethod.GET)
public User getUserById (@PathVariable("userId") int userId){
	
	User user = dao.getUserById(userId);
	System.out.println("get all user by name");
	return user;
}	

//insert User-Contact Details
@RequestMapping(value="/insertuser",method=RequestMethod.POST)
public void insertDetails(@RequestBody User user)
{
dao.insertUserDetails(user);
}

//update User-Contact Details
@RequestMapping(value="/updateuser",method=RequestMethod.PUT)
public void updateDetails(@RequestBody User user)
{
dao.updateUserDetails(user);
}
//disable User-Contact Details
@RequestMapping(value="/disableuser/{userId}",method=RequestMethod.PUT)
void deleteUser(@PathVariable("userId")int userId)
{
dao.deleteUser(userId);
}
}