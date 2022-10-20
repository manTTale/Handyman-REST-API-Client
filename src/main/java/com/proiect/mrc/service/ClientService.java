package com.proiect.mrc.service;

import java.util.List;

import com.proiect.mrc.entity.Client;

public interface ClientService {

	public List<Client> getClients();

	public Client getClient(int theId);

	public void saveClient(Client theClient);

	public void deleteClient(int theId);

}
