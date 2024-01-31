package Models;

import java.util.List;

public class Etudiant {
	int id;
	String nom;
	String prenom;
	String gmail;
	String genre;
	String tele;
	String tele_parente;
	String login;
	String pass;
	List<Cour> lc;
	Paquite p;
	Groupe g;
	
	

	
	public Etudiant() {
	}

	
	public Etudiant(int id,String nom, String prenom, String gmail, String genre, String tele, String tele_parente,
			 String login, String pass) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.gmail = gmail;
		this.genre = genre;
		this.tele = tele;
		this.tele_parente = tele_parente;
		this.login = login;
		this.pass = pass;
		this.p = null;
		this.g = null;
	}

    
	
	
	/**
	 * @param login
	 * @param pass
	 */
	public Etudiant(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}


	public Etudiant(int id, String nom, String prenom, String gmail, String genre, String tele,
			String tele_parente, String login, String pass, Paquite p,
			Groupe g) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.gmail = gmail;
		this.genre = genre;
		this.tele = tele;
		this.tele_parente = tele_parente;
		this.login = login;
		this.pass = pass;
		this.p = p;
		this.g = g;
	}


	public Etudiant(Etudiant e)
	{
		this.id = e.id;
		this.nom = e.nom;
		this.prenom = e.prenom;
		this.gmail = e.gmail;
		this.genre = e.genre;
		this.tele = e.tele;
		this.tele_parente = e.tele_parente;
		this.p = p;
		this.g = g;
		this.login = e.login;
		this.pass = e.pass;
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

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getTele_parente() {
		return tele_parente;
	}

	public void setTele_parente(String tele_parente) {
		this.tele_parente = tele_parente;
	}

	public Paquite getP() {
		return p;
	}

	public void setP(Paquite p) {
		this.p = p;
	}

	public Groupe getG() {
		return g;
	}

	public void setG(Groupe g) {
		this.g = g;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Cour> getLc() {
		return lc;
	}


	public void setLc(List<Cour> lc) {
		this.lc = lc;
	}
	
	


	

	
}
