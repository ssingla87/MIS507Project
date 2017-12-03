package com.eller.mis507.test;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eller.mis507.entities.Audience;
import com.eller.mis507.entities.Movie;
import com.eller.mis507.entities.User;
import com.eller.mis507.exception.MoviesFileContainingOtherObjectsException;
import com.eller.mis507.exception.MoviesFileNotFoundException;
import com.eller.mis507.filter.FilterCriteria;
import com.eller.mis507.filter.FilterMovie;
import com.eller.mis507.filter.implementations.NameStrategy;
import com.eller.mis507.searchcriteria.Genre;
import com.eller.mis507.searchcriteria.Rating;
import com.eller.mis507.searchcriteria.UserType;
import com.eller.mis507.userRegistration.UserRegisterationFromTheFile;
import com.eller.mis507.userRegistration.UserRegisterationTemplate;
import com.eller.mis507.utilities.ReadMoviesFromFile;
import com.eller.mis507.utilities.WriteMovieToFile;

public class TestUserRegisterationForMovieUpdates {
	
	static User sumit;
	static User aditya;
	private static WriteMovieToFile writeMovieToFile;
	private static Movie fastandfuriousOne;
	private static String moviesTextFile = "Movies.txt";
	private static Movie fastandfuriousTwo;
	private static Movie fastandfuriousThree;
	
	static UserRegisterationTemplate userRegisterationTemplate;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		PrintWriter pw = new PrintWriter(moviesTextFile);
		pw.close();
		
		
		sumit = new Audience("Sumit", "Singla", "sumitsingla18@gmail.com", UserType.CRITIQUE);
		aditya = new Audience("Aditya", "Rege", "acdcfanman15@gmail.com", UserType.CRITIQUE);
		
		writeMovieToFile = WriteMovieToFile.getInstance(moviesTextFile);	
		fastandfuriousOne =  new Movie("fastandfuriousOne", Genre.ACTION);
		writeMovieToFile.write(fastandfuriousOne);
		
		fastandfuriousTwo =  new Movie("fastandfuriousTwo", Genre.ACTION);
		writeMovieToFile.write(fastandfuriousTwo);
		
		fastandfuriousThree =  new Movie("fastandfuriousThree", Genre.ACTION);
		
		userRegisterationTemplate = new UserRegisterationFromTheFile(moviesTextFile);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PrintWriter pw = new PrintWriter(moviesTextFile);
		pw.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserRegisteration() {
		
		boolean userSuccessfullyRegistered;
		userSuccessfullyRegistered = userRegisterationTemplate.register(sumit,fastandfuriousOne);
		assertTrue(userSuccessfullyRegistered);
	}
	
	@Test
	public void testUserRegisterationForNonExistingMovie() {
		
		boolean userSuccessfullyRegistered;
		userSuccessfullyRegistered = userRegisterationTemplate.register(sumit,fastandfuriousThree);
		assertFalse(userSuccessfullyRegistered);
	}
	
	//fetch the movie from data base and update the rating, which would
	//trigger the email to observers
	@Test
	public void testUserNotification() {
		List<Movie> fileMovieList = null;
		try {
			fileMovieList = ReadMoviesFromFile.getInstance(moviesTextFile).readAll(moviesTextFile);
		} catch (MoviesFileNotFoundException | MoviesFileContainingOtherObjectsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(null != fileMovieList) {
			FilterMovie filterbyname = new FilterMovie(new NameStrategy());
			FilterCriteria fc = new FilterCriteria("fastandfuriousOne");
			fileMovieList = filterbyname.filter(fc, fileMovieList);
			for (Movie movie: fileMovieList) {
				movie.addRating(Rating.ONE);
			}
			
		}
	}
	

}
