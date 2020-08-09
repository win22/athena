package com.isi.athena.interfaceRepository;

import com.isi.athena.model.Client;
import com.isi.athena.model.User;

import java.util.List;
import java.util.Optional;

public interface IClient {
    public List<Client> findAll();
    public Client addClient(Client c);
    public int getMaxId();
    public Client updateClient(Client c);
    public void deleteClient(Client c);
    public Optional<Client> getClientByID(Long id);
    public List<String> lissCIN();

    public List<String> listUsername();
    public User addClientCompte(User u);

    public User login(String log);
}
