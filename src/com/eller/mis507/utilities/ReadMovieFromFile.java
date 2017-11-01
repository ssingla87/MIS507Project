/**
 * 
 */
package com.eller.mis507.utilities;

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
public class ReadMovieFromFile {

	public List<Movie> readAll(String string) throws MoviesFileNotFoundException, MoviesFileContainingOtherObjectsException{
		// TODO Auto-generated method stub
		List<Movie> moviesList = new ArrayList<Movie>();
		try {
			FileInputStream fi = new FileInputStream(new File(string));
			ObjectInputStream oi = new ObjectInputStream(fi);
			while(true) {
				if(oi.readObject() instanceof Movie)
					moviesList.add((Movie)oi.readObject());
				else
					throw new MoviesFileContainingOtherObjectsException(string+ " file containing other data than movies object");
			}
			
		}	catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new MoviesFileNotFoundException(string+ " file not found");
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
