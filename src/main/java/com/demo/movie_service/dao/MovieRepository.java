package com.demo.movie_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.movie_service.dao.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{

}
