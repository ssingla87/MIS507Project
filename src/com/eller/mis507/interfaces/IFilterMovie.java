/**
 * 
 */
package com.eller.mis507.interfaces;

import java.util.List;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.searchcriteria.Genre;
import com.eller.mis507.searchcriteria.Rating;

/**
 * @author sumit
 *
 */
public interface IFilterMovie {
	
	public List<Movie> filterWithScore(List<Movie> moviesList, double score);
	
	public List<Movie> filterWithGenre(List<Movie> moviesList, Genre genre);
	
	public List<Movie> filterWithName(List<Movie> moviesList, String name);

}
