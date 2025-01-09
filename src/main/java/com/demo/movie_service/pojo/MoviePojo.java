package com.demo.movie_service.pojo;

import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MoviePojo {
	private int movieId;
	
	@NotBlank
	private String movieTitle;
	
	@NotBlank
	private String movieLanguage;
	
	@NotNull
	private LocalDate movieReleaseDate;
	private String movieImageUrl;
}