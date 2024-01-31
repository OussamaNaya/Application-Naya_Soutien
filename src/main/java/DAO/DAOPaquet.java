package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Cour;
import Models.Paquite;
import Models.Salle;
import tools.DBInteraction;

public class DAOPaquet {
	public boolean CreePaquet(Paquite p) throws ClassNotFoundException, SQLException
    {
		int nb = 0;
    	DBInteraction.connect();
    	for (Cour c : p.getLc()) {
        	int id = DBInteraction.Maj("insert into paquite values(null,"+p.getId()+",'"+p.getNom()+"')");
		}
    	DBInteraction.disconnect();
    	return false;
    }
    public List<Paquite> All() throws ClassNotFoundException, SQLException
    {
    	List<Paquite> lp = new ArrayList<Paquite>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from paquite order by nom");
		DAOCour daoc = new DAOCour();
		List<Cour> lc = new ArrayList<Cour>();
		String nom = "";
		List<Cour> lc3 = new ArrayList<Cour>();
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		int id_c = rs.getInt(2);
    		if(!rs.getString(3).equals(nom))
    		{
    			    if(nom.equals(""))
    			    {
    			    	lc3 = new ArrayList<Cour>();
    			    	Cour c = daoc.Find_ID(id_c);
    			    	System.out.println("id = "+id_c);
    			    	System.out.println("cour = "+c);
    			    	lc3.add(c);
    			    }
    			    else {
	            			lp.add(new Paquite(id, nom, lc3));
	            			nom = rs.getString(3);
	            			lc3 = new ArrayList<Cour>();
	    			    	Cour c = daoc.Find_ID(id_c);
	    			    	System.out.println("id = "+id_c);
	    			    	System.out.println("cour = "+c);
	    			    	lc3.add(c);
    			    }
    		}
    		else {
    			Cour c = daoc.Find_ID(id_c);
		    	System.out.println("id = "+id_c);
		    	System.out.println("cour = "+c);
        		lc3.add(c);
    		}
    		nom = rs.getString(3);
    	}
    	DBInteraction.disconnect();
    	return lp;
    }
    public Paquite get_Paquit(String Nom) throws ClassNotFoundException, SQLException
    {
    	Paquite lp = new Paquite();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from paquite where niveau = '"+Nom+"'");
		DAOCour daoc = new DAOCour();
		List<Cour> lc3 = new ArrayList<Cour>();
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		int id_c = rs.getInt(2);
    		String nom =  rs.getString(3);
			Cour c = daoc.Find_ID(id_c);
    		lc3.add(c);    		
    	}
    	lp.setNom(Nom);
    	lp.setLc(lc3);
    	DBInteraction.disconnect();
    	return lp;
    }
    public Paquite get_Paquit2(String Nom) throws ClassNotFoundException, SQLException
    {
    	Paquite p = new Paquite();
    	List<Paquite> lp = this.All();
    	for (Paquite paquite : lp) {
             for (Cour c : paquite.getLc()) {
            	
				if(c.getNiveau().equals("BAC "+Nom))
				{
					return paquite;
				}
			}
		}
    	return p;
    }
    public Paquite get_Paquit3(String Nom) throws ClassNotFoundException, SQLException
    {
    	Paquite lp = new Paquite();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from paquite where nom = '"+Nom+"'");
    	List<Cour> lc = new ArrayList<Cour>();
    	DAOCour daoc = new DAOCour();
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		int id_c = rs.getInt(2);
    		String nom = rs.getString(3);
    		if(lp.getId() == 0)
    		{
    			lp.setId(id);
    			lp.setNom(nom);
    		}
    		lc.add(daoc.Find_ID(id_c));
    	}
    	lp.setLc(lc);
    	return lp;
    }
    public int Modifier(Paquite p1,Paquite p2) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	for (Cour c : p2.getLc()) {
    		nbr  += DBInteraction.Maj("update paquite set id_c="+c.getId()+",nom='"+p2.getNom()+"' where nom = '"+p1.getNom()+"'");
		}
    	DBInteraction.disconnect();
    	return nbr;
    }
    public int supprimer(Paquite p) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	nbr = DBInteraction.Maj("delete from paquite where nom = '"+p.getNom()+"'");
    	DBInteraction.disconnect();
    	return nbr;
    }
}
