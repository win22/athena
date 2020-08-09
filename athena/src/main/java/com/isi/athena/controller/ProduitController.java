package com.isi.athena.controller;


import com.isi.athena.model.Categorie;
import com.isi.athena.model.Produit;
import com.isi.athena.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@EnableAutoConfiguration
@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    private ProduitService ps;

    @PreAuthorize("hasAuthority('ROLE_CLIENT') or hasAuthority('ROLE_USER')")
    @GetMapping("/all")
    @CrossOrigin("*")
    public @ResponseBody
    List<Produit> listProduit(){
        return ps.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_CLIENT') or hasAuthority('ROLE_USER')")
    @GetMapping("/cat")
    @CrossOrigin("*")
    public @ResponseBody
    List<Categorie> listCatégorie(){
        System.out.println(ps.getMaxIDfromProduit());
        return ps.ListCategorie();
    }

}
