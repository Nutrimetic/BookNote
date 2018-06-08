package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, unique=true, length=255)
	String email;
	
	@Column(nullable=false, length=255)
	String password;
	
	@Column(nullable=false)
	boolean enable;

	@Column(nullable=false, length=255)
	private String firstName;
	
	@Column(nullable=false, length=255)
	private String lastName;
	
	@ManyToMany
	List<Role> listRole;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public List<Role> getListRole() {
		return listRole;
	}
	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
