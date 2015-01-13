package hibernate.service;

import hibernate.model.Zip_Codes;

public interface Manager {
	public void insertZipCode(Zip_Codes zipCode);
	public void retriveZipCode(Zip_Codes zipCode);
	public void updateZipCode(Zip_Codes zipCode);
	public void deleteZipCode(Zip_Codes zipCode);
}
