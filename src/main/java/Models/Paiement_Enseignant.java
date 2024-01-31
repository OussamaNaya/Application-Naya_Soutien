package Models;

import java.util.List;

public class Paiement_Enseignant extends Paiment{
	Enseignant lens;
	int id_e;
	
	
	public Paiement_Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Paiement_Enseignant(int id, String date,Enseignant lens,int id_e) {
		super(id,date);
		this.lens = lens;
		this.id_e = id_e;
	}
	
	public Enseignant getLens() {
		return lens;
	}

	public void setLens(Enseignant lens) {
		this.lens = lens;
	}

	public int getId_e() {
		return id_e;
	}

	public void setId_e(int id_e) {
		this.id_e = id_e;
	}

	public Paiement_Enseignant(Paiement_Enseignant pe) {
		super(pe);
		this.lens = pe.lens;
		this.id_e = pe.id_e;
	}

	public Enseignant getlens() {
		return lens;
	}

	public void setlens(Enseignant lens) {
		this.lens = lens;
	}

}
