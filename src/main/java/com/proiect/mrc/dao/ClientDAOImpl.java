package com.proiect.mrc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proiect.mrc.entity.Client;

//gets checked
//get checked
//post checked
//put checked
//delete 

@Repository
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Client> getClients() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Client> theQuery = currentSession.createQuery("from Client", Client.class);

		List<Client> clients = theQuery.getResultList();
		
		return clients;
	}

	@Override
	public Client getClient(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Client theClient = currentSession.get(Client.class, theId);	
		
		return theClient;

	}

	@Override
	public void saveClient(Client theClient) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theClient);
	}

	@Override
	public void deleteClient(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Client> theQuery = currentSession.createQuery(
				"delete from Client where id=:clientId");
		
		theQuery.setParameter("clientId",theId);
		
		theQuery.executeUpdate();

	}

}
