package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByEmail(String email);
}
