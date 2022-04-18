package hh.swd20.moviedb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.moviedb.domain.Movie;
import hh.swd20.moviedb.domain.MovieRepository;

public class RestController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping(value="/movies")
    public @ResponseBody List<Movie> MovieListRest() {	
        return (List<Movie>) movieRepository.findAll();
    }    

	
	@GetMapping(value="/Movies/{id}")
    public @ResponseBody Optional<Movie> findBookRest(@PathVariable("id") Long MovieId) {	
    	return movieRepository.findById(MovieId);
    }      

}
