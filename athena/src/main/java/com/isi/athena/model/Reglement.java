package com.isi.athena.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Reglement")
public class Reglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String NumReg;

    private double MontantReg;

    @Temporal(TemporalType.DATE)
    private Date DateReglement;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "TypeReg")
    private TypeReglement TypeReg;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "Facture")
    private Facture Facture;
}
