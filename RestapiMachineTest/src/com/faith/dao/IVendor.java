package com.faith.dao;

import java.util.List;


import com.faith.model.Vendor;

public interface IVendor {
	
	public abstract List<Vendor> getAllDetails();
	

	public abstract Vendor searchVendorDetails(String searchString);

	public abstract Vendor getVendorById(int vId);

	public abstract int disableVendor(int vId);

	public abstract int insertVendorDetails(Vendor Vendor);

	public abstract int updateVendorDetails(Vendor Vendor);
	
	public abstract int insertContact(Vendor Vendor);
	
	public abstract Vendor duplication(String vName);

}

