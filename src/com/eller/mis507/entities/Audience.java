package com.eller.mis507.entities;

import java.util.List;

import com.eller.mis507.observers.MovieRatingObserver;
import com.eller.mis507.searchcriteria.UserType;

public class Audience extends User {

	public Audience(String firstName, String lastName, String email, UserType usertype) {
		super(firstName, lastName, email, usertype);
		// TODO Auto-generated constructor stub
	}	

}
