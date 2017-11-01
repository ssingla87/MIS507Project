/**
 * 
 */
package com.eller.mis507.interfaces.implementations;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.interfaces.IFilterMovie;
import com.eller.mis507.searchcriteria.Genre;
import com.eller.mis507.searchcriteria.Rating;

/**
 * @author sumit
 *
 */
public class FilterMovies implements IFilterMovie {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> filterWithScore(List<Movie> moviesList, double score) {
		// TODO Auto-generated method stub
		CollectionUtils.filter(moviesList, new Predicate() {

		    @Override
		    public boolean evaluate(Object o) {
		        return ((Movie) o).getScore() >= score;
		    }

		});
		return moviesList;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> filterWithGenre(List<Movie> moviesList, Genre genre) {
		// TODO Auto-generated method stub
		CollectionUtils.filter(moviesList, new Predicate() {

		    @Override
		    public boolean evaluate(Object o) {
		        return ((Movie) o).getGenre() == genre;
		    }

		});
		return moviesList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> filterWithName(List<Movie> moviesList, String name) {
		// TODO Auto-generated method stub
		CollectionUtils.filter(moviesList, new Predicate() {

		    @Override
		    public boolean evaluate(Object o) {
		        return ((Movie) o).getName() == name;
		    }

		});
		return moviesList;
	}

}
