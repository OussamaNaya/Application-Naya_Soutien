package Models;

public class Absence_Enseignant extends Absence{
   Enseignant lens;
	
	
   

	public Absence_Enseignant(int id, String date, Enseignant lens) {
		super(id, date);
		this.lens = lens;
	}
	
	public Absence_Enseignant(Absence_Enseignant abcE) {
		super(abcE);
		this.lens = abcE.lens;
	}

	public Enseignant getLens() {
		return lens;
	}

	public void setLens(Enseignant lens) {
		this.lens = lens;
	}

	

}
