package hh.swd20.Pelikirjasto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Pelikirjasto.domain.CategoryRepository;
import hh.swd20.Pelikirjasto.domain.Peli;
import hh.swd20.Pelikirjasto.domain.PeliRepository;

@CrossOrigin
@Controller
public class PeliController {
		
	
	@Autowired
	private PeliRepository repository;
		
	@Autowired
	private CategoryRepository catrep;
	
		@RequestMapping("/")
		public @ResponseBody String hello() {
			return "Hello Spring";
		}
		
		   @RequestMapping(value="/pelit", method = RequestMethod.GET)
		    public @ResponseBody List<Peli> PeliListRest() {	
		        return (List<Peli>) repository.findAll();
		    }
		    
			// REST to get peli by id
		    @RequestMapping(value="/pelit/{id}", method = RequestMethod.GET)
		    public @ResponseBody Optional<Peli> findPeliRest(@PathVariable("id") Long peliId) {	
		    	return repository.findById(peliId);
		    }      
		    // REST to save new peli
		    @RequestMapping(value="/pelit", method = RequestMethod.POST)
		    public @ResponseBody Peli savePeliRest(@RequestBody Peli peli) {	
		    	return repository.save(peli);
		    }
		    
		    
		
		
		
		
		//LIST
	@RequestMapping("/pelilist")
	public String getPelit(Model model) {
		model.addAttribute("pelit", repository.findAll());

		return "pelilist";

	}
	
	
		
		
		//ADD
		@RequestMapping(value = "/add")
		public String addPeli(Model model) {
			model.addAttribute("peli", new Peli());
			model.addAttribute("categories", catrep.findAll());

			return "addpeli";
		}
		
		
		
		//SAVE
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(Peli peli) {
			repository.save(peli);
			return "redirect:pelilist";
		}
		
		//DELETE
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)	 
		   @PreAuthorize("hasRole('ADMIN')")
		public String deletePeli(@PathVariable("id") Long peliId, Model model) {
			repository.deleteById(peliId);
			return "redirect:../pelilist";
		}
		
		//EDIT
		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		public String editPeli(@PathVariable("id") Long peliId, Model model) {
			model.addAttribute("peli", repository.findById(peliId).get());
			model.addAttribute("categories", catrep.findAll());
			return "editpeli";
		}
}
