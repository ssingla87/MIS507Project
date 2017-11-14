package com.eller.mis507.test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.searchcriteria.Genre;
import com.eller.mis507.searchcriteria.Rating;

@RunWith(Suite.class)
@SuiteClasses({ TestWriteMovieToFile.class, TestReadMovieFromFile.class })
public class ReadWriteSuite {
	
	private Movie fastandfuriousOne;
	private Movie fastandfuriousTwo;
	private final String moviesTextFile = "Movies.txt";
	private boolean writeOperationSuccessful = false;

	/*@BeforeClass
	public void setUp() throws FileNotFoundException {
		System.out.println("Runs before all tests in the annotation above.");
		PrintWriter pw = new PrintWriter("Movies.txt");
		pw.close();
		
		fastandfuriousOne =  new Movie("fastandfuriousOne", Genre.ACTION);
		fastandfuriousOne.addRating(Rating.FIVE);
		
		fastandfuriousTwo =  new Movie("fastandfuriousTwo", Genre.ACTION);
		fastandfuriousTwo.addRating(Rating.FOUR);

	}

	@AfterClass
	public void tearDown() throws FileNotFoundException {
		System.out.println("Runs after all tests in the annotation above.");
		PrintWriter pw = new PrintWriter("Movies.txt");
		pw.close();
	}*/

}
