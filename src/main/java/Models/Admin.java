package Models;

public class Admin {
	int id;
	String nom;
	String prenom;
	int age;
	String gmail;
	String genre;
	String tele;
	String login;
	String pass;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Admin(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}


	public Admin(int id, String nom, String prenom, int age, String gmail, String genre, String tele, String login,
			String pass) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.gmail = gmail;
		this.genre = genre;
		this.tele = tele;
		this.login = login;
		this.pass = pass;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Admin(String nom, String prenom, int age, String gmail, String genre, String tele, String login, String pass) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.gmail = gmail;
		this.genre = genre;
		this.tele = tele;
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


	Admin(Admin a)
	{
		this.nom = a.nom;
		this.prenom = a.prenom;
		this.age = a.age;
		this.gmail = a.gmail;
		this.genre = a.genre;
		this.tele = a.tele;
		this.login = login;
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

	@Override
	public String toString() {
		return "Admin [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", gmail=" + gmail + ", genre=" + genre
				+ ", tele=" + tele + "]";
	}
	
	
}
