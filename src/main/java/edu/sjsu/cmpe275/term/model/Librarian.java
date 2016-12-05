package edu.sjsu.cmpe275.term.model;
/**
 * @author Pratik
 *
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Librarian implements Serializable {
	private static final long serialVersionUID = 5865760835716664141L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIBRARIANID")
	private int librarianId;
	@Column(name = "UNIVERSITYID", unique = true)
	private int universityId;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "STATUS", nullable= false, columnDefinition= "boolean default false")
	private boolean status; //activation
	@Column(name = "ACTIVATIONCODE", nullable= false, length=5)
	private int activationCode;
	


	public Librarian() {
		super();
	}

	public Librarian(int librarianId, int universityId, String email, String firstName, String lastName,
			String password, boolean status, int activationCode) {
		super();
		this.librarianId = librarianId;
		this.universityId = universityId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.status = status;
		this.activationCode = activationCode;
	}

	public int getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(int librarianId) {
		this.librarianId = librarianId;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * @return the activationCode
	 */
	public int getActivationCode() {
		return activationCode;
	}

	/**
	 * @param activationCode the activationCode to set
	 */
	public void setActivationCode(int activationCode) {
		this.activationCode = activationCode;
	}
}
