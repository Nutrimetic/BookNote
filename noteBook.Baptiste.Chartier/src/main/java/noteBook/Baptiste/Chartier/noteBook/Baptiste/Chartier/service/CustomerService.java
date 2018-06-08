package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Customer;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Role;

@Service
public interface CustomerService {

	public boolean verifierExistenceCustomer(String email);
	public Customer findCustomer(String email);
	public Customer saveCustomer(Customer nouveauCustomer);
	public void deleteCustomer(Customer customer);
	public List<Role> getListeRoleFromCustomer(String email);
}
