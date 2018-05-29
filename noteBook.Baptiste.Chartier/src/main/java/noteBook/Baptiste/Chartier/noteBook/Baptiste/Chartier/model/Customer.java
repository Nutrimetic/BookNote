package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, unique=true, length=255)
	String email;
	
	@Column(nullable=false, length=255)
	String MotDePasse;

	@Column(nullable=false, length=255)
	private String firstName;
	
	@Column(nullable=false, length=255)
	private String lastName;
	
	public Customer() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
