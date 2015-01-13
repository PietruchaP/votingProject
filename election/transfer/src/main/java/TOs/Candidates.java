package TOs;


public class Candidates {
	
	private int id;
	private String firstname;
	private String surname;	
	private Zip_Codes zipCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Zip_Codes getZipCode() {
		return zipCode;
	}
	public void setZipCode(Zip_Codes zip_Code ){
		zipCode = zip_Code;
	}
}
