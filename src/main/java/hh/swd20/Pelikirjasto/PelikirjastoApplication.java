package hh.swd20.Pelikirjasto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Pelikirjasto.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class PelikirjastoApplication {
	private static final Logger log = LoggerFactory.getLogger(PelikirjastoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PelikirjastoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner peliTest(PeliRepository repository, CategoryRepository catrep) {
		return (args) -> {
			log.info("test");
			
			
			Category cat1 = new Category("FPS");
			catrep.save(cat1);
			Category cat2 = new Category("RPG");
			catrep.save(cat2);
			Category cat3 = new Category("MOBA");
			catrep.save(cat3);
			
			repository.save(new Peli("nimi", "teijö", 2005, 20, cat1));

			
			log.info("fetch all books");
			for (Peli peli : repository.findAll()) {
				log.info(peli.toString());
			}

		};
}
}