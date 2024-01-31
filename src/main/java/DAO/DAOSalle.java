package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Cour;
import Models.Enseignant;
import Models.Salle;
import tools.DBInteraction;

public class DAOSalle {
	
	public boolean CreeSalle(Salle s) throws ClassNotFoundException, SQLException
    {
		int nb = 0;
    	DBInteraction.connect();
    	if(s.getLc() == null)
    	{
        	nb = DBInteraction.Maj("insert into salle values(null,"+s.getCapacite()+",null,'"+s.getNom()+"')");

    	}
    	else {
    		 for (Cour c : s.getLc()) {
    	         nb = DBInteraction.Maj("insert into salle values(null,"+s.getCapacite()+","+c.getId()+",'"+s.getNom()+"')");
			}
    	}
    	//DBInteraction.Maj("update utilisateur set etat = 0 where idU = "+u.getIdU());
    	if(nb != 0)
    	{
    		return true;
    	}
    	DBInteraction.disconnect();
    	return false;
    }
    public List<Salle> All() throws ClassNotFoundException, SQLException
    {
    	List<Salle> le = new ArrayList<Salle>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from salle");
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		int capacite = rs.getInt(2);
    		int id_cour = rs.getInt(3);
    		String nom = rs.getString(4);
    		Salle s = new Salle(id, nom, capacite);
    		le.add(s);
    	}
    	DBInteraction.disconnect();
    	return le;
    }
    public List<Cour> All_Courses(Salle s) throws ClassNotFoundException, SQLException
    {
    	List<Cour> le = new ArrayList<Cour>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from salle where nom = '"+s.getNom()+"'");
    	DAOCour daoc = new DAOCour();
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		int capacite = rs.getInt(2);
    		int id_cour = rs.getInt(3);
    		String nom = rs.getString(4);
    		Cour c = daoc.Find_ID(id_cour);
    		le.add(c);
    	}
    	DBInteraction.disconnect();
    	return le;
    }
    public List<Cour> All_Courses_Not_In_Salle(Salle s) throws ClassNotFoundException, SQLException
    {
    	List<Cour> le = new ArrayList<Cour>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from salle where nom != '"+s.getNom()+"'");
    	DAOCour daoc = new DAOCour();
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		int capacite = rs.getInt(2);
    		int id_cour = rs.getInt(3);
    		String nom = rs.getString(4);
    		Cour c = daoc.Find_ID(id_cour);
    		le.add(c);
    	}
    	DBInteraction.disconnect();
    	return le;
    }
    public Salle Find_Salle_Id(int Id) throws ClassNotFoundException, SQLException
    {
    	Salle s = null;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from salle where id="+Id);
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		int capacite = rs.getInt(2);
    		int id_cour = rs.getInt(3);
    		String nom = rs.getString(4);
    		s = new Salle(id, nom, capacite);
    	}
    	DBInteraction.disconnect();
    	return s;
    }
    public Salle Find_Id(int Id) throws ClassNotFoundException, SQLException
    {
    	Salle s = null;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from salle where id_c="+Id);
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		int capacite = rs.getInt(2);
    		int id_cour = rs.getInt(3);
    		String nom = rs.getString(4);
    		s = new Salle(id, nom, capacite);
    	}
    	DBInteraction.disconnect();
    	return s;
    }


    public int Modifier(Salle s1,Salle s2) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	if(s2.getLc() == null)
    	{
    		nbr  += DBInteraction.Maj("update salle set capacite="+s2.getCapacite()+",id_c=null,nom= '"+s2.getNom()+"' where id = "+s1.getId());
    	}
    	else
    	{
    	     for (Cour c : s2.getLc()) {
    	   		nbr  += DBInteraction.Maj("update salle set capacite="+s2.getCapacite()+",id_c= "+c.getId()+",nom= '"+s2.getNom()+"' where id = "+s1.getId());
			}	
    	}
    	
    	DBInteraction.disconnect();
    	return nbr;
    }
    public int affecter_Cour(Salle s,Cour c) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
        nbr  += DBInteraction.Maj("insert into salle values(null,"+s.getCapacite()+","+c.getId()+",'"+s.getNom()+"')");
    	DBInteraction.disconnect();
    	return nbr;
    }
    public int Supprimer_CourAffecter(Salle s,Cour c) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
        nbr  += DBInteraction.Maj("update salle set id_c = null where nom = '"+s.getNom()+"' and id_c = "+c.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }
    public int supprimer(Salle s) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	nbr = DBInteraction.Maj("delete from salle where id = "+s.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }
    public int supprimer_By_ID_Cour(Cour c) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	nbr = DBInteraction.Maj("delete from salle where id_c = "+c.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }
}
