package com.eller.mis507.filter.implementations;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.filter.FilterCriteria;
import com.eller.mis507.filter.interfaces.FilterMovieStrategy;

public class NameAndScoreStrategy implements FilterMovieStrategy {

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> filter(FilterCriteria criteria, List<Movie> moviesList) {
		// TODO Auto-generated method stub
		CollectionUtils.filter(moviesList, new Predicate() {

		    @Override
		    public boolean evaluate(Object o) {
		        return ((Movie) o).getScore() >= criteria.getScore() && ((Movie) o).getName() == criteria.getName();
		    }

		});
		return moviesList;
	}

}
