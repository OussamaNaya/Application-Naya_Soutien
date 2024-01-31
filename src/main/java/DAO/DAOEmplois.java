package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout.Group;

import Models.Cour;
import Models.Emplois;
import Models.Etudiant;
import Models.Groupe;
import Models.Paiement_Etudiant;
import Models.ligne;
import tools.DBInteraction;

public class DAOEmplois {
	public List<Emplois> Emplois_By_Group(Groupe g) throws ClassNotFoundException, SQLException
    {
    	List<Emplois> le = new ArrayList<Emplois>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from emplois where id_groupe ="+g.getId());
    	DAOEmplois daoemp = new DAOEmplois();
    	DAOCour daoc = new DAOCour();
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		int id_groupe = rs.getInt(2);
    		String jeur = rs.getString(3);
    		int huit = rs.getInt(4);
    		int neuf = rs.getInt(5);
    		int dix = rs.getInt(6);
    		int entze = rs.getInt(7);
    		int deux = rs.getInt(8);
    		int trois = rs.getInt(9);
    		int quatre = rs.getInt(10);
    		int cinque = rs.getInt(11);
    		Map<String,Cour> courses = new HashMap<>();
    		courses.put("8:9", daoc.Find_ID(huit));
    		courses.put("9:10", daoc.Find_ID(neuf));
    		courses.put("10:11", daoc.Find_ID(dix));
    		courses.put("11:12", daoc.Find_ID(entze));
    		courses.put("2:3", daoc.Find_ID(deux));
    		courses.put("3:4", daoc.Find_ID(trois));
    		courses.put("4:5", daoc.Find_ID(quatre));
    		courses.put("5:6", daoc.Find_ID(cinque));
    		Emplois emplois = new Emplois(id, g, jeur, courses);
    		le.add(emplois);
    	}
    	DBInteraction.disconnect();
    	return le;
    }
	public int supprimer_where_Id_Groupe(Groupe g) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	DBInteraction.Maj("delete from  emplois  where id_groupe = "+g.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }
	
}
