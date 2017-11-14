/**
 * 
 */
package com.eller.mis507.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.exception.MoviesFileContainingOtherObjectsException;
import com.eller.mis507.exception.MoviesFileNotFoundException;
import com.eller.mis507.utilities.ReadMoviesFromFile;

/**
 * @author sumit
 *
 */
public class TestReadMovieFromFile {
	
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

	@Test (expected = MoviesFileNotFoundException.class)
	public void ReadFromUnknownFile() throws MoviesFileNotFoundException, MoviesFileContainingOtherObjectsException{
		ReadMoviesFromFile readMoviesFromFile = new ReadMoviesFromFile();
		readMoviesFromFile.readAll("unkown.txt");
	}
	
	@Test
	public void ReadAllMoviesFromFile() throws MoviesFileNotFoundException, MoviesFileContainingOtherObjectsException{
		ReadMoviesFromFile readMoviesFromFile = new ReadMoviesFromFile();
		List<Movie> moviesList = readMoviesFromFile.readAll("Movies.txt");
		assertTrue(moviesList.size() == 2);
	}

}
