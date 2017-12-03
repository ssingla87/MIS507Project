package com.eller.mis507.test;
import static org.junit.Assert.*;

import java.io.PrintWriter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.searchcriteria.Genre;
import com.eller.mis507.searchcriteria.Rating;
import com.eller.mis507.utilities.WriteMovieToFile;

/**
 * 
 */

/**
 * @author sumit
 *
 */
public class TestWriteMovieToFile {
	
	private Movie fastandfuriousOne;
	private Movie fastandfuriousTwo;
	private final String moviesTextFile = "Movies.txt";
	private boolean writeOperationSuccessful = false;
	WriteMovieToFile writeMovieToFile = WriteMovieToFile.getInstance(moviesTextFile);
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
		
		PrintWriter pw = new PrintWriter("Movies.txt");
		pw.close();
		
		fastandfuriousOne =  new Movie("fastandfuriousOne", Genre.ACTION);
		fastandfuriousOne.addRating(Rating.FIVE);
		
		fastandfuriousTwo =  new Movie("fastandfuriousTwo", Genre.ACTION);
		fastandfuriousTwo.addRating(Rating.FOUR);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		PrintWriter pw = new PrintWriter("Movies.txt");
		pw.close();
		assertTrue(writeMovieToFile.finish());
	}

	@Test
	public void testWrite() {
		writeOperationSuccessful = writeMovieToFile.write(fastandfuriousOne);
		assertTrue(writeOperationSuccessful);
		writeOperationSuccessful = writeMovieToFile.write(fastandfuriousTwo);
		assertTrue(writeOperationSuccessful);
	}

}
