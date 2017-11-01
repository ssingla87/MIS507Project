/**
 * 
 */
package com.eller.mis507.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.eller.mis507.searchcriteria.Rating;

/**
 * @author sumit
 *
 */
public class Movie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1720367423937504368L;
	private String name;

	private List<Rating> ratings = new ArrayList<Rating>();
	/**
	 * @param name 
	 * 
	 */
	public Movie(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void addRating(Rating rating) {
		// TODO Auto-generated method stub
		
		ratings.add(rating);		
	}
	
	
	


}
