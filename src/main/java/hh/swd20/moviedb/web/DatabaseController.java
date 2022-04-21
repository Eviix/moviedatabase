package hh.swd20.moviedb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.moviedb.domain.MovieRepository;
import hh.swd20.moviedb.domain.TvshowRepository;

@Controller
public class DatabaseController {
	
	@Autowired
	private MovieRepository movierepository;
	
	@Autowired
	private TvshowRepository tvshowrepository;
	
	@RequestMapping(value={"/", "/index"})
	public String indexSecure() {
		return "index";
	}  
    
    
    @RequestMapping(value="/login")
	public String login() {
		return "login";
	}    
	
	@RequestMapping(value="/database")
	public String database(Model model) {
		model.addAttribute("movies", movierepository.findAll());
		model.addAttribute("tvshows", tvshowrepository.findAll());
		return "database";
	}

}
