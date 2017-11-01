/**
 * 
 */
package com.eller.mis507.interfaces;

import java.util.List;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.searchcriteria.Rating;

/**
 * @author sumit
 *
 */
public interface ISearchMovie {
	
	public List<Movie> searchWithRating();
	
	public List<Movie> searchWithRating(Rating rating);

}
