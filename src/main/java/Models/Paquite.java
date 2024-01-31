package Models;
import java.util.List;

public class Paquite {
	int id;
	String nom;
	List<Etudiant> e;
	List<Cour> lc;
	List<Groupe> lg;
	
	public Paquite() {
		// TODO Auto-generated constructor stub
		this.e = null;
		this.lc = null;
		this.lg = null;
	}

    


	public Paquite(int id, String nom, List<Cour> lc) {
		this.id = id;
		this.nom = nom;
		this.lc = lc;
	}

	public Paquite(Paquite p) {
		this.id = p.id;
		this.e = p.e;
		this.lc = p.lc;
		this.lg = p.lg;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Etudiant> getE() {
		return e;
	}

	public void setE(List<Etudiant> e) {
		this.e = e;
	}

	public List<Cour> getLc() {
		return lc;
	}

	public void setLc(List<Cour> lc) {
		this.lc = lc;
	}

	public List<Groupe> getLg() {
		return lg;
	}

	public void setLg(List<Groupe> lg) {
		this.lg = lg;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	
}
