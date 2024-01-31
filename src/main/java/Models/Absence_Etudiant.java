package Models;

public class Absence_Etudiant extends Absence{
	Etudiant le;

	
	
	

	public Absence_Etudiant(int id, String date, Etudiant le) {
		super(id, date);
		this.le = le;
	}

	public Absence_Etudiant(Absence_Etudiant abcE) {
		super(abcE);
		this.le = abcE.le;
	}

	public Etudiant getLe() {
		return le;
	}

	public void setLe(Etudiant le) {
		this.le = le;
	}

	
}
