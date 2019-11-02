package com.faith.dao;

import java.util.List;


import com.faith.model.ContactPerson;
import com.faith.model.Vendor;
import com.faith.model.VendorContactPersons;

public interface IContact {
	
	public abstract List<ContactPerson> getAllDetails();
	
	public abstract ContactPerson searchContactPersonDetails(String searchString);

	public abstract ContactPerson getContactPersonById(int cpId);

	public abstract int disableContactPerson(int cpId);

	public abstract int insertContactPersonDetails(ContactPerson contactPerson);

	public abstract int updateContactPersonDetails(ContactPerson contactPerson);
	
	public abstract ContactPerson duplication(String cpEmail);

	
	

}
