package Models;

public class Paiment {
	int id;
	String date;

	
	

	public Paiment() {
	}
	public Paiment(int id, String date) {
		this.id = id;
		this.date = date;
	}
	public Paiment(Paiment p) {
		this.id = p.id;
		this.date = p.date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
