package hh.swd20.moviedb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.moviedb.domain.User;
import hh.swd20.moviedb.domain.UserRepository;
import hh.swd20.moviedb.domain.Genre;
import hh.swd20.moviedb.domain.GenreRepository;
import hh.swd20.moviedb.domain.Movie;
import hh.swd20.moviedb.domain.MovieRepository;

@SpringBootApplication
public class MoviedbApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MoviedbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviedbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner movieDemo(MovieRepository repository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			log.info("save genres");
			Genre genre1 = new Genre("Action");
			grepository.save(genre1);
			Genre genre2 = new Genre("Adventure");
			grepository.save(genre2);
			Genre genre3 = new Genre("Drama");
			grepository.save(genre3);
			Genre genre4 = new Genre("Comedy");
			grepository.save(genre4);
			Genre genre5 = new Genre("Fantasy");
			grepository.save(genre5);
			Genre genre6 = new Genre("Horror");
			grepository.save(genre6);
			Genre genre7 = new Genre("Mystery");
			grepository.save(genre7);
			Genre genre8 = new Genre("Romance");
			grepository.save(genre8);
			Genre genre9 = new Genre("Thriller");
			grepository.save(genre9);
			Genre genre10 = new Genre("Western");
			grepository.save(genre10);
			Genre genre11 = new Genre("Music");
			grepository.save(genre11);
			
			log.info("save movies");
			repository.save(new Movie("The Perks of Being a Wallflower", "Stephen Chbosky", "Emma Watson", "An introvert freshman is taken under the wings of two seniors who welcome him to the real world.", 2012, genre3));
            repository.save(new Movie("La La Land", "Damien Chazelle", "Ryan Gosling", 
            		"While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.", 2016, genre11));
			
            User user1 = new User("user", "$2a$10$LbARqawTc2arTWVSwFxtuurzMFHoGtn.SfO5LFHtCO/Zqfe7PGdzi", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
            
			log.info("fetch all movies");
			for (Movie movie : repository.findAll()) {
				log.info(movie.toString());
}
			
			log.info("fetch all categories");
			for (Genre genre : grepository.findAll()) {
				log.info(genre.toString());
			}

		};
	}
}