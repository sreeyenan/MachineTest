package com.faith.dao;

import java.util.List;


import com.faith.model.VendorContactPersons;



public interface IVendorContactPersons {
	
	public abstract List<VendorContactPersons>getAllDetails();
	public abstract List<VendorContactPersons> searchVendorcontactDetails(String string);
	public abstract VendorContactPersons getVendorContactPersonsById(int cpId);

}
