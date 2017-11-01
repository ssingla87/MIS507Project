package com.eller.mis507.test;
import static org.junit.Assert.*;

import java.io.PrintWriter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.utilities.WriteMovieToFile;

/**
 * 
 */

/**
 * @author sumit
 *
 */
public class TestWriteMovieToFile {
	
	Movie fastandfuriousOne;

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
		
		fastandfuriousOne =  new Movie("fastandfuriousOne");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		PrintWriter pw = new PrintWriter("Movies.txt");
		pw.close();
	}

	@Test
	public void test() {
		WriteMovieToFile writeMovieToFile = new WriteMovieToFile();
		writeMovieToFile.write(fastandfuriousOne);
	}

}
