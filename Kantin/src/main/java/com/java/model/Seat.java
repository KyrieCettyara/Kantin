package com.java.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


 	
@Entity
@Table(name = "tempat_duduk")
public class Seat {
	@Id
	private int id_seat;
	private String no_seat;
	private Integer status;
	private Date waktu_pemesanan;
	@Column(name ="id_user")
	private Integer user;
	private Date waktu_expired;
	
	
	public Integer getUser() {
		return user;
	}
	public void setUser(Integer user) {
		this.user = user;
	}
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
	public int getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
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
