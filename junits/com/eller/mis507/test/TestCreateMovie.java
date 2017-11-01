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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void createMovieandSetRating() {
		
		Movie fastandfurious = new Movie("fastandfurious");
		assertTrue(fastandfurious.getName().equals("fastandfurious"));
		
		fastandfurious.addRating(Rating.FIVE);	
		
		
	}
	
	@Test
	public void writeMovieToFile() {
		
		
		//WriteMovieToFile write = new WriteMovieToFile();
		
	}
	

}
