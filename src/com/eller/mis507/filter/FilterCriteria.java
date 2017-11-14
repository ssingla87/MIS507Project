package com.eller.mis507.filter;

import com.eller.mis507.searchcriteria.Genre;

public class FilterCriteria {

	private Genre genre;
	private String name;
	private double score;

	public double getScore() {
		// TODO Auto-generated method stub
		return this.score;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public Genre getGenre() {
		// TODO Auto-generated method stub
		return this.genre;
	}

	public FilterCriteria(Genre genre) {
		super();
		this.genre = genre;
	}

	public FilterCriteria(String name) {
		super();
		this.name = name;
	}

	public FilterCriteria(double score) {
		super();
		this.score = score;
	}

	public FilterCriteria(Genre genre, String name) {
		super();
		this.genre = genre;
		this.name = name;
	}

	public FilterCriteria(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}

	public FilterCriteria(Genre genre, double score) {
		super();
		this.genre = genre;
		this.score = score;
	}

	public FilterCriteria(Genre genre, String name, double score) {
		super();
		this.genre = genre;
		this.name = name;
		this.score = score;
	}

}
