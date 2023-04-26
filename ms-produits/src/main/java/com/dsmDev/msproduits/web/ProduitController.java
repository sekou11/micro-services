package com.dsmDev.msproduits.web;

import com.dsmDev.msproduits.dao.ProduitsDao;
import com.dsmDev.msproduits.model.product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitsDao produitsDao;

    //affiche la liste des produits disponible
     @GetMapping("/")
    public List<product> listeProduits(){
       List<product> products= produitsDao.findAll();
        if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");
        return products;
    }

    //recupere un product par son Id
      @GetMapping(value = "/{id}")
    public Optional<product>recupererUnProduit(@PathVariable() int id){
         Optional <product> product = produitsDao.findById(id);
         if (! product.isPresent()) throw new ProductNotFoundException(" le produit avec l'id " + id +" n'existe pas ...." );
         return  product;
    }
}
