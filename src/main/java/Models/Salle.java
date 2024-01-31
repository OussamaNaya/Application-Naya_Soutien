package Models;

import java.util.List;

public class Salle {
	int id;
	String nom;
	int capacite;
	List<Cour> lc;
	
	
	public Salle() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Salle(int id, String nom, int capacite) {
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
	}



	public Salle(int id,String nom, int capacite,List<Cour> lc) {
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
		this.lc = lc;
	}
	
	public Salle(Salle s) {
		this.id = s.id;
		this.nom = s.nom;
		this.capacite = s.capacite;
		this.lc = s.lc;
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

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public List<Cour> getLc() {
		return lc;
	}

	public void setLc(List<Cour> lc) {
		this.lc = lc;
	}

	
}
