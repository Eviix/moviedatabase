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

@SpringBootApplication
public class MoviedbApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MoviedbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviedbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner movieDemo(MovieRepository repository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of movies");
			repository.save(new Movie("The Perks of Being a Wallflower", "Stephen Chbosky", "Emma Watson", "An introvert freshman is taken under the wings of two seniors who welcome him to the real world.", 2012));
            repository.save(new Movie("La La Land", "Damien Chazelle", "Ryan Gosling", 
            		"While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.", 2016));
			
            User user1 = new User("user", "$2a$10$LbARqawTc2arTWVSwFxtuurzMFHoGtn.SfO5LFHtCO/Zqfe7PGdzi", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
            
			log.info("fetch all movies");
			for (Movie movie : repository.findAll()) {
				log.info(movie.toString());
			}

		};
	}

		
		
	}


