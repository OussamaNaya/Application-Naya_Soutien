package Models;

import java.util.List;

public class Groupe {
	int id;
	String nom;
	String niveau;
	int capacite;
	Paquite p;
	List<Etudiant> le;
	Emplois emplois;
	List<Enseignant> lens;
	
	public Groupe() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Groupe(int id, String nom, String niveau, int capacite) {
		this.id = id;
		this.nom = nom;
		this.niveau = niveau;
		this.capacite = capacite;
	}


	public Groupe(int id, String nom, String niveau, int capacite, Paquite p, List<Etudiant> le, Emplois emplois,
			List<Enseignant> lens) {
		this.id = id;
		this.nom = nom;
		this.niveau = niveau;
		this.capacite = capacite;
		this.p = p;
		this.le = le;
		this.emplois = emplois;
		this.lens = lens;
	}



	public Groupe(Groupe g) {
		this.id = g.id;
		this.nom = g.nom;
		this.niveau = g.niveau;
		this.capacite = g.capacite;
		this.p = g.p;
		this.le = g.le;
		this.emplois = g.emplois;
		this.lens = g.lens;
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

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public Paquite getP() {
		return p;
	}

	public void setP(Paquite p) {
		this.p = p;
	}

	public List<Etudiant> getLe() {
		return le;
	}

	public void setLe(List<Etudiant> le) {
		this.le = le;
	}

	public Emplois getEmplois() {
		return emplois;
	}

	public void setEmplois(Emplois emplois) {
		this.emplois = emplois;
	}

	public List<Enseignant> getLens() {
		return lens;
	}

	public void setLens(List<Enseignant> lens) {
		this.lens = lens;
	}

	
}
