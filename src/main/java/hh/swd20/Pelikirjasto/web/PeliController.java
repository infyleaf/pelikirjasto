package hh.swd20.Pelikirjasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Pelikirjasto.domain.CategoryRepository;
import hh.swd20.Pelikirjasto.domain.Peli;
import hh.swd20.Pelikirjasto.domain.PeliRepository;

@CrossOrigin
@ResponseBody
@Controller
public class PeliController {
		
	
	@Autowired
	private PeliRepository repository;
		
	@Autowired
	private CategoryRepository catrep;
	
		@RequestMapping("*")
		public String hello() {
			return "Hello Spring";
		}
		
		//LIST
		@RequestMapping(value = "/pelilist")
		public String getPeli(Model model) {
			model.addAttribute("pelit", repository.findAll());
			
			return "pelilist";
		
		
	}
		//ADD
		@RequestMapping(value = "/add")
		public String addPeli(Model model) {
			model.addAttribute("peli", new Peli());
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
		public String deletePeli(@PathVariable("id") Long peliId, Model model) {
			repository.deleteById(peliId);
			return "redirect:../pelilist";
		}

}
