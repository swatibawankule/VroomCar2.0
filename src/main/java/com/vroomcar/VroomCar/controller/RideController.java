package com.vroomcar.VroomCar.controller;


import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vroomcar.VroomCar.Exception.CustomErrorResponse;
import com.vroomcar.VroomCar.Exception.InvalidNUmberException;
import com.vroomcar.VroomCar.Exception.RideNotPresentException;
import com.vroomcar.VroomCar.beans.Ride;
import com.vroomcar.VroomCar.util.SmsApi;
import come.vroomcar.VroomCar.service.IRideService;



@RestController
@RequestMapping("Rest/VroomCar")
public class RideController {

	@Autowired
	IRideService rideService;
	
	
	@GetMapping(value ="/allRides", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Ride>> findAll(){
		
		//check if the Ride is already present in the data base- content already there status -409 conflict
		
		List<Ride>	list = rideService.getAllRides();
		//rideService.getRideById(1);

		return new ResponseEntity<List<Ride>>(list, HttpStatus.OK);
//		
	}
	
	
	@GetMapping(value ="/Rides/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Ride> findRideByRideId( @PathVariable("id") Long rideId) throws Exception{
		
		System.out.println(rideId);
		//check if the Ride is already present in the data base- content already there status -409 conflict
		

		
		
		Ride ride = rideService.getRideById(rideId);
		if(ride == null) {
			return new ResponseEntity<Ride>(HttpStatus.NOT_FOUND);
		// return ride;
		
		}
		//rideService.getRideById(1);
		return new ResponseEntity<Ride>( ride, HttpStatus.FOUND);
		//return ride;
//		
	}
	
	@PostMapping(value ="/loadRide" ,produces= { MediaType.APPLICATION_JSON_VALUE }) 
	  public ResponseEntity<Ride> load(@Valid @RequestBody  Ride ride) {
	
	  boolean flag = rideService.addRide(ride);
   
	  if (flag == false) {
		  
	   //return new ResponseEntity<Ride>(HttpStatus.CONFLICT).;
  	
        //    throw new ConfictException();
		  System.out.println("Ride already Present!!");
        
    }
	
			  
    return new ResponseEntity<Ride>(HttpStatus.CREATED);
	  
	  }
	
	@DeleteMapping(value ="/Rides/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Ride> deleteRideByRideId( @PathVariable("id") Long rideId) throws RideNotPresentException {
		
		  System.out.println(rideId);
	
		    rideService.deleteRide(rideId);
	
		return new ResponseEntity<Ride>(HttpStatus.OK);
	
//		
	}
	
	  @GetMapping(value ="sendSMS/{mobile}")
	  public ResponseEntity<CustomErrorResponse> sendSMSByMobileNumber(@PathVariable("mobile") String mobile) throws InvalidNUmberException {
	  
		  //validation for mobile number validity
		 System.out.println("mobile number:--"+mobile);
	  SmsApi smsApi = new SmsApi(); 
	  
	  smsApi.senSMS(mobile); // return new
	  
	  return new ResponseEntity<CustomErrorResponse>(HttpStatus.OK);
	  
	  }
	 
	
	
}
