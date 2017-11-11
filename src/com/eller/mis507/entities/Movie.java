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
	private List<Rating> ratings;
	private double score;

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
		this.score = 0; //TODO
		ratings = new ArrayList<Rating>();
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
	public double getScore() {
		return score;
	}
	
	/**
	 * @param rating the score to set
	 */
	private void setScore(Rating rating) {
		//Score = rating;
		switch (rating) {
			case ONE:
				score = ((score*(ratings.size()-1) + 1))/ratings.size();
				break;
			case TWO:
				score = ((score*(ratings.size()-1) + 2))/ratings.size();
				break;
			case THREE:
				score = ((score*(ratings.size()-1) + 3))/ratings.size();
				break;
			case FOUR:
				score = ((score*(ratings.size()-1) + 4))/ratings.size();
				break;
			case FIVE:
				score = ((score*(ratings.size()-1) + 5))/ratings.size();
				break;
		
		}
	}
	
	public void addRating(Rating rating) {
		// TODO Auto-generated method stub
		ratings.add(rating);
		setScore(rating);
		//TODO - Observer pattern to update the Score
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie [name=" + name + ", genre=" + genre + ", Score=" + score + "]";
	}

	
}
