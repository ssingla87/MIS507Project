/**
 * 
 */
package com.eller.mis507.utilities;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.exception.MoviesFileContainingOtherObjectsException;
import com.eller.mis507.exception.MoviesFileNotFoundException;

/**
 * @author sumit
 *
 */
public class ReadMoviesFromFile {
	
	private static ReadMoviesFromFile instance = null;
	
	FileInputStream fi;
	ObjectInputStream oi;

	private ReadMoviesFromFile(String fileName) {
		try {
			fi = new FileInputStream(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
			e.printStackTrace();
		}
		try {
			oi = new ObjectInputStream(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error initializing stream");
			e.printStackTrace();			
		}		
	}
	
	public static synchronized ReadMoviesFromFile getInstance(String fileName) {
		if (instance == null)
			instance = new ReadMoviesFromFile(fileName);

		return instance;
	}
	

	public List<Movie> readAll(String fileName) throws MoviesFileNotFoundException, MoviesFileContainingOtherObjectsException{
		// TODO Auto-generated method stub
		boolean fileContainsObjects = true;
		List<Movie> moviesList = new ArrayList<Movie>();
		try {
			Object movieFromFile;
			fi = new FileInputStream(new File(fileName));
			oi = new ObjectInputStream(fi);
			while(fileContainsObjects ) {
				try{
					movieFromFile = oi.readObject();
					if(movieFromFile instanceof Movie)
						moviesList.add((Movie)movieFromFile);
					else
						throw new MoviesFileContainingOtherObjectsException(fileName+ " file containing other data than movies objects");
					
				} catch (EOFException e) {
					// TODO Auto-generated catch block
					fileContainsObjects = false;
				}
				
			}
			//oi.close(); //Since this is a singeleton class now
			System.out.println(moviesList);
			
		}	catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new MoviesFileNotFoundException(fileName+ " file not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moviesList;
		
	}

}
