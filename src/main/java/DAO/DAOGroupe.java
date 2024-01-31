package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Cour;
import Models.Groupe;
import Models.Salle;
import tools.DBInteraction;

public class DAOGroupe {
	public int CreeGroupe(Groupe g) throws ClassNotFoundException, SQLException
    {
		int nb = 0;
    	DBInteraction.connect();
        nb = DBInteraction.Maj("insert into groupe values(null,'"+g.getNom()+"','"+g.getNiveau()+"',"+g.getCapacite()+")");
    	DBInteraction.disconnect();
    	return nb;
    }
    public List<Groupe> All() throws ClassNotFoundException, SQLException
    {
    	List<Groupe> le = new ArrayList<Groupe>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from groupe");
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String niveau = rs.getString(3);
    		int capacite = rs.getInt(4);
    		le.add(new Groupe(id, nom, niveau, capacite));
    	}
    	DBInteraction.disconnect();
    	return le;
    }
    public List<Groupe> All_Niveau(String Niveau) throws ClassNotFoundException, SQLException
    {
    	List<Groupe> le = new ArrayList<Groupe>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from groupe where niveau = '"+Niveau+"'");
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String niveau = rs.getString(3);
    		int capacite = rs.getInt(4);
    		le.add(new Groupe(id, nom, niveau, capacite));
    	}
    	DBInteraction.disconnect();
    	return le;
    }
    public Groupe Find_ID(int Id) throws ClassNotFoundException, SQLException
    {
    	Groupe g = null;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from groupe where id = "+Id);
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String niveau = rs.getString(3);
    		int capacite = rs.getInt(4);
    		g = new Groupe(id, nom, niveau, capacite);
    	}
    	DBInteraction.disconnect();
    	return g;
    }
    public int Modifier(Groupe g1,Groupe g2) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
		nbr = DBInteraction.Maj("update groupe set nom='"+g2.getNom()+"',niveau='"+g2.getNiveau()+"',capacite="+g2.getCapacite()+" where id = "+g1.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }
    public int supprimer(Groupe g) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	nbr = DBInteraction.Maj("delete from groupe where id = "+g.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }
}
