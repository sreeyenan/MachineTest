package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.faith.model.Vendor;
import com.faith.model.VendorContactPersons;





public class VendorContactPersonsDao implements IVendorContactPersons {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}	


	@Override
	public List<VendorContactPersons> getAllDetails() {
		return template.query("select * from vendorContact  order by cpid desc",
				new RowMapper<VendorContactPersons>(){
					public VendorContactPersons mapRow(ResultSet rs,int row)
						throws SQLException{
						VendorContactPersons vendorContact = new VendorContactPersons();
						vendorContact.setCpId(rs.getInt("cpId"));
						vendorContact.setCpName(rs.getString("CpName"));
						vendorContact.setCpVId(rs.getInt("cpVId"));
						vendorContact.setCpDepartment(rs.getString("CpDepartment"));
						vendorContact.setCpEmail(rs.getString("CpEmail"));
						vendorContact.setCpPhone(rs.getString("CpPhone"));
						
						vendorContact.setvId(rs.getInt("vId"));
						vendorContact.setvName(rs.getString("vName"));
						vendorContact.setvAddress(rs.getString("vAddress"));
						vendorContact.setvLocation(rs.getString("vLocation"));
						vendorContact.setvService(rs.getString("vService"));
						vendorContact.setvPincode(rs.getInt("vPincode"));
//						vendorContact.setIsActive(rs.getString("IsActive"));
					return vendorContact;}
					
	});	
}
	@Override
	public List <VendorContactPersons> searchVendorcontactDetails(String string) {
		return template.query("select * from vendorContact where  vLocation= '"+string+"' or vName='"+string+"' or vService='"+string+"' ",
		new RowMapper<VendorContactPersons>() {
			public VendorContactPersons mapRow(ResultSet rs,int row)
					throws SQLException{
			VendorContactPersons vendorContact = new VendorContactPersons();
			vendorContact.setCpId(rs.getInt("cpId"));
			vendorContact.setCpName(rs.getString("CpName"));
			vendorContact.setCpVId(rs.getInt("cpVId"));
			vendorContact.setCpDepartment(rs.getString("CpDepartment"));
			vendorContact.setCpEmail(rs.getString("CpEmail"));
			vendorContact.setCpPhone(rs.getString("CpPhone"));
			
			vendorContact.setvId(rs.getInt("vId"));
			vendorContact.setvName(rs.getString("vName"));
			vendorContact.setvAddress(rs.getString("vAddress"));
			vendorContact.setvLocation(rs.getString("vLocation"));
			vendorContact.setvService(rs.getString("vService"));
			vendorContact.setvPincode(rs.getInt("vPincode"));
//			vendorContact.setIsActive(rs.getString("IsActive"));
		return vendorContact;}
			
		});
}	


	@Override
	public VendorContactPersons getVendorContactPersonsById(int cpId) {
		String sql="select * from Vendorcontact where cpid=?";
		return template.queryForObject(sql, new Object[] {cpId},
				new BeanPropertyRowMapper<VendorContactPersons>(VendorContactPersons.class));
	}


}
