/**
 * 
 */
package com.eller.mis507.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.eller.mis507.searchcriteria.Genre;
import com.eller.mis507.searchcriteria.Rating;

/**
 * @author sumit
 *
 */
public class Movie implements Serializable {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -1720367423937504368L;

	private String name;
	private Genre genre;
	private List<Rating> ratings = new ArrayList<Rating>();
	private float Score;


	/**
	 * @param name
	 * 
	 */
	public Movie(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;

	}

	public Movie(String name, Genre genre) {
		super();
		this.name = name;
		this.genre = genre;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @return the score
	 */
	public float getScore() {
		return Score;
	}
	public void addRating(Rating rating) {
		// TODO Auto-generated method stub
		ratings.add(rating);
		//TODO - Observer pattern to update the rating
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie [name=" + name + ", genre=" + genre + ", Score=" + Score + "]";
	}

	
}
