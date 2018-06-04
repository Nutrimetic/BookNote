package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Customer;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Role;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository.CustomerRepository;

@Transactional
@Repository
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public boolean verifierExistenceCustomer(String email) {
		Customer customer = customerRepository.findByEmail(email);
		if(customer == null){
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Customer findCustomer(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public Customer saveCustomer(Customer nouveauCustomer) {
		return customerRepository.save(nouveauCustomer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
}
