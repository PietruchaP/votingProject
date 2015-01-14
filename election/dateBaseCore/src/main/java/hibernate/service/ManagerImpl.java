package hibernate.service;

import javax.transaction.Transactional;

import hibernate.dao.Zip_CodesDAO;
import hibernate.model.Zip_Codes;

public class ManagerImpl implements Manager{

	Zip_CodesDAO zipCodeDAO;
	public void setCustomerDAO(Zip_CodesDAO zipCodeDAO) {
        this.zipCodeDAO = zipCodeDAO;
    }
	
	@Override
	@Transactional
	public void insertZipCode(Zip_Codes zipCode) {
		zipCodeDAO.create(zipCode);	
	}

	@Override
	@Transactional
	public void retriveZipCode(Zip_Codes zipCode) {
		zipCodeDAO.retrive(zipCode.getId());	
	}

	@Override
	@Transactional
	public void updateZipCode(Zip_Codes zipCode) {
		zipCodeDAO.update(zipCode);
	}

	@Override
	@Transactional
	public void deleteZipCode(Zip_Codes zipCode) {
		zipCodeDAO.delete(zipCode.getId());	
	}

	
	
	
}
