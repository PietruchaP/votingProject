package hibernate.Daos;

import hibernate.Tables.Elections;

import org.springframework.stereotype.Repository;

@Repository("electionsDao")
public class ElectionsDao extends GenericDaoImp<Elections> {

}
