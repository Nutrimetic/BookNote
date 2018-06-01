package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Auteur;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Book;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Serie;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository.AuteurRepository;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository.BookRepository;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository.SerieRepository;

@Repository
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuteurRepository auteurRepository;
	
	@Autowired
	private SerieRepository serieRepository;

	@Override
	public Book addBook(Book book, Auteur auteur, Optional<Serie> serie) {
		
		if(serie.isPresent()) {
			if(this.getAuteur(auteur.getNom()) != null) { //l'auteur existe déja en base
				if(serieRepository.findByNom(serie.get().getNom()) != null) { //la série existe déja en base
					serie.get().setAuteur(auteur);
					book.setAuteur(auteur);
					book.setCollection(serie.get());
					return bookRepository.save(book);
				} else { // la série n'existe pas en base
					serie.get().setAuteur(auteur);
					book.setAuteur(auteur);
					book.setCollection(serie.get());
					serieRepository.save(serie.get());
					return bookRepository.save(book);
				}
			} else { // l'auteur n'existe pas en base (de fait, la série et le livre non plus)
				serie.get().setAuteur(auteur);
				book.setAuteur(auteur);
				book.setCollection(serie.get());
				auteurRepository.save(auteur);
				serieRepository.save(serie.get());
				return bookRepository.save(book);
			}
		} else { //le livre ne fais pas partie d'une série
			if(this.getAuteur(auteur.getNom()) != null) { //l'auteur existe déja en base
				book.setAuteur(auteur);
				return bookRepository.save(book);
			} else { //l'auteur n'existe pas en base
				book.setAuteur(auteur);
				serieRepository.save(serie.get());
				return bookRepository.save(book);
			}
		}
	}

	@Override
	public Book getBook(String titre) {
		return bookRepository.findByTitre(titre);
	}

	@Override
	public List<Book> getBookFromAuteur(Auteur auteur) {
		return bookRepository.findByAuteur(auteur);
	}

	@Override
	public List<Book> getBookFromSerie(Serie serie) {
		return bookRepository.findByCollection(serie);
	}

	@Override
	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	@Override
	public Auteur getAuteur(String nomAuteur) {
		return auteurRepository.findByNom(nomAuteur);
	}

	@Override
	public Auteur getAuteurFromBook(String bookTitre) {
		return bookRepository.findByTitre(bookTitre).getAuteur();
	}

	@Override
	public Auteur getAuteurFromSerie(Serie serie) {
		return serie.getAuteur();
	}

	@Override
	public List<Auteur> getAllAuteur() {
		return auteurRepository.findAll();
	}

	@Override
	public Serie getSerieFromBook(String bookTitre) {
		return bookRepository.findByTitre(bookTitre).getCollection();
	}

	@Override
	public List<Serie> getSerieFromAuteur(Auteur auteur) {
		return auteur.getListSerie();
	}

	@Override
	public List<Book> getBookFromFilter(String PartieDeTitre) {
		return bookRepository.findByTitreLike(PartieDeTitre);
	}

	@Override
	public List<Auteur> getAuteurFromFilter(String partieNomAuteur) {
		return auteurRepository.findByNomLike(partieNomAuteur);
	}

	@Override
	public Serie getSerieFromNom(String nomSerie) {
		return serieRepository.findByNom(nomSerie);
	}

	@Override
	public List<Serie> getSerieFromFilter(String partieNomSerie) {
		return serieRepository.findByNomLike(partieNomSerie);
	}

	@Override
	public List<Book> getBookFromNomAuteur(String nomAuteur) {
		return auteurRepository.findByNom(nomAuteur).getListBook();
	}

	@Override
	public List<Book> getBookFromNomSerie(String nomSerie) {
		return serieRepository.findByNom(nomSerie).getListBook();
	}

	@Override
	public Book updateBook(Book book, Book nouveauBook) {
		
		Book bookInDataBase = this.getBook(book.getTitre());
		bookInDataBase.setAuteur(nouveauBook.getAuteur());
		bookInDataBase.setCollection(nouveauBook.getCollection());
		bookInDataBase.setId(nouveauBook.getId());
		
		return bookRepository.save(bookInDataBase);
	}

	@Override
	public Auteur updateAuteur(Auteur auteur, Auteur nouveauAuteur) {
		
		Auteur auteurInDataBase = auteurRepository.findByNom(auteur.getNom());
		auteurInDataBase.setListBook(nouveauAuteur.getListBook());
		auteurInDataBase.setListSerie(nouveauAuteur.getListSerie());
		auteurInDataBase.setNom(nouveauAuteur.getNom());
		auteurInDataBase.setPrenom(nouveauAuteur.getPrenom());
		auteurInDataBase.setId(nouveauAuteur.getId());
		
		return auteurRepository.save(auteurInDataBase);
	}

	@Override
	public Serie updateSerie(Serie serie, Serie nouvelleSerie) {
		
		Serie serieInDataBase = serieRepository.findByNom(serie.getNom());
		serieInDataBase.setAuteur(nouvelleSerie.getAuteur());
		serieInDataBase.setListBook(nouvelleSerie.getListBook());
		serieInDataBase.setNom(nouvelleSerie.getNom());
		serieInDataBase.setId(nouvelleSerie.getId());
		
		return serieRepository.save(serieInDataBase);
	}

	@Override
	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}

	@Override
	public void deleteBook(String titre) {
		bookRepository.delete(bookRepository.findByTitre(titre));
	}

	@Override
	public void deleteSerie(Serie serie) {
		serieRepository.delete(serie);
	}

	@Override
	public void deleteSerie(String nomSerie) {
		serieRepository.delete(serieRepository.findByNom(nomSerie));
	}

	@Override
	public void deleteAuteur(Auteur auteur) {
		auteurRepository.delete(auteur);
	}

	@Override
	public void deleteAuteur(String nomAuteur) {
		auteurRepository.delete(auteurRepository.findByNom(nomAuteur));
	}
}
