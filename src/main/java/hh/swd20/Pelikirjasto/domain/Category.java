package hh.swd20.Pelikirjasto.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import hh.swd20.Pelikirjasto.domain.*;

@Entity
public class Category {
	


	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long catId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Peli> pelit;
	private String nimi;
	
	
	public Category() {
		
	}	

	
	public Category(String nimi) {
		super();
		this.nimi = nimi;
	}

	public Long getId() {
		return catId;
	}

	public void setId(Long id) {
		this.catId = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public List<Peli> getPeli(){
		return pelit;
	}

	public void setPelit(List<Peli> pelit) {
		this.pelit = pelit;
	}



	@Override
	public String toString() {
		return "Category [catId=" + catId + ", nimi=" + nimi + "]";
	}
	
}
