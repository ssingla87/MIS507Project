package com.eller.mis507.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eller.mis507.entities.Audience;
import com.eller.mis507.entities.Movie;
import com.eller.mis507.entities.User;
import com.eller.mis507.searchcriteria.Rating;
import com.eller.mis507.searchcriteria.UserType;

public class TestMovieRatingNotifier {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		User sumit = new Audience("Sumit", "Singla", "sumitsingla18@gmail.com", UserType.CRITIQUE);
		User aditya = new Audience("Aditya", "Rege", "acdcfanman15@gmail.com", UserType.CRITIQUE);
		
		Movie fastandfurious = new Movie("fastandfurious");
//		fastandfurious.addRating(Rating.FIVE);	
		fastandfurious.register(sumit);
		fastandfurious.register(aditya);
		
		
		sumit.setMovieToObserve(fastandfurious);
		aditya.setMovieToObserve(fastandfurious);
		
		fastandfurious.addRating(Rating.ONE);	
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
