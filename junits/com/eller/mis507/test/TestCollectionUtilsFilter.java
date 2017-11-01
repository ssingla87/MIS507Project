/**
 * 
 */
package com.eller.mis507.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.searchcriteria.Genre;
import com.eller.mis507.searchcriteria.Rating;
import com.eller.mis507.utilities.ReadMoviesFromFile;
import com.eller.mis507.utilities.WriteMovieToFile;

/**
 * @author sumit
 * 
 * Ignore this class for final Project
 *
 */
public class TestCollectionUtilsFilter {
	
	List<Movie> moviesList;

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
		Movie movie1 = new Movie("TestMovie1", Genre.ACTION);
		movie1.addRating(Rating.FIVE);
		movie1.addRating(Rating.ONE);
		movie1.addRating(Rating.FIVE);
		movie1.addRating(Rating.THREE);
		Movie movie2 = new Movie("TestMovie2", Genre.ADVENTURE);
		movie2.addRating(Rating.TWO);
		movie2.addRating(Rating.FIVE);
		movie2.addRating(Rating.THREE);
		movie2.addRating(Rating.FIVE);
		Movie movie3 = new Movie("TestMovie3", Genre.ACTION);
		movie3.addRating(Rating.ONE);
		movie3.addRating(Rating.TWO);
		movie3.addRating(Rating.THREE);
		movie3.addRating(Rating.FIVE);
		Movie movie4 = new Movie("TestMovie4", Genre.COMEDY);
		movie4.addRating(Rating.FOUR);
		movie4.addRating(Rating.FOUR);
		movie4.addRating(Rating.FIVE);
		movie4.addRating(Rating.FIVE);
		Movie movie5 = new Movie("TestMovie5", Genre.ACTION);
		movie5.addRating(Rating.ONE);
		movie5.addRating(Rating.THREE);
		movie5.addRating(Rating.FIVE);
		movie5.addRating(Rating.FIVE);
		
		moviesList = new ArrayList<Movie>();
		moviesList.add(movie1);
		moviesList.add(movie2);
		moviesList.add(movie3);
		moviesList.add(movie4);
		moviesList.add(movie5);
		
		System.out.println(moviesList);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void searchMovie() {
		
		System.out.println(moviesList);
		//WriteMovieToFile write = new WriteMovieToFile();
		
	}

}