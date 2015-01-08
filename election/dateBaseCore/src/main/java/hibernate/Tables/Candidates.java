package hibernate.Tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table (name = "candidates")
public class Candidates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) @Column (name="id")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="firsname")
	private String firstname;	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column (name="surname")
	private String surname;
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	//@ManyToOne()
	@Column (name = "zip_codes_id")
	private int zip_codes_id;
	public int getZip_codes_id() {
		return zip_codes_id;
	}
	public void setZip_codes_id(int zip_codes_id) {
		this.zip_codes_id = zip_codes_id;
	}
}
