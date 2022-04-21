package hh.swd20.moviedb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.moviedb.domain.Movie;
import hh.swd20.moviedb.domain.MovieRepository;
import hh.swd20.moviedb.domain.Tvshow;
import hh.swd20.moviedb.domain.TvshowRepository;

public class RestController {

	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private TvshowRepository tvshowrepository;
	
	@GetMapping(value="/movies")
    public @ResponseBody List<Movie> MovieListRest() {	
        return (List<Movie>) movieRepository.findAll();
    }    

	
	@GetMapping(value="/Movies/{id}")
    public @ResponseBody Optional<Movie> findMovieRest(@PathVariable("id") Long MovieId) {	
    	return movieRepository.findById(MovieId);
    }      
	
	@GetMapping(value="/tvshows")
    public @ResponseBody List<Tvshow> TvshowListRest() {	
        return (List<Tvshow>) tvshowrepository.findAll();
    }    

	
	@GetMapping(value="/Tvshows/{id}")
    public @ResponseBody Optional<Tvshow> findTvshowRest(@PathVariable("id") Long TvshowId) {	
    	return tvshowrepository.findById(TvshowId);
    }      

}
