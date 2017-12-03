/**
 * 
 */
package com.eller.mis507.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.searchcriteria.Rating;
import com.eller.mis507.utilities.WriteMovieToFile;

/**
 * @author sumit
 *
 */
public class TestCreateMovie {
	
	Movie fastandfurious;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fastandfurious = new Movie("fastandfurious");
		fastandfurious.addRating(Rating.FIVE);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

		
	@Test
	public void createMovieandSetRating() {
		assertTrue(fastandfurious.getName().equals("fastandfurious"));
		assertTrue(fastandfurious.getScore()==5);	
	}
	
	@Test
	public void createMovieandSetRatingNagetive() {
		assertFalse(fastandfurious.getName().equals("unknownMovieName"));
		assertFalse(fastandfurious.getScore()==4);
		
	}
	

}
