package hh.swd20.moviedb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.moviedb.web.DatabaseController;
import hh.swd20.moviedb.web.RestController;
import hh.swd20.moviedb.web.MovieController;
import hh.swd20.moviedb.web.TvshowController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MoviedbApplicationtests {

	@Autowired
	private DatabaseController databaseController;

	@Autowired
	private RestController restController;

	@Autowired
	private TvshowController tvshowController;

	@Autowired
	private MovieController movieController;


	@Test
	public void databaseControllerLoads() throws Exception {
		assertThat(databaseController).isNotNull();
	}

	@Test
	public void restControllerLoads() throws Exception {
		assertThat(restController).isNotNull();
	}

	@Test
	public void tvshowController() throws Exception {
		assertThat(tvshowController).isNotNull();
	}
	
	@Test
	public void movieControllerLoads() throws Exception {
		assertThat(movieController).isNotNull();
	}
	
	
	
}