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


//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BookRepositoryTests {

	@Autowired
	private BookRepository repository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<Book> books = repository.findByTitle("Title");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Title");
    }
    
    @Test // testataan StudentRepositoryn save()-metodin toimivuutta
    public void createNewBook() {
    	Book book1 = new Book("Mickey", "Mouse", 0, "mm@mouse.com", 0, null);
    	repository.save(book1);
    	assertThat(book1.getId()).isNotNull();
    } 
	
}