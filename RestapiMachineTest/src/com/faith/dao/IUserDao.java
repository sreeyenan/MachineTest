package com.faith.dao;

import java.util.List;

import com.faith.model.User;

public interface IUserDao {
	public abstract List<User>getAllDetails();
	public abstract User searchUserDetails(String username, String password);
	public abstract User getUserById(int uId);
	public abstract int insertUserDetails(User user);
	public abstract int updateUserDetails(User user);
	public abstract int deleteUser(int userId);
	

}

