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
import com.eller.mis507.interfaces.ISearchMovie;
import com.eller.mis507.interfaces.implementations.SearchMovieByRating;
import com.eller.mis507.searchcriteria.Rating;

/**
 * @author sumit
 *
 */
public class TestSearchMovie {

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
	public void searchMovieByRating() {
		
		
		ISearchMovie searchMovie = new SearchMovieByRating();
		List<Movie> moviesListWithRatingFive = searchMovie.searchWithRating(Rating.FIVE);
		//assertThat(moviesListWithRatingFive, matcher);
		
	}

}
