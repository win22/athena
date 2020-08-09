package com.isi.athena.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    private int qte;

    private String numero, libelle;

    private double prixNormal, prixMinimum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrixNormal() {
        return prixNormal;
    }

    public void setPrixNormal(double prixNormal) {
        this.prixNormal = prixNormal;
    }

    public double getPrixMinimum() {
        return prixMinimum;
    }

    public void setPrixMinimum(double prixMinimum) {
        this.prixMinimum = prixMinimum;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "categorie")
    private Categorie categorie;


}
