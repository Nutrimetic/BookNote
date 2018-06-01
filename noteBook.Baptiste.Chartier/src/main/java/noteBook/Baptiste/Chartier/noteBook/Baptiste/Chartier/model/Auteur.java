package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Auteur {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column(nullable=false, length=255, unique=true)
	String nom;
	
	@Column(nullable=false, length=255)
	String prenom;
	
	@OneToMany
	List<Serie> listSerie;
	
	@OneToMany
	List<Book> listBook;
	
	public Auteur() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Serie> getListSerie() {
		return listSerie;
	}

	public void setListSerie(List<Serie> listSerie) {
		this.listSerie = listSerie;
	}

	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}
	
	
}
