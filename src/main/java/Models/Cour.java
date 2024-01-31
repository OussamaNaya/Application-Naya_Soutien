package Models;

import java.util.List;

public class Cour {
	int id;
	String nom;
	String niveau;
	String matiere;
	int heur;
	String dateD;
	String dateF;
	int prix;
	
	public Cour() {
		// TODO Auto-generated constructor stub
	}


    
	public Cour(int id, String nom, String niveau, String matiere, int heur, String dateD, String dateF, int prix) {
		this.id = id;
		this.nom = nom;
		this.niveau = niveau;
		this.matiere = matiere;
		this.heur = heur;
		this.dateD = dateD;
		this.dateF = dateF;
		this.prix = prix;
	}
	
	public Cour(int id, String nom, String niveau, int heur, String dateD, String dateF, int prix) {
		this.id = id;
		this.nom = nom;
		this.niveau = niveau;
		this.heur = heur;
		this.dateD = dateD;
		this.dateF = dateF;
		this.prix = prix;
	}

	
	public Cour(Cour c) {
		this.id = c.id;
		this.nom = c.nom;
		this.niveau = c.niveau;
		this.matiere = c.matiere;
		this.heur = c.heur;
		this.dateD = c.dateD;
		this.dateF = c.dateF;
		this.prix = c.prix;
	}

	

	/**
	 * @param id
	 * @param nom
	 * @param niveau
	 * @param heur
	 * @param dateD
	 * @param dateF
	 * @param prix
	 */
	



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


	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public String getMatiere() {
		return matiere;
	}


	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	
	public int getHeur() {
		return heur;
	}



	public void setHeur(int heur) {
		this.heur = heur;
	}



	public String getDateD() {
		return dateD;
	}



	public void setDateD(String dateD) {
		this.dateD = dateD;
	}



	public String getDateF() {
		return dateF;
	}



	public void setDateF(String dateF) {
		this.dateF = dateF;
	}



	public int getPrix() {
		return prix;
	}



	public void setPrix(int prix) {
		this.prix = prix;
	}







	
}
