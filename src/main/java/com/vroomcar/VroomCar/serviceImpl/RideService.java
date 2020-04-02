/**
 * 
 */
package com.vroomcar.VroomCar.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vroomcar.VroomCar.Exception.RideNotPresentException;
import com.vroomcar.VroomCar.Repository.RideRepository;
import com.vroomcar.VroomCar.beans.Ride;

import come.vroomcar.VroomCar.service.IRideService;

/**
 * @author swatibawankule
 * Service class to implement Ride related logics
 *
 */
@Component
public class RideService implements IRideService{
	
	@Autowired
	RideRepository rideRepository;
	
	static ArrayList<Ride> rideList = new ArrayList<Ride>();
	
 static void getInMemoryRideList() {
	Ride ride1 =  new Ride(1, 27, "swati", "Pune", "Mumbai", 1);
	Ride ride2 =  new Ride(1, 22, "Neha", "Mumbai", "pune", 1);
	rideList.add(ride1);
	rideList.add(ride2);
  }

	@Override
	public List<Ride> getAllRides() {
		// TODO Auto-generated method stub
		
		//check if the Ride is already present...send status code already exists
		
		//
		//getInMemoryRideList();
		rideList = (ArrayList<Ride>) rideRepository.findAll();
		
		return rideList;
		
		
	}

	
	public Ride getRideById(long rideId) {
		
		//rideRepository.findByriderName(riderName);
	if(rideList !=null) {
		
	Stream<Ride> rideStream = rideList.stream();
		
	Optional<Ride> r = rideStream.filter(Ride->(rideId == Ride.getRideid())).findFirst();
	
	if(r.isPresent())
		return r.get();
	}

		return null;
	
	}
	
	public Ride getRideByRiderName(String name) {
		
		 Ride ride = rideRepository.findByriderName(name); 
		 
		 return ride;
		
	}
	@Override
	public boolean addRide(Ride ride) {
	   
		rideRepository.save(ride);
		return true;
	}

	@Override
	public void updateRide(Ride ride) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRide(Long rideId) throws RideNotPresentException {
		
		if(rideList !=null) {

		Ride ride = rideList.stream()
				  .filter(Ride -> rideId.intValue()== Ride.getRideid())
				  .findAny()
				  .orElse(null);
		if(ride == null) {
			throw new RideNotPresentException();
		}
		if(ride!=null)
		rideList.remove(ride);
		
		}	
		
		
	}


}
