package hh.swd20.moviedb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.moviedb.web.UserDetailServiceImpl;
import hh.swd20.moviedb.web.DatabaseController;
import hh.swd20.moviedb.web.RestController;
import hh.swd20.moviedb.web.MovieController;
import hh.swd20.moviedb.web.TvshowController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MoviedbApplicationtests {

	@Autowired
	private DatabaseController databasecontroller;

	@Autowired
	private RestController restcontroller;

	@Autowired
	private TvshowController tvshowcontroller;

	@Autowired
	private MovieController moviecontroller;

	@Autowired
	private UserDetailServiceImpl userdetailserviceimpl;

	@Test
	public void databaseLoads() throws Exception {
		assertThat(databasecontroller).isNotNull();
	}

	@Test
	public void restcontrollerLoads() throws Exception {
		assertThat(restcontroller).isNotNull();
	}

	@Test
	public void tvshowcontrollerLoads() throws Exception {
		assertThat(tvshowcontroller).isNotNull();
	}
	
	@Test
	public void tvshowControllerLoads() throws Exception {
		assertThat(moviecontroller).isNotNull();
	}
	
	@Test
	public void userdetailserviceimplLoads() throws Exception {
		assertThat(userdetailserviceimpl).isNotNull();
	}
}