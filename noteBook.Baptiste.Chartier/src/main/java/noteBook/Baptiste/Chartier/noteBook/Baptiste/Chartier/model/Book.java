package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=255, unique=true)
	private String titre;
	
	@ManyToOne(optional=true)
	private Serie collection;
	
	@ManyToOne(optional=false)
	private Auteur auteur;
	
	public Book() {
		super();
	}
	public Book(Long id, String titre, Serie collection, Auteur auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.collection = collection;
		this.auteur = auteur;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Serie getCollection() {
		return collection;
	}
	public void setCollection(Serie collection) {
		this.collection = collection;
	}
	public Auteur getAuteur() {
		return auteur;
	}
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	
}
