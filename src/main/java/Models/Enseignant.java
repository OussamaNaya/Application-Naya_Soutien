package Models;

import java.util.List;

public class Enseignant {
	int id;
	String nom;
	String prenom;
	int age;
	String matiere;
	String gmail;
	String genre;
	String tele;
	List<Groupe> groupe;
	List<Cour> lc;
	boolean etatPaiement;
	boolean etatAbsence;
	String login;
	String pass;
	
	
	public Enseignant()
	{
		
	}
	

	
	/**
	 * @param login
	 * @param pass
	 */
	public Enseignant(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}



	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param gmail
	 * @param genre
	 * @param tele
	 * @param login
	 * @param pass
	 */
	public Enseignant(int id, String nom, String prenom, int age, String matiere, String genre, String tele, String login,
			String pass) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.matiere = matiere;
		this.genre = genre;
		this.tele = tele;
		this.login = login;
		this.pass = pass;
	}



	public Enseignant(int id,String nom, String prenom, int age, String matiere, String gmail, String genre, String tele,
			List<Groupe> groupe, List<Cour> lc, boolean etatPaiement, boolean etatAbsence) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.matiere = matiere;
		this.gmail = gmail;
		this.genre = genre;
		this.tele = tele;
		this.groupe = groupe;
		this.lc = lc;
		this.etatPaiement = etatPaiement;
		this.etatAbsence = etatAbsence;
	}

	public Enseignant(Enseignant en) {
		this.id = en.id;
		this.nom = en.nom;
		this.prenom = en.prenom;
		this.age = en.age;
		this.matiere = en.matiere;
		this.gmail = en.gmail;
		this.genre = en.genre;
		this.tele = en.tele;
		this.groupe = en.groupe;
		this.lc = en.lc;
		this.etatPaiement = en.etatPaiement;
		this.etatAbsence = en.etatAbsence;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public List<Groupe> getGroupe() {
		return groupe;
	}

	public void setGroupe(List<Groupe> groupe) {
		this.groupe = groupe;
	}

	public List<Cour> getLc() {
		return lc;
	}

	public void setLc(List<Cour> lc) {
		this.lc = lc;
	}

	public boolean isEtatPaiement() {
		return etatPaiement;
	}

	public void setEtatPaiement(boolean etatPaiement) {
		this.etatPaiement = etatPaiement;
	}

	public boolean isEtatAbsence() {
		return etatAbsence;
	}

	public void setEtatAbsence(boolean etatAbsence) {
		this.etatAbsence = etatAbsence;
	}



}
