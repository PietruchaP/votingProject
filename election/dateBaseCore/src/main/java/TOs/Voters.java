package TOs;

public class Voters {
	
	private int id;
	private Zip_Codes zipCode;
	private String pesel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public Zip_Codes getZipCode() {
		return zipCode;
	}
	public void setZipCode(Zip_Codes zip_Code){
		zipCode = zip_Code;
	}
}
