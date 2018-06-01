package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
	
	public Serie findByNom(String nom);
	public List<Serie> findByNomLike (String nom);
}
