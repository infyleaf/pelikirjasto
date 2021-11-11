package hh.swd20.Pelikirjasto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hh.swd20.Pelikirjasto.domain.Category;

@Entity
public class Peli {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
	
		private String nimi;
		private String tekija;
		private double hinta;
		private int vuosi;
		


	    @ManyToOne //book -> manytoone category
	//    @JsonIgnoreProperties ("books") 
	    @JoinColumn(name = "catId")	// FK
		private Category category;
		
		public Peli(String nimi, String tekija, double hinta, int vuosi, Category category) {
			super();
			this.nimi = nimi;
			this.tekija = tekija;
			this.hinta = hinta;
			this.vuosi = vuosi;
			this.category = category;
		}
		
		public Peli() {
			
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		//categoriat
		
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		
		public String getNimi() {
			return nimi;
		}
		public void setNimi(String nimi) {
			this.nimi = nimi;
		}
		public String getTekija() {
			return tekija;
		}
		public void setTekija(String tekija) {
			this.tekija = tekija;
		}
		public double getHinta() {
			return hinta;
		}
		public void setHinta(double hinta) {
			this.hinta = hinta;
		}
		public int getVuosi() {
			return vuosi;
		}
		public void setVuosi(int vuosi) {
			this.vuosi = vuosi;
		}

		@Override
		public String toString() {
			return "Peli [nimi=" + nimi + ", tekija=" + tekija + ", hinta=" + hinta + ", vuosi=" + vuosi + "category=" + category.getNimi() +  "]";
		}
		
		
}
