package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.*;
import Models.Absence_Etudiant;
import Models.Enseignant;
import Models.Etudiant;
import Models.Paiment;
import tools.DBInteraction;

public class DAOPaiement {
	public int Etudiant(Paiement_Etudiant p) throws ClassNotFoundException, SQLException
    {
		int nb = 0;
    	DBInteraction.connect();
        nb += DBInteraction.Maj("insert into paiement values (null,'etudiant','"+p.getDate()+"',"+p.getId()+")");
    	DBInteraction.disconnect();
    	return nb;
    }
	public int Enseignant(Paiement_Enseignant p) throws ClassNotFoundException, SQLException
    {
		int nb = 0;
    	DBInteraction.connect();
        nb += DBInteraction.Maj("insert into paiement values (null,'enseignant','"+p.getDate()+"',"+p.getId()+")");
    	DBInteraction.disconnect();
    	return nb;
    }
	public int Admin(Paiement_Admin p) throws ClassNotFoundException, SQLException
    {
		int nb = 0;
    	DBInteraction.connect();
        nb += DBInteraction.Maj("insert into paiement values (null,'admin','"+p.getDate()+"',"+p.getId()+")");
    	DBInteraction.disconnect();
    	return nb;
    }
    public List<Paiement_Enseignant> All_Enseignant() throws ClassNotFoundException, SQLException
    {
    	List<Paiement_Enseignant> la = new ArrayList<Paiement_Enseignant>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from paiement where profil = 'enseignant'");
    	DAOEnseignant daoen = new DAOEnseignant();
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String date = rs.getString(3);
    		int id_p = rs.getInt(4);
    		Enseignant ens = daoen.Find_Id(id_p);
    		
    		la.add(new Paiement_Enseignant(id, date, ens, id_p));
    	}
    	DBInteraction.disconnect();
    	return la;
    }
    public List<Paiement_Etudiant> All_Etudiant() throws ClassNotFoundException, SQLException
    {
    	List<Paiement_Etudiant> la = new ArrayList<Paiement_Etudiant>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from paiement where profil = 'etudiant'");
    	DAOEtudiant daoen = new DAOEtudiant();
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String date = rs.getString(3);
    		int id_p = rs.getInt(4);
    		Etudiant ens = daoen.Find_Id(id_p);
    		
    		la.add(new Paiement_Etudiant(id, date, ens, id_p));
    	}
    	DBInteraction.disconnect();
    	return la;
    }
    public Boolean Exist(int id_profil) throws ClassNotFoundException, SQLException
    {
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from paiement where id_profil = "+id_profil);
    	DAOEtudiant daoen = new DAOEtudiant();
    	if(rs.next())
    	{
    		return true;
    	}
    	DBInteraction.disconnect();
    	return false;
    }
}
