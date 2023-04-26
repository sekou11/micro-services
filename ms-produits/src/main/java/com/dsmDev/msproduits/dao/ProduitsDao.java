package com.dsmDev.msproduits.dao;

import com.dsmDev.msproduits.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitsDao extends JpaRepository<product, Integer> {
}
