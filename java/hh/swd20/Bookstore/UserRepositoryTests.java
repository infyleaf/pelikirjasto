package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class UserRepositoryTests {


	@Autowired
	private UserRepository repository;

    @Test
    public void findByUsernameShouldReturnUsername() {
        User user = repository.findByUsername("user");
        
    
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("HQ", "salasana", "päämies");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    } 
}
