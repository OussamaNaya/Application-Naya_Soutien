package Models;

import java.util.List;

public class Paiement_Etudiant extends Paiment{
	Etudiant le;
	int id_e;
	
	
	
	public Paiement_Etudiant() {
		super();
	}

	public Paiement_Etudiant(int id, String date,Etudiant le,int id_e) {
		super(id, date);
		this.le = le;
		this.id_e = id_e;
	}
	
	public Paiement_Etudiant(Paiement_Etudiant pe) {
		super(pe);
		this.le = pe.le;
		this.id_e = pe.id_e;
	}

	public Etudiant getLe() {
		return le;
	}

	public void setLe(Etudiant le) {
		this.le = le;
	}

	public int getId_e() {
		return id_e;
	}

	public void setId_e(int id_e) {
		this.id_e = id_e;
	}
	
	
}
