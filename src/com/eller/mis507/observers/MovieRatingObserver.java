package com.eller.mis507.observers;

import java.util.List;

import com.eller.mis507.entities.Movie;

public interface MovieRatingObserver {
	
	// method to update the observer, used by subject
	public void updateObserver();
	
	// attach with subject to observe
	public void setMovieToObserve(Movie movie);

}
