package hibernate.Tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "voters")
public class Voters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) @Column (name="id")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column (name="pesel")
	private String pesel;
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	@Column (name = "zip_codes_id")
	private int zip_codes_id;
	public int getZip_codes_id() {
		return zip_codes_id;
	}
	public void setZip_codes_id(int zip_codes_id) {
		this.zip_codes_id = zip_codes_id;
	}
	
}
