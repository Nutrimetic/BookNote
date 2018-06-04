package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Customer;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model.Role;
import noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@PutMapping("/add")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/get")
	public Customer getCustomer(@RequestParam String email) {
		return customerService.findCustomer(email);
	}
	
	@GetMapping("/getListeRole")
	public List<Role> getListeRole(@RequestParam String email) {
		return customerService.findCustomer(email).getListRole();
	}
	
	@DeleteMapping("/delete")
	public void deleteCustomer(@Valid @RequestBody Customer customer) {
		customerService.deleteCustomer(customer);
	}
	
	
}
