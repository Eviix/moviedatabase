package hh.swd20.moviedb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.moviedb.domain.Genre;
import hh.swd20.moviedb.domain.GenreRepository;

@Controller
public class GenreController {
	@Autowired
	private GenreRepository grepository;
	
	@RequestMapping("/genrelist")
	public String genrelist(Model model) {
		model.addAttribute("genres", grepository.findAll());
		return "genrelist";
	}
	
	@RequestMapping(value = "/addgenre")
	public String addgenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}
	
	@RequestMapping(value = "/savegenre", method = RequestMethod.POST)
	public String save(Genre genre) {
		grepository.save(genre);
		return "redirect:genrelist";

	}
}