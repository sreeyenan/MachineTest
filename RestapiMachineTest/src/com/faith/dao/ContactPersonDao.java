package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.faith.model.ContactPerson;
import com.faith.model.ContactPerson;
import com.faith.model.ContactPerson;

public class ContactPersonDao implements IContact {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}	

	@Override
	public List<ContactPerson> getAllDetails() {
		return template.query("select cpid,cpName,cpVId,cpDepartment,cpEmail,cpPhone,isactive from ContactPerson where isactive='Y' order by cpid desc",
				new RowMapper<ContactPerson>(){
					public ContactPerson mapRow(ResultSet rs,int row)
						throws SQLException{
					ContactPerson contactPerson = new ContactPerson();
					contactPerson.setCpId(rs.getInt(1));
					contactPerson.setCpName(rs.getString(2));
					contactPerson.setCpVId(rs.getInt(3));
					contactPerson.setCpDepartment(rs.getString(4));
					contactPerson.setCpEmail(rs.getString(5));
					contactPerson.setCpPhone(rs.getInt(6));
					contactPerson.setIsActive(rs.getString(7));
					return contactPerson;}
					
	});	
}


	@Override
	public ContactPerson searchContactPersonDetails(String searchString) {
		String sql="select cpid,cpName,cpVId,cpDepartment,cpEmail,cpPhone from ContactPerson where cpname=? and isactive='Y'";
		return template.queryForObject(sql, new Object[] { searchString },
				new BeanPropertyRowMapper<ContactPerson>(ContactPerson.class));
	}


	@Override
	public ContactPerson getContactPersonById(int cpId) {
		String sql="select cpid,cpName,cpVId,cpDepartment,cpEmail,cpPhone from ContactPerson where cpid=? and isactive='Y'";
		return template.queryForObject(sql, new Object[] {cpId},
				new BeanPropertyRowMapper<ContactPerson>(ContactPerson.class));
	}

	@Override
	public int disableContactPerson(int cpId) {
		String sql = "update contactperson set isactive='N' where cpId=?";
		return template.update(sql, new Object[] { cpId });
	}

	@Override
	public int insertContactPersonDetails(ContactPerson contactPerson) {
		String sqlOne = "insert into contactPerson(cpName,cpVId,cpDepartment,cpEmail,cpPhone) "
				+ "values('"
				+ contactPerson.getCpName()
				+ "','"
				+ contactPerson.getCpVId()
				+ "','"
				+ contactPerson.getCpDepartment()
				+ "','"
				+ contactPerson.getCpEmail()
				+ "','"
				+ contactPerson.getCpPhone()

				+ "')";
				
		return template.update(sqlOne);
	}


	@Override
	public int updateContactPersonDetails(ContactPerson contactPerson) {
		
		String sqlOne = "update contactPerson set CpName='" + contactPerson.getCpName()
		+ "',CpDepartment ='" + contactPerson.getCpDepartment()+ "',CpEmail ='" + contactPerson.getCpEmail()
		+ "',CpPhone=" + contactPerson.getCpPhone() +" where cpId=?";
		return template.update(sqlOne, new Object[] { contactPerson.getCpId() });
	}

	@Override
	public ContactPerson duplication(String cpEmail) {
		String sql="select cpEmail from ContactPerson where cpEmail=? and isactive='Y' ";
		return template.queryForObject(sql,new Object[] {cpEmail},
				new BeanPropertyRowMapper<ContactPerson>(ContactPerson.class));
		}

}
