package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "volters")
public class Volters {
	
	@Id
	@GeneratedValue @Column (name="id")
	private int id;
	@Column (name="pesel")
	private String pesel;
	@Column (name = "zip_codes_id")
	private int zip_codes_id;
	
}
