package hh.swd20.moviedb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.moviedb.domain.User;
import hh.swd20.moviedb.domain.UserRepository;
import hh.swd20.moviedb.domain.Movie;
import hh.swd20.moviedb.domain.MovieRepository;
import hh.swd20.moviedb.domain.Tvshow;
import hh.swd20.moviedb.domain.TvshowRepository;

@SpringBootApplication
public class MoviedbApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MoviedbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviedbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner movieDemo(MovieRepository movierepository, TvshowRepository tvshowrepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of movies");
			movierepository.save(new Movie("The Perks of Being a Wallflower", "Drama, Romance", "Stephen Chbosky", "Logan Lerman, Emma Watson, Ezra Miller", "An introvert freshman is taken under the wings of two seniors who welcome him to the real world.", 2012));
            movierepository.save(new Movie("La La Land", "Comedy, Drama, Music", "Damien Chazelle", "Ryan Gosling, Emma Stone, Rosemarie DeWitt", 
            		"While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.", 2016));
            movierepository.save(new Movie("WALL·E", "Animation, Adventure, Family", "Andrew Stantone", "Ben Burtt(voice), Elissa Knight(voice), Jeff Garlin(voice)", 
            		"In the distant future, a small waste-collecting robot inadvertently embarks on a space journey that will ultimately decide the fate of mankind.", 2008));
            
            log.info("save a couple of tv shows");
			
            tvshowrepository.save(new Tvshow("Breaking Bad", "Vince Gilligan", "Bryan Cranston, Aaron Paul, Anna Gunn", 5, "Ended","Crime, Drama, Thriller", 
					"A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.", 2008));
            
            tvshowrepository.save(new Tvshow("Game of Thrones", "David Benioff, D.B. Weiss", "Emilia Clarke, Peter Dinklage, Kit Harington", 8, "Ended","Action, Adventure, Drama", 
					"Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.", 2011));
            
            tvshowrepository.save(new Tvshow("The Boys", "Eric Kripke", "Karl Urban, Jack Quaid, Antony Starr", 2, "Ongoing","Action, Crime, Drama", 
					"A group of vigilantes set out to take down corrupt superheroes who abuse their superpowers.", 2019));
			
            User user1 = new User("user", "$2a$10$LbARqawTc2arTWVSwFxtuurzMFHoGtn.SfO5LFHtCO/Zqfe7PGdzi", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
            
			log.info("fetch all movies");
			for (Movie movie : movierepository.findAll()) {
				log.info(movie.toString());
			}
			
			log.info("fetch all tvshows");
			for (Tvshow tvshow : tvshowrepository.findAll()) {
				log.info(tvshow.toString());
			}

		};
	}

		
		
	}


