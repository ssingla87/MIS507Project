/**
 * 
 */
package com.eller.mis507.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.eller.mis507.entities.Movie;

/**
 * @author sumit
 *
 */
public class WriteMovieToFile {

	public void write(Movie fastandfuriousOne) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream f = new FileOutputStream(new File("Movies.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(fastandfuriousOne);
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
