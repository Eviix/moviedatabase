package hh.swd20.moviedb;

	
	import static org.assertj.core.api.Assertions.assertThat;

	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.springframework.test.context.junit.jupiter.SpringExtension;

	import hh.swd20.moviedb.domain.User;
	import hh.swd20.moviedb.domain.UserRepository;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

	@ExtendWith(SpringExtension.class)
	@DataJpaTest
	public class UserRepositoryTest {
		
		@Autowired
		private UserRepository urepository;
		
		@Test
		public void createNewUser() {
			User user = new User("testuser", "$2a$10$Xeh2yIAIZxTK0smH6Ct1UOeblzLjuMBqG0JoS8RJ1w8x0qBX5gUHy", "USER");
			urepository.save(user);
			assertThat(user.getId()).isNotNull();
		}
		
		@Test
		public void deleteUser() {
			assertThat(urepository.findById((long) 1)).isNotEmpty();
			urepository.deleteById((long) 1);
			assertThat(urepository.findById((long) 1)).isEmpty();
		}
		
		@Test
		public void findUserByUsername() {
			User user = urepository.findByUsername("admin");
			assertThat(user.getRole()).isEqualTo("ADMIN");
		}

	}


