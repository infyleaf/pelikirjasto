package hh.swd20.Pelikirjasto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByNimi(String nimi);
    
}