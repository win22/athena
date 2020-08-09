package com.isi.athena.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numeroCommande;

    private int etat;

    @Temporal(TemporalType.DATE)
    private Date DateCommande;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "Facture")
    private Facture facture;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDateCommande() {
        return DateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        DateCommande = dateCommande;
    }

}
