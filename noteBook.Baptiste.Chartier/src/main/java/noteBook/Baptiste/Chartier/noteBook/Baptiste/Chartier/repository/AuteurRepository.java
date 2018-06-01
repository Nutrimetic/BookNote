package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Auteur;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {

	public Auteur findByNom(String nom);
	public List<Auteur> findByNomLike(String nom);
}
