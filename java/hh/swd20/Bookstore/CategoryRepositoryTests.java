package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.CategoryRepository;


//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class CategoryRepositoryTests {

	@Autowired
	private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> cat = repository.findByName("Fantasy");
        
        assertThat(cat).hasSize(1);
        assertThat(cat.get(0).getName()).isEqualTo("Fantasy");
    }
    
    @Test
    public void createNewCategory() {
    	Category cat = new Category("Action");
    	repository.save(cat);
    	assertThat(cat.getId()).isNotNull();
    } 
}
	
