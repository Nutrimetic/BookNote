package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
