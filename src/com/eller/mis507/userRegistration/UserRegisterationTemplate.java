package com.eller.mis507.userRegistration;

import java.util.List;

import com.eller.mis507.entities.Movie;

public abstract class UserRegisterationTemplate {
	
	abstract boolean checkMovie(String movieName);
	
	abstract List<Movie> ReadAllMovies();
	
	abstract List<Movie> FilterMovies(List<Movie> moviesList, String movieName);
	
	abstract boolean RegisterUser(String userName, List<Movie> moviesList);

	public final boolean register(String userName, String movieName) {
		
		List<Movie> moviesList = null;
		List<Movie> filteredMoviesList = null;
		
		boolean movieExists = checkMovie(movieName);
		if(movieExists) {
			moviesList = ReadAllMovies();
		}
		
		filteredMoviesList = FilterMovies(moviesList, movieName);
		
		return RegisterUser(userName, filteredMoviesList);
		
	}

}
