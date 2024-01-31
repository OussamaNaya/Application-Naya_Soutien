package Models;

public class Directeur {
	int id;
	String nom;
	String prenom;
	int age;
	String login;
	String pass;
	
	public Directeur() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Directeur(int id, String nom, String prenom, int age, String login, String pass) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.login = login;
		this.pass = pass;
	}




	public Directeur(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}

	public Directeur(Directeur d) {
		this.nom = d.nom;
		this.prenom = d.prenom;
		this.age = d.age;
		this.login = d.login;
		this.pass = d.pass;
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

	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}




	@Override
	public String toString() {
		return "Directeur [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	} 
	
	
}
