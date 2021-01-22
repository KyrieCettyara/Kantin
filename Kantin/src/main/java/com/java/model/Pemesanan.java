package com.java.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pemesanan_produk")
public class Pemesanan {
	@Id
	private int id_pemesanan;
	private int id_produk;
	private Integer id_user;
	private Date tanggal_pemesanan;
	private double jumlah_harga;
	private Integer status_bayar;
	private Integer status_produk;
	public int getId_pemesanan() {
		return id_pemesanan;
	}
	public void setId_pemesanan(int id_pemesanan) {
		this.id_pemesanan = id_pemesanan;
	}
	public int getId_produk() {
		return id_produk;
	}
	public void setId_produk(int id_produk) {
		this.id_produk = id_produk;
	}
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	public Date getTanggal_pemesanan() {
		return tanggal_pemesanan;
	}
	public void setTanggal_pemesanan(Date tanggal_pemesanan) {
		this.tanggal_pemesanan = tanggal_pemesanan;
	}
	public double getJumlah_harga() {
		return jumlah_harga;
	}
	public void setJumlah_harga(double jumlah_harga) {
		this.jumlah_harga = jumlah_harga;
	}
	public Integer getStatus_bayar() {
		return status_bayar;
	}
	public void setStatus_bayar(Integer status_bayar) {
		this.status_bayar = status_bayar;
	}
	public Integer getStatus_produk() {
		return status_produk;
	}
	public void setStatus_produk(Integer status_produk) {
		this.status_produk = status_produk;
	}
	
	
}
