package hibernate.Tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn (name = "zip_codes_id")
	private Zip_Codes zipCode;
	public Zip_Codes getZip_Code() {
		return zipCode;
	}
	public void setZip_Code(Zip_Codes zipCode){
		this.zipCode = zipCode;
	}
}
