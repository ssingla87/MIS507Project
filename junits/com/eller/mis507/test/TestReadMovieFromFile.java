/**
 * 
 */
package com.eller.mis507.test;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.exception.MoviesFileContainingOtherObjectsException;
import com.eller.mis507.exception.MoviesFileNotFoundException;
import com.eller.mis507.searchcriteria.Genre;
import com.eller.mis507.searchcriteria.Rating;
import com.eller.mis507.utilities.ReadMoviesFromFile;
import com.eller.mis507.utilities.WriteMovieToFile;

/**
 * @author sumit
 *
 */
public class TestReadMovieFromFile {
	
	private static Movie fastandfuriousOne;	
	static ReadMoviesFromFile readMoviesFromFile;
	
	private final static String moviesTextFile = "Movies.txt";
	private boolean writeOperationSuccessful = false;
	static WriteMovieToFile writeMovieToFile;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PrintWriter pw = new PrintWriter(moviesTextFile);
		pw.close();
		readMoviesFromFile = ReadMoviesFromFile.getInstance(moviesTextFile);
		writeMovieToFile = WriteMovieToFile.getInstance(moviesTextFile);
		
		fastandfuriousOne =  new Movie("fastandfuriousOne", Genre.ACTION);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PrintWriter pw = new PrintWriter(moviesTextFile);
		pw.close();
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
		/*PrintWriter pw = new PrintWriter(moviesTextFile);
		pw.close();*/
	}

	@Test (expected = MoviesFileNotFoundException.class)
	public void ReadFromUnknownFile() throws MoviesFileNotFoundException, MoviesFileContainingOtherObjectsException{
		readMoviesFromFile.readAll("unkown.txt");
	}
	
	@Test
	public void ReadAllMoviesFromFile() throws MoviesFileNotFoundException, MoviesFileContainingOtherObjectsException{
		writeOperationSuccessful = writeMovieToFile.write(fastandfuriousOne);
		assertTrue(writeOperationSuccessful);		
		List<Movie> moviesList = readMoviesFromFile.readAll(moviesTextFile);
		assertTrue(moviesList.size() == 1);
	}

}
