package com.proiect.mrc.dao;

import java.util.List;

import com.proiect.mrc.entity.Client;

public interface ClientDAO {

	public List<Client> getClients();

	public Client getClient(int theId);

	public void saveClient(Client theClient);

	public void deleteClient(int theId);

}
