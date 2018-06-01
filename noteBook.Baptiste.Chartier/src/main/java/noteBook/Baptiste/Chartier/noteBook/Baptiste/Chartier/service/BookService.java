package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Auteur;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Book;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Serie;

@Service
public interface BookService {

	public Book addBook(Book book, Auteur auteur, Optional<Serie> serie);
	public Book getBook(String titre);
	public List<Book> getBookFromFilter(String PartieDeTitre);
	public List<Book> getBookFromAuteur(Auteur auteur);
	public List<Book> getBookFromNomAuteur(String nomAuteur);
	public List<Book> getBookFromSerie(Serie serie);
	public List<Book> getBookFromNomSerie(String nomSerie);
	public List<Book> getAllBook();
	
	public Auteur getAuteur(String nomAuteur);
	public List<Auteur> getAuteurFromFilter (String partieNomAuteur);
	public Auteur getAuteurFromBook(String bookTitre);
	public Auteur getAuteurFromSerie(Serie serie);
	public List<Auteur> getAllAuteur();
	
	public Serie getSerieFromNom(String nomSerie);
	public List<Serie> getSerieFromFilter (String partieNomSerie);
	public Serie getSerieFromBook(String bookTitre);
	public List<Serie> getSerieFromAuteur (Auteur auteur);
	
	public Book updateBook(Book book, Book nouveauBook);
	public Auteur updateAuteur(Auteur auteur, Auteur nouveauAuteur);
	public Serie updateSerie(Serie serie, Serie nouvelleSerie);
	
	public void deleteBook(Book book);
	public void deleteBook(String titre);
	public void deleteSerie(Serie serie); //n'est valable que dans le cas ou aucun livre n'est rattaché à la série
	public void deleteSerie(String nomSerie);
	public void deleteAuteur(Auteur auteur); //n'est valable que dans le cas ou aucun livre et aucune série n'est rattaché à l'auteur
	public void deleteAuteur(String nomAuteur);
	
}
