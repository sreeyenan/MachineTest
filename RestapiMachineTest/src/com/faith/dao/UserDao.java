package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.faith.model.User;

public class UserDao implements IUserDao {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
this.template = template;
}

@Override
		public List<User> getAllDetails() {
		
		return template.query("select userid, username,password,roleid from user order by userid desc",
		new RowMapper<User>() {
		public User mapRow(ResultSet rs, int row) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt(1));
		user.setUserName(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setRoleId(rs.getInt(4));
		
		return user;
	}
	});
	}

@Override
	public User searchUserDetails(String userName,String password) {
	
	String sql = "select userid, username,password,roleid from user where username=? and password =?";
	return template.queryForObject(sql, new Object[] { userName,password }, new BeanPropertyRowMapper<User>(User.class));
	}

@Override
public User getUserById(int userId) {

String sql = "select userid, username,password,roleid from user where userid=?";
return template.queryForObject(sql, new Object[] { userId }, new BeanPropertyRowMapper<User>(User.class));

}

@Override
public int deleteUser(int userId) {
String sql = " DELETE FROM user where userId=?";
return template.update(sql, new Object[] { userId });

}


@Override
public int insertUserDetails(User user) {

String sqlOne = "insert into user(username,password,roleid) values('" + user.getUserName() + "','"
+ user.getPassword() + "','" + user.getRoleId() +"')";

return template.update(sqlOne);

}


@Override
public int updateUserDetails(User user) {
// to update user table
String sqlOne = "update user set username='" + user.getUserName() + "',password='" + user.getPassword() + "',roleId='"
+ user.getRoleId() +   " where userid=?";
return template.update(sqlOne, new Object[] { user.getUserId() });

}
}