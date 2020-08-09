package com.isi.athena.dao;

import com.isi.athena.model.Categorie;
import com.isi.athena.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {



    @Query(value = "SELECT max(id) FROM Produit ",nativeQuery = true)
    int maxIdFromProduit();
}
