package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "zip_codes")
public class Zip_Codes {
	
	@Id
	@GeneratedValue @Column (name="id")
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column (name ="zip_code")
	private String zip_Codes;
	
	public String getZip_Codes() {
		return zip_Codes;
	}
	public void setZip_Codes(String zip_Codes) {
		this.zip_Codes = zip_Codes;
	}
	
}
