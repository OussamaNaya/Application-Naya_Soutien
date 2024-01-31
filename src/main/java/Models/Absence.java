package Models;

public class Absence {
	int id;
	String date;

	/**
	 * @param id
	 */
	public Absence(int id,String date) {
		this.id = id;
		this.date = date;
	}
    
	public Absence(Absence abs) {
		this.id = abs.id;
		this.date = abs.date;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
