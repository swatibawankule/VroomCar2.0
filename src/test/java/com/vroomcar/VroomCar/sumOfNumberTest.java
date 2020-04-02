package com.vroomcar.VroomCar;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertEquals;

import org.junit.Assert.*;

import org.junit.Test;

import com.vroomcar.VroomCar.beans.SumOfNumbers;

public class sumOfNumberTest {
  SumOfNumbers myMath = new SumOfNumbers();

	
  @Test
	public void sum_with3numbers() {
		System.out.println("Test1");
		assertEquals(13, myMath.sum(new int[] { 1, 2, 10}));
	
	}

}
