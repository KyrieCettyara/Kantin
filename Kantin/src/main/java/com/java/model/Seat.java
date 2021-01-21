package com.java.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 	
@Entity
@Table(name = "tempat_duduk")
public class Seat {
	@Id
	private int id_seat;
	private String no_seat;
	private int id_user;
	private int status;
	private Date waktu_pemesanan;
	private Date waktu_expired;
	public int getId_seat() {
		return id_seat;
	}
	public void setId_seat(int id_seat) {
		this.id_seat = id_seat;
	}
	public String getNo_seat() {
		return no_seat;
	}
	public void setNo_seat(String no_seat) {
		this.no_seat = no_seat;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getWaktu_pemesanan() {
		return waktu_pemesanan;
	}
	public void setWaktu_pemesanan(Date waktu_pemesanan) {
		this.waktu_pemesanan = waktu_pemesanan;
	}
	public Date getWaktu_expired() {
		return waktu_expired;
	}
	public void setWaktu_expired(Date waktu_expired) {
		this.waktu_expired = waktu_expired;
	}
	
	

}
