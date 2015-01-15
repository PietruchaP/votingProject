package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "zip_codes")
public class ZipCodes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) @Column (name="id")
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column (name ="zip_code")
	private String zipCodes;
	
	public String getZipCodes() {
		return zipCodes;
	}
	public void setZipCodes(String zipCodes) {
		this.zipCodes = zipCodes;
	}
	
}
