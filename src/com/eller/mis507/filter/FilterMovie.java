package com.eller.mis507.filter;

import java.util.List;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.filter.interfaces.FilterMovieStrategy;

public class FilterMovie {
	
	FilterMovieStrategy strategy;	
	
	public FilterMovie(FilterMovieStrategy strategy) {
		super();
		this.strategy = strategy;
	}

	public List<Movie> filter(FilterCriteria criteria, List<Movie> moviesList){
		
		return strategy.filter(criteria, moviesList);
		
	}

}
