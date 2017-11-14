/**
 * 
 */
package com.eller.mis507.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.eller.mis507.entities.Movie;

/**
 * @author sumit
 *
 */
public class WriteMovieToFile {

	private static WriteMovieToFile instance = null;

	FileOutputStream f;
	ObjectOutputStream o;

	private WriteMovieToFile(String fileName) {
		try {
			f = new FileOutputStream(new File(fileName), true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
			e.printStackTrace();
		}
		try {
			o = new ObjectOutputStream(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error initializing stream");
			e.printStackTrace();
		}
	}

	public static synchronized WriteMovieToFile getInstance(String fileName) {
		if (instance == null)
			instance = new WriteMovieToFile(fileName);

		return instance;
	}

	public boolean write(Movie movie) {
		// TODO Auto-generated method stub
		try {
			o.writeObject(movie);

		} catch (IOException e) {
			System.out.println("Error initializing stream");
			return false;
		}
		return true;
	}

	public boolean finish() {
		try {
			o.close();
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;

	}

}
