package com.isi.athena.service;

import com.isi.athena.dao.CategorieRepository;
import com.isi.athena.dao.ClientRepository;
import com.isi.athena.dao.UserRepository;
import com.isi.athena.interfaceRepository.IClient;
import com.isi.athena.model.Client;
import com.isi.athena.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ClientService implements IClient {

    @Autowired
    private ClientRepository cr;

    @Autowired
    private UserRepository ur;

    @Override
    public List<Client> findAll() {
        return cr.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return cr.save(c);
    }

    @Override
    public int getMaxId() {
        try {
            return cr.maxIdFromClient();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }

    }

    @Override
    public Client updateClient(Client c) {
        return cr.save(c);
    }

    @Override
    public void deleteClient(Client c) {
        cr.delete(c);
    }

    @Override
    public Optional<Client> getClientByID(Long id) {
        try {
            return cr.findById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<String> lissCIN() {
        return cr.allCIN();
    }

    @Override
    public List<String> listUsername() {
        return cr.Usernames();
    }

    @Override
    public User addClientCompte(User u) {
        return ur.save(u);
    }

    @Override
    public User login(String log) {
        return ur.findByUsername(log);
    }
}
