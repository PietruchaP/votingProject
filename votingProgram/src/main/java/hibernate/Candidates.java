package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Table (name = "candidates")
public class Candidates {
	
	@Id
	@GeneratedValue @Column (name="id")
	private int id;
	
	@Column(name="firsname")
	private String firsname;
	@Column (name="surname")
	private String surname;
	@Column (name = "zip_codes_id")
	private int zip_codes_id;
	
}
