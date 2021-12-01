package com.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@NamedQuery(name="q1",query="from Employe")
public class Employe implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="emp_name")
	private String nom;
	
	@Column(name="emp_address")
	private String adresse;
	
	@Column(name="emp_mobile_nos")
	private String tel;
	
	public Employe() {
		
	}
		
	public Employe(int id, String nom, String adresse, String tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", tel=" + tel + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
