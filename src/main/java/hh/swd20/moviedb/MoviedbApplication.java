package hh.swd20.moviedb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.moviedb.domain.Movie;
import hh.swd20.moviedb.domain.MovieRepository;

@SpringBootApplication
public class MoviedbApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MoviedbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviedbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner movieDemo(MovieRepository repository) {
		return (args) -> {
			log.info("save a couple of movies");
			repository.save(new Movie("The Perks of Being a Wallflower", "Stephen Chbosky", "Emma Watson", "An introvert freshman is taken under the wings of two seniors who welcome him to the real world.", 2012));
            repository.save(new Movie("La La Land", "Damien Chazelle", "Ryan Gosling", 
            		"While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.", 2016));
			
			log.info("fetch all books");
			for (Movie movie : repository.findAll()) {
				log.info(movie.toString());
			}

		};
	}

		
		
	}


