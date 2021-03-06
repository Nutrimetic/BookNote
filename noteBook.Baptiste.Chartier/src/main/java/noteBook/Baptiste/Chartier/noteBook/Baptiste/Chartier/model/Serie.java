package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Serie {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=255, unique=true)
	private String nom;
	
	@ManyToOne(optional=false)
	Auteur auteur;
	
	@OneToMany
	List<Book> listBook;

	public Serie() {
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

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}
	
	
}
