package com.vroomcar.VroomCar.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vroomcar.VroomCar.beans.Ride;

public interface RideRepository  extends CrudRepository<Ride, Long>{

	public Ride findByriderName(String riderName);

	public List<Ride> findByRideidAndRiderName(Integer rideid, String riderName);

	public Ride findByrideid(Integer id);
}
