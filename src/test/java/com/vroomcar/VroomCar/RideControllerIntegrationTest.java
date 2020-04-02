
  package com.vroomcar.VroomCar;
  

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static
  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static
  org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static
  org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import
  org.junit.runner.RunWith;
import
  org.springframework.beans.factory.annotation.Autowired;
import
  org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import
  org.springframework.boot.test.mock.mockito.MockBean;
import
  org.springframework.http.MediaType;
import
  org.springframework.test.context.junit4.SpringRunner;
import
  org.springframework.test.web.servlet.MockMvc;

import com.vroomcar.VroomCar.beans.Ride;
import com.vroomcar.VroomCar.serviceImpl.RideService;

  @RunWith(SpringRunner.class)
  
  @WebMvcTest(com.vroomcar.VroomCar.controller.RideController.class) 
  
  public class RideControllerIntegrationTest
  {
  
  
  public class EmployeeRestControllerIntegrationTest {
  
  @Autowired private MockMvc mvc;
  
  @MockBean private RideService service;
  
  @Test 
  public void givenRides_whenGetRide_thenReturnJsonArray() throws Exception {
  
  Ride ride = new Ride();
  
  List<Ride> allRides = Arrays.asList(ride);
  
      //given(service.getAllRides()).willReturn(allRides);
  
  mvc.perform(get("/Rest/VroomCar/allRides").contentType(MediaType.APPLICATION_JSON)) .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1))) .andExpect(jsonPath("$[0].name", is(ride.getRiderName()))); } }
  
  }
  