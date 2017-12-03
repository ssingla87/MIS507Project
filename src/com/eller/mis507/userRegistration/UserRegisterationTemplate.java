package com.eller.mis507.userRegistration;

import java.util.List;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.entities.User;
import com.eller.mis507.exception.MoviesFileContainingOtherObjectsException;
import com.eller.mis507.exception.MoviesFileNotFoundException;

public abstract class UserRegisterationTemplate {
	
	abstract Movie findMovie(Movie movie, List<Movie> moviesList);
	
	abstract List<Movie> ReadAllMovies();
	
	abstract Movie RegisterUser(User user, Movie movieInTheSystem);
	
	abstract boolean updateMovieInSystem(Movie movieInTheSystem, List<Movie> moviesList);

	public final boolean register(User user, Movie movie) {
		
		Movie movieInTheSystem = null;
		List<Movie> moviesList = ReadAllMovies();
		
		if(null == moviesList || moviesList.isEmpty()) {
			return false;
		}
		
		movieInTheSystem = findMovie(movie, moviesList);
		if(null != movieInTheSystem) {			
			movieInTheSystem = RegisterUser(user, movieInTheSystem);
		} else
			return false;
		
		return updateMovieInSystem(movieInTheSystem, moviesList);
		
		
	}

}
