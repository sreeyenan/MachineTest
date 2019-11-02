package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.faith.model.Vendor;


public class VendorDao implements IVendor {
	
	//Jdbc Template
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}	
	
	@Override
	public List<Vendor> getAllDetails() {
		return template.query("select vId,vName,vAddress,vLocation,vService,vPincode,isactive from Vendor where isactive='Y' order by vId desc",
				new RowMapper<Vendor>(){
					public Vendor mapRow(ResultSet rs,int row)
						throws SQLException{
					Vendor vendor = new Vendor();
					vendor.setvId(rs.getInt(1));
					vendor.setvName(rs.getString(2));
					vendor.setvAddress(rs.getString(3));
					vendor.setvLocation(rs.getString(4));
					vendor.setvService(rs.getString(5));
					vendor.setvPincode(rs.getInt(6));
					vendor.setIsActive(rs.getString(7));
					return vendor;}
	});	
}

	@Override
	public Vendor searchVendorDetails(String searchString) {
		String sql="select vId,vName,vAddress,vLocation,vService,vPincode from vendor where vname=? and isactive='Y'";
		return template.queryForObject(sql, new Object[] { searchString },
				new BeanPropertyRowMapper<Vendor>(Vendor.class));
	}

	@Override
	public Vendor getVendorById(int vId) {
			String sql="select vId,vName,vAddress,vLocation,vService,vPincode from Vendor where vid=? and isactive='Y'";
			return template.queryForObject(sql, new Object[] {vId},
					new BeanPropertyRowMapper<Vendor>(Vendor.class));
		}

	@Override
	public int disableVendor(int vId) {
		String sql = "update vendor set isactive='N' where vId=?";
		return template.update(sql, new Object[] { vId });
	}

	@Override
	public int insertVendorDetails(Vendor Vendor) {

		String sqlOne = "insert into vendor(vName,vAddress,vLocation,vService,vPincode) "
				+ "values('"
				+ Vendor.getvName()
				+ "','"
				+ Vendor.getvAddress()
				+ "','"
				+ Vendor.getvLocation()
				+ "','"
				+ Vendor.getvService()
				+ "','"
				+ Vendor.getvPincode()
				
				+ "')";
				
		return template.update(sqlOne);
	}


	@Override
	public int updateVendorDetails(Vendor Vendor) {

		String sqlOne = "update Vendor set vName='" + Vendor.getvName()
		+ "',vAddress='" + Vendor.getvAddress() + "',vLocation ='" + Vendor.getvLocation()+ "',vService ='" + Vendor.getvService()
		+ "',vPincode='" + Vendor.getvPincode() +"' where pdId=?";
		return template.update(sqlOne, new Object[] { Vendor.getvId() });
	}


	@Override
	public Vendor duplication(String vName) {
		String sql="select vName from vendor where  vName=? and isactive='Y' ";
		return template.queryForObject(sql,new Object[] {vName},
				new BeanPropertyRowMapper<Vendor>(Vendor.class));
		}


	@Override
	public int insertContact(Vendor Vendor) {
		// TODO Auto-generated method stub
		return 0;
	}

}
