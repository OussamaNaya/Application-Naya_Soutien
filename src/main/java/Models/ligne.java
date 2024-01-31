package Models;

import java.util.HashMap;
import java.util.Map;

public class ligne {
   int id;
   Groupe g;
   String jeur;
   Map<String,Cour> courses = new HashMap<>();

   
   
   public ligne(int id, Groupe g, String jeur) {
		this.id = id;
		this.g = g;
		this.jeur = jeur;
		this.courses = new HashMap<String, Cour>();
	}
	public ligne(int id, Groupe g, String jeur, Map<String, Cour> courses) {
		this.id = id;
		this.g = g;
		this.jeur = jeur;
		this.courses = courses;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Groupe getG() {
		return g;
	}
	public void setG(Groupe g) {
		this.g = g;
	}
	public String getJeur() {
		return jeur;
	}
	public void setJeur(String jeur) {
		this.jeur = jeur;
	}
	public Map<String, Cour> getCourses() {
		return courses;
	}
	public void setCourses(Map<String, Cour> courses) {
		this.courses = courses;
	}
   
   
}
