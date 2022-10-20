package com.proiect.mrc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proiect.mrc.dao.ClientDAO;
import com.proiect.mrc.entity.Client;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	
	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	public List<Client> getClients() {
		return clientDAO.getClients();
	}

	@Override
	public Client getClient(int theId) {
		return clientDAO.getClient(theId);
	}

	@Override
	public void saveClient(Client theClient) {
		clientDAO.saveClient(theClient);		
	}

	@Override
	public void deleteClient(int theId) {
		clientDAO.deleteClient(theId);
	}

}
