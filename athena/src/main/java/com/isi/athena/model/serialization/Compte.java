package com.isi.athena.model.serialization;

import com.isi.athena.model.Client;
import com.isi.athena.model.User;

public class Compte {

    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public Compte() {
    }


}
