package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.faith.dao.IVendorContactPersons;
import com.faith.model.Vendor;
import com.faith.model.VendorContactPersons;


@CrossOrigin
@RestController
@RequestMapping("/api")

public class VendorContactPersonsController {
	
	//Get All Details
		@Autowired 
		private IVendorContactPersons dao;

		@RequestMapping(value = "/alldetails", method = RequestMethod.GET)
		public List getContactPersonDetails() {
			List list;
			list = dao.getAllDetails();
			return list;
		}
		
		// GeT search
		@SuppressWarnings("rawtypes")
		@RequestMapping(value = "/searchDetails/{string}", method = RequestMethod.GET)
		public List getContactPersonDetails(@PathVariable("string") String string) {
			List list;
			if(string.equals("null")){
				list = dao.getAllDetails();
			}else{
			list = dao.searchVendorcontactDetails(string);
			}
			return list;
		}
		
		
		// Get details by id
				@RequestMapping(value = "/vendorcontactdetailsid/{cpId}", method = RequestMethod.GET)
				public VendorContactPersons getVendorContactPersonsById(@PathVariable("cpId") int Id) {
					VendorContactPersons vendorcontact = dao.getVendorContactPersonsById(Id);
//					System.out.println("Get a single user details by vId");
					return vendorcontact;
				}
//		

}
