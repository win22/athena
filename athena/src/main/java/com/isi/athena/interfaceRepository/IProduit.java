package com.isi.athena.interfaceRepository;

import com.isi.athena.model.Categorie;
import com.isi.athena.model.Produit;

import java.util.List;

public interface IProduit {

    public List<Produit> findAll();
    public List<Categorie> ListCategorie();
    public int getMaxIDfromProduit();
    public Produit addProduit(Produit P);

}
