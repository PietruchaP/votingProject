package hibernate.service;

import hibernate.dao.Zip_CodesDAO;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service("service")
public class MainConnection {

	
	@Autowired
	private Zip_CodesDAO dao;
	
	
}
