package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.model.Produk;

@Repository
public interface ProdukRepository  extends JpaRepository<Produk, Integer>{
	@Modifying
	@Query(value = "UPDATE produk_kantin p SET p.stock = p.stock - :sell WHERE p.id_produk = :id", nativeQuery = true)
	void updateStockProduk(@Param(value = "id") int id, @Param(value = "sell") int sell);
	
	

}
