package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Auteur;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	Book findByTitre(String titre);
	
	List<Book> findByAuteur (Auteur auteur);
}
