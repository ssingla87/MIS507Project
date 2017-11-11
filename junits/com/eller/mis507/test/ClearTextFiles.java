package com.eller.mis507.test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCollectionUtilsFilter.class, TestCreateMovie.class, TestReadMovieFromFile.class,
		TestFilterMovie.class, TestWriteMovieToFile.class })
public class ClearTextFiles {

	/*@BeforeClass
	public static void setUp() throws FileNotFoundException {
		System.out.println("Runs before all tests in the annotation above.");
		PrintWriter pw = new PrintWriter("Movies.txt");
		pw.close();

	}

	@AfterClass
	public static void tearDown() throws FileNotFoundException {
		System.out.println("Runs after all tests in the annotation above.");
		PrintWriter pw = new PrintWriter("Movies.txt");
		pw.close();
	}*/

}
