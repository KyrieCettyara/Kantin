package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.model.Pemesanan;

@Repository
public interface PemesananRepository extends JpaRepository<Pemesanan, Integer>{
	@Modifying
	@Query(value = "UPDATE pemesanan_produk p SET p.status_bayar = 1 WHERE p.id_pemesanan = :id", nativeQuery = true)
	void updateStatusPemesanan(@Param(value = "id") int id);
	
	@Modifying
	@Query(value = "UPDATE pemesanan_produk p SET p.status_produk = :status WHERE p.id_pemesanan = :id", nativeQuery = true)
	void updateStatusProduk(@Param(value = "id") int id, @Param(value = "status") int status);
	
}
