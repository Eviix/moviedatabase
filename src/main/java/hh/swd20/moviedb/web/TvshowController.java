package hh.swd20.moviedb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.moviedb.domain.Tvshow;
import hh.swd20.moviedb.domain.TvshowRepository;

@Controller
public class TvshowController {
	
	@Autowired
	private TvshowRepository tvshowrepository;
	
	
	@RequestMapping(value="/tvshowlist", method=RequestMethod.GET)
	public String tvshows(Model model) {
		model.addAttribute("tvshows", tvshowrepository.findAll());
	    return "tvshowlist";
	   
	    }
	 
	@RequestMapping(value = "/addtvshow")
	public String addtvshow(Model model) {
		model.addAttribute("tvshow", new Tvshow());
		return "addtvshow";

	}

	@RequestMapping(value = "/savetvshow", method = RequestMethod.POST)
	public String save(Tvshow tvshow) {
		tvshowrepository.save(tvshow);
		return "redirect:tvshowlist";

	}
	
	@RequestMapping(value = "/tvshowedit{id}", method = RequestMethod.GET)
	public String edittvshow(@PathVariable("id") Long tvshowId, Model model) {
		model.addAttribute("tvshow", tvshowrepository.findById(tvshowId));
        return "edittvshow";
	}      
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletemovie(@PathVariable("id") Long tvshowId, Model model) {
    	tvshowrepository.deleteById(tvshowId);
        return "redirect:../tvshowlist";
}
	
}
