package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IVendor;
import com.faith.model.Vendor;
import com.faith.model.Vendor;




@CrossOrigin
@RestController
@RequestMapping("/api")
public class VendorController {
	
	@Autowired 
	private IVendor dao;
	
//Get All Details
	@RequestMapping(value = "/vendorDetails", method = RequestMethod.GET)
	public List getvendorDetails() {
		List list;
		list = dao.getAllDetails();
		return list;
	}
	// GeT details by Name
		@RequestMapping(value = "/vendordetailsname/{searchString}", method = RequestMethod.GET)
		public Vendor getVendorDetails(@PathVariable("searchString") String searchString) {
			Vendor vendor = dao.searchVendorDetails(searchString);
			return vendor;
		}
		
		// Get details by id
		@RequestMapping(value = "/vendordetailsid/{vId}", method = RequestMethod.GET)
		public Vendor getVendorById(@PathVariable("vId") int Id) {
			Vendor vendor = dao.getVendorById(Id);
//			System.out.println("Get a single user details by vId");
			return vendor;
		}
		
		// Disable the row by Id
		@RequestMapping(value = "/vendordetailsdelete/{vId}", method = RequestMethod.PUT)
		void disableVendor(@PathVariable("vId") int Id) {

//			System.out.println("Get a single user details by vId");
			dao.disableVendor(Id);
		}
		// Insert data into table
		@RequestMapping(value = "/vendordetailsinsert", method = RequestMethod.POST)
		public void insertVendorDetails(@RequestBody Vendor vendor) {
			dao.insertVendorDetails(vendor);

		}
		// update table values
		@RequestMapping(value = "/purchaseDetdetailsupdate/{vId}", method = RequestMethod.PUT)
		public void updateVendorDetails(@RequestBody Vendor purchaseDet) {
			dao.updateVendorDetails(purchaseDet);
		}
		// Duplication checking
		@RequestMapping(value="/duplication1/{vname}",method = RequestMethod.GET)
		public Vendor duplication(@PathVariable(value="vName") String vName){
			Vendor vendor= (Vendor)dao.duplication(vName);
			return vendor;
				
			}

}
