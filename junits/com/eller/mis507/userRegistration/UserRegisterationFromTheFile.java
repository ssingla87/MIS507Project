package com.eller.mis507.userRegistration;

import java.util.List;

import com.eller.mis507.entities.Movie;

public class UserRegisterationFromTheFile extends UserRegisterationTemplate {

	@Override
	boolean checkMovie(String movieName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	List<Movie> ReadAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<Movie> FilterMovies(List<Movie> moviesList, String movieName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean RegisterUser(String userName, List<Movie> moviesList) {
		// TODO Auto-generated method stub
		return false;
	}

}
