package com.proiect.mrc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proiect.mrc.entity.Client;
import com.proiect.mrc.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientRestController {

	@Autowired
	private ClientService clientService;

	// getClients
	@GetMapping("/clients")
	public List<Client> getClients() {

		return clientService.getClients();

	}

	// getClient
	@GetMapping("/clients/{clientId}")
	public Client getClient(@PathVariable int clientId) {

		Client theClient = clientService.getClient(clientId);

		return theClient;
	}

	// addClient
	@PostMapping("/clients")
	public Client addClient(@RequestBody Client theClient) {

		theClient.setId(0);

		clientService.saveClient(theClient);

		return theClient;

	}

	// updateClient
	@PutMapping("/clients")
	public Client updateClient(@RequestBody Client theClient) {

		clientService.saveClient(theClient);

		return theClient;

	}

	// deleteClient
	@DeleteMapping("/clients/{clientId}")
	public String deleteClient(@PathVariable int clientId) {

		Client tempClient = clientService.getClient(clientId);

		clientService.deleteClient(clientId);
		
		return "Deleted client with the id of " + clientId;

	}

}
