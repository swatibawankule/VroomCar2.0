package come.vroomcar.VroomCar.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.vroomcar.VroomCar.Exception.RideNotPresentException;
import com.vroomcar.VroomCar.beans.Ride;


@Component
public interface IRideService {
	 List<Ride> getAllRides();
     Ride getRideById(long rideId);
     boolean addRide(Ride ride);
     void updateRide(Ride ride);
     void deleteRide(Long rideId) throws RideNotPresentException;
	
}
