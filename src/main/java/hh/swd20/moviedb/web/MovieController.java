package hh.swd20.moviedb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import hh.swd20.moviedb.domain.Movie;
import hh.swd20.moviedb.domain.MovieRepository;

@Controller
public class MovieController {
	
	@RequestMapping(value={"/", "/index"})
	public String indexSecure() {
		return "index";
	}  
    
    
    @RequestMapping(value="/login")
	public String login() {
		return "login";
	}    
	
    
	@Autowired
	private MovieRepository repository;
	@RequestMapping(value="/movielist", method=RequestMethod.GET)
	public String Movies(Model model) {
		model.addAttribute("movies", repository.findAll());
	    return "movielist";
	   
	    }
	 
	@RequestMapping(value = "/add")
	public String addmovie(Model model) {
		model.addAttribute("movie", new Movie());
		return "addmovie";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Movie movie) {
		repository.save(movie);
		return "redirect:movielist";

	}
	
	@RequestMapping(value = "/edit{id}", method = RequestMethod.GET)
	public String editmovie(@PathVariable("id") Long movieId, Model model) {
		model.addAttribute("movie", repository.findById(movieId));
        return "editmovie";
	}      
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletemovie(@PathVariable("id") Long movieId, Model model) {
    	repository.deleteById(movieId);
        return "redirect:../movielist";
}
	
}
	
