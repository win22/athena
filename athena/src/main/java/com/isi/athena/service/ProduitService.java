package com.isi.athena.service;

import com.isi.athena.dao.CategorieRepository;
import com.isi.athena.dao.ProduitRepository;
import com.isi.athena.interfaceRepository.IProduit;
import com.isi.athena.model.Categorie;
import com.isi.athena.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ProduitService implements IProduit {

    @Autowired
    private ProduitRepository pr;

    @Autowired
    private CategorieRepository catr;

    @Override
    public List<Produit> findAll() {
        return pr.findAll();
    }

    @Override
    public List<Categorie> ListCategorie() {
        return catr.listCategorie();
    }

    @Override
    public int getMaxIDfromProduit() {
        try {
            return pr.maxIdFromProduit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public Produit addProduit(Produit P) {
        return pr.save(P);
    }
}
