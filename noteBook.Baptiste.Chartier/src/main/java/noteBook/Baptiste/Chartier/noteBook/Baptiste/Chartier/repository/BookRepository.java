package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Auteur;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Book;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Serie;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	public Book findByTitre(String titre);
	public List<Book> findByAuteur (Auteur auteur);
	public List<Book> findByCollection (Serie collection);
	public List<Book> findByTitreLike(String titre);
}
