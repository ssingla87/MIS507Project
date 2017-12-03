/**
 * 
 */
package com.eller.mis507.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.filter.FilterCriteria;
import com.eller.mis507.filter.FilterMovie;
import com.eller.mis507.filter.implementations.GenreStrategy;
import com.eller.mis507.filter.implementations.NameAndGenreStrategy;
import com.eller.mis507.filter.implementations.NameAndScoreStrategy;
import com.eller.mis507.filter.implementations.NameScoreAndGenreStrategy;
import com.eller.mis507.filter.implementations.NameStrategy;
import com.eller.mis507.filter.implementations.ScoreAndGenreStrategy;
import com.eller.mis507.filter.implementations.ScoreStrategy;
import com.eller.mis507.filter.interfaces.FilterMovieStrategy;
import com.eller.mis507.searchcriteria.Genre;
import com.eller.mis507.searchcriteria.Rating;

/**
 * @author sumit
 *
 */
public class TestFilterMovie {

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


	private List<Movie> moviesList;
	private List<Movie> filteredmoviesList;
	
	FilterCriteria fcName = new FilterCriteria ("TestMovie1");
	
	FilterCriteria genreActionFC = new FilterCriteria (Genre.ACTION);
	FilterCriteria genreAdvFC = new FilterCriteria (Genre.ADVENTURE);
	FilterCriteria genreComedyFC = new FilterCriteria (Genre.COMEDY);
	
	FilterCriteria scoreGreaterThanOneFC = new FilterCriteria (1.0);
	FilterCriteria scoreGreaterThanTwoFC = new FilterCriteria (2.0);
	FilterCriteria scoreGreaterThanThreeFC = new FilterCriteria (3.0);
	FilterCriteria scoreGreaterThanFourFC = new FilterCriteria (4.0);
	FilterCriteria scoreGreaterThanFiveFC = new FilterCriteria (5.0);
	
	FilterMovie filterbygenre = new FilterMovie(new GenreStrategy());
	FilterMovie filterbyname = new FilterMovie(new NameStrategy());
	FilterMovie filterbyscore = new FilterMovie(new ScoreStrategy());
	FilterMovie filterByNameAndGenre = new FilterMovie(new NameAndGenreStrategy());
	FilterMovie filterByScoreAndGenre = new FilterMovie(new ScoreAndGenreStrategy());
	FilterMovie filterByNameAndScore = new FilterMovie(new NameAndScoreStrategy());
	FilterMovie filterByNameScoreAndGenre = new FilterMovie(new NameScoreAndGenreStrategy());

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {	
		
		
		
		FilterCriteria genreAndScoreFC = new FilterCriteria (Genre.ACTION,2.0);
		
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
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

		
	@Test
	public void filterMovieByGenre() {			
		filteredmoviesList = filterbygenre.filter(genreActionFC, moviesList);
		assertTrue(filteredmoviesList.size() == 3);
	}
	
	@Test
	public void filterMovieByName() {			
		filteredmoviesList = filterbyname.filter(fcName, moviesList);
		assertTrue(filteredmoviesList.size() == 1);
	}
	
	
	@Test
	public void filterMovieByGenreAndScore() {	
		FilterCriteria fc = new FilterCriteria(Genre.ACTION, 4.0);
		filteredmoviesList = filterByScoreAndGenre.filter(fc, moviesList);
		assertTrue(filteredmoviesList.size() == 0);
	}
}
