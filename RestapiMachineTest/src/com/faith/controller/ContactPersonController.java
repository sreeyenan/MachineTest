package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IContact;
import com.faith.model.ContactPerson;
import com.faith.model.ContactPerson;



@CrossOrigin
@RestController
@RequestMapping("/api")

public class ContactPersonController {
	
	
	//Get All Details
	@Autowired 
	private IContact dao;

	@RequestMapping(value = "/contactdetails", method = RequestMethod.GET)
	public List getContactPersonDetails() {
		List list;
		list = dao.getAllDetails();
		return list;
	}
	
	// GeT details by Name
		@RequestMapping(value = "/contactdetailsname/{searchString}", method = RequestMethod.GET)
		public ContactPerson getContactPersonDetails(@PathVariable("searchString") String searchString) {
			ContactPerson contactPerson = dao.searchContactPersonDetails(searchString);
			return contactPerson;
		}
		
		// Get details by id
		@RequestMapping(value = "/contactdetailsid/{cpId}", method = RequestMethod.GET)
		public ContactPerson getContactPersonById(@PathVariable("cpId") int Id) {
			ContactPerson contactPerson = dao.getContactPersonById(Id);
//			System.out.println("Get a single user details by cpId");
			return contactPerson;
		}

		// Disable the row by Id
		@RequestMapping(value = "/contactdetailsdelete/{cpId}", method = RequestMethod.PUT)
		void disableContactPerson(@PathVariable("cpId") int Id) {

//			System.out.println("Get a single user details by cpId");
			dao.disableContactPerson(Id);
		}

		// Insert data into table
		@RequestMapping(value = "/contactdetailsinsert", method = RequestMethod.POST)
		public void insertContactPersonDetails(@RequestBody ContactPerson contactPerson) {
			dao.insertContactPersonDetails(contactPerson);

		}

		// update table values
		@RequestMapping(value = "/contactdetailsupdate/{cpId}", method = RequestMethod.PUT)
		public void updateContactPersonDetails(@RequestBody ContactPerson contactPerson) {
			dao.updateContactPersonDetails(contactPerson);
		}
		// Duplication checking
		@RequestMapping(value="/duplication/{cpEmail}",method = RequestMethod.GET)
		public ContactPerson duplication(@PathVariable(value="cpEmail") String cpEmail) {
			ContactPerson contacts= (ContactPerson)dao.duplication(cpEmail);
			return contacts;
				
			}

		
		
		
		


}
