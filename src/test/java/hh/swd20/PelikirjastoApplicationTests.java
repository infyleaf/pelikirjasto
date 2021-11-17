package hh.swd20;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Pelikirjasto.web.PeliController;
import hh.swd20.Pelikirjasto.web.CategoryController;


//@RunWith(SpringRunner.class) // JUnit4
@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
class PelikirjastoApplicationTests {
/*
	@Autowired
	private PeliController peliController;
	
	@Autowired
	private CategoryController categoryController;
	
	
	@Test
	public void contextLoads() {
	
	}
*/
}
