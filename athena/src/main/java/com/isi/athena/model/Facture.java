package com.isi.athena.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numero;

    private double MontantFacture;

    private int NombreTronche;

    private double ResteApayer;

    @JsonIgnore
    @OneToMany(mappedBy = "Facture")
    private List<Reglement> reglementList;

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

    public double getMontantFacture() {
        return MontantFacture;
    }

    public void setMontantFacture(double montantFacture) {
        MontantFacture = montantFacture;
    }

    public int getNombreTronche() {
        return NombreTronche;
    }

    public void setNombreTronche(int nombreTronche) {
        NombreTronche = nombreTronche;
    }

    public double getResteApayer() {
        return ResteApayer;
    }

    public void setResteApayer(double resteApayer) {
        ResteApayer = resteApayer;
    }

    public List<Reglement> getReglementList() {
        return reglementList;
    }

    public void setReglementList(List<Reglement> reglementList) {
        this.reglementList = reglementList;
    }
}
