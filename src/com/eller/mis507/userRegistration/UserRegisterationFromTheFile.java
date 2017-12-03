package com.eller.mis507.userRegistration;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import com.eller.mis507.entities.Movie;
import com.eller.mis507.entities.User;
import com.eller.mis507.exception.MoviesFileContainingOtherObjectsException;
import com.eller.mis507.exception.MoviesFileNotFoundException;
import com.eller.mis507.filter.FilterMovie;
import com.eller.mis507.filter.interfaces.FilterMovieStrategy;
import com.eller.mis507.utilities.ReadMoviesFromFile;
import com.eller.mis507.utilities.WriteMovieToFile;

public class UserRegisterationFromTheFile extends UserRegisterationTemplate {

	private String moviesTextFile;
	WriteMovieToFile writeMovieToFile;
	ReadMoviesFromFile readMoviesFromFile;

	public UserRegisterationFromTheFile(String moviesTextFile) {
		// TODO Auto-generated constructor stub
		this.moviesTextFile = moviesTextFile;
		this.writeMovieToFile = WriteMovieToFile.getInstance(this.moviesTextFile);
		this.readMoviesFromFile = ReadMoviesFromFile.getInstance(this.moviesTextFile);
	}

	@Override
	List<Movie> ReadAllMovies(){
		// TODO Auto-generated method stub
		try {
			return this.readMoviesFromFile.readAll(moviesTextFile);
		} catch (MoviesFileNotFoundException | MoviesFileContainingOtherObjectsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	Movie RegisterUser(User user, Movie movieInTheSystem) {
		// TODO Auto-generated method stub
		
		movieInTheSystem.register(user);
		user.setMovieToObserve(movieInTheSystem);
		
		return movieInTheSystem;
	}

	@Override
	Movie findMovie(Movie movie, List<Movie> moviesList) {
		// TODO Auto-generated method stub
		for (Movie movieInTheSystem : moviesList) {
			if (movieInTheSystem.getName().equals(movie.getName()) && movieInTheSystem.getGenre().equals(movie.getGenre())) {
				moviesList.remove(movieInTheSystem);
				return movieInTheSystem;
			}
		}
		return null;
	}

	@Override
	boolean updateMovieInSystem(Movie movieInTheSystem, List<Movie> moviesList) {
		// TODO Auto-generated method stub
		moviesList.add(movieInTheSystem);
		return RefreshFileSystem(moviesList);
	}
	
	private boolean RefreshFileSystem(List<Movie> moviesList) {
		boolean fileFlushed = cleanFile(this.moviesTextFile);		
		
		if(fileFlushed) {
			for (Movie movie : moviesList) {
				if(!this.writeMovieToFile.write(movie))
					return false;
			}			
		} else
			return false;
		return true;
	}

	private boolean cleanFile(String moviesTextFile) {
		// TODO Auto-generated method stub
		PrintWriter pw;
		try {
			pw = new PrintWriter(moviesTextFile);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}	

}
