package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.repository.CustomerRepository;

@Transactional
@Repository
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	
}
