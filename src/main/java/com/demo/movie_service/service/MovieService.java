package com.demo.movie_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.movie_service.dao.MovieRepository;
import com.demo.movie_service.dao.entity.MovieEntity;
import com.demo.movie_service.pojo.MoviePojo;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepo;
	
	public List<MoviePojo> getAllMovies(){
		List<MovieEntity> allMoviesEntity = movieRepo.findAll();
		List<MoviePojo> allMoviesPojo = new ArrayList<MoviePojo>();
		allMoviesEntity.forEach((eachMovieEntity) -> {
			MoviePojo moviePojo = new MoviePojo();
			BeanUtils.copyProperties(eachMovieEntity, moviePojo);
			allMoviesPojo.add(moviePojo);
		});
		return allMoviesPojo;
	}
	
	public MoviePojo getAMovie(int movieId) {
		Optional<MovieEntity> movieEntity = movieRepo.findById(movieId);
		MoviePojo moviePojo = null;
		if(movieEntity.isPresent()) {
			moviePojo = new MoviePojo();
			BeanUtils.copyProperties(movieEntity.get(), moviePojo);
		}
		return moviePojo;
	}
	
	public MoviePojo addMovie(MoviePojo moviePojo) {
		MovieEntity movieEntity = new MovieEntity();
		BeanUtils.copyProperties(moviePojo, movieEntity);
		movieRepo.saveAndFlush(movieEntity);
		moviePojo.setMovieId(movieEntity.getMovieId());
		return moviePojo;
	}
	
	public MoviePojo updateMovie(MoviePojo moviePojo) {
		MovieEntity movieEntity = new MovieEntity();
		BeanUtils.copyProperties(moviePojo, movieEntity);
		movieRepo.save(movieEntity);
		return moviePojo;
	}
	
	public void deleteMovie(int movieId) {
		movieRepo.deleteById(movieId);
	}
}
