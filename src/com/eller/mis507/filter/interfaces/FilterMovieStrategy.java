package com.eller.mis507.filter.interfaces;

import java.util.List;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.filter.FilterCriteria;

public interface FilterMovieStrategy {

	public List<Movie> filter(FilterCriteria criteria, List<Movie> moviesList);
}
