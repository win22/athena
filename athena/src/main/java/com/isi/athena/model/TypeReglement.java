package com.isi.athena.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TypeReglement")

public class TypeReglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String libelle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Reglement> getReglementList() {
        return reglementList;
    }

    public void setReglementList(List<Reglement> reglementList) {
        this.reglementList = reglementList;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "TypeReg")
    private List<Reglement> reglementList;
}
