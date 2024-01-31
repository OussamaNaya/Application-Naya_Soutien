package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Absence;
import Models.Absence_Enseignant;
import Models.Absence_Etudiant;
import Models.Cour;
import Models.Enseignant;
import Models.Etudiant;
import Models.Salle;
import tools.DBInteraction;

public class DAOAbsence {
	public int CreeAbsence_Enseignant(Absence_Enseignant a) throws ClassNotFoundException, SQLException
    {
		int nb = 0;
    	DBInteraction.connect();
        nb += DBInteraction.Maj("insert into absence values (null,'"+a.getDate()+"',"+a.getLens().getId()+",'enseignant')");
    	DBInteraction.disconnect();
    	return nb;
    }
	public int CreeAbsence_Etudiant(Absence_Etudiant a) throws ClassNotFoundException, SQLException
    {
		int nb = 0;
    	DBInteraction.connect();
        nb += DBInteraction.Maj("insert into absence values (null,'"+a.getDate()+"',"+a.getLe().getId()+",'etudiant')");
    	DBInteraction.disconnect();
    	return nb;
    }
    public List<Absence_Enseignant> All_Enseignant() throws ClassNotFoundException, SQLException
    {
    	List<Absence_Enseignant> la = new ArrayList<Absence_Enseignant>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from absence where profil = 'enseignant'");
    	DAOEnseignant daoen = new DAOEnseignant();
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String date = rs.getString(2);
    		int id_p = rs.getInt(3);
    		Enseignant ens = daoen.Find_Id(id_p);
    		
    		la.add(new Absence_Enseignant(id,date,ens));
    	}
    	DBInteraction.disconnect();
    	return la;
    }
    public List<Absence_Etudiant> All_Etudiant() throws ClassNotFoundException, SQLException
    {
    	List<Absence_Etudiant> la = new ArrayList<Absence_Etudiant>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from absence where profil = 'etudiant'");
    	DAOEtudiant daoe = new DAOEtudiant();
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String date = rs.getString(2);
    		int id_p = rs.getInt(3);
    		Etudiant e = daoe.Find_Id(id_p);
    		
    		la.add(new Absence_Etudiant(id,date,e));
    	}
    	DBInteraction.disconnect();
    	return la;
    }
    public boolean Existe(Etudiant e) throws ClassNotFoundException, SQLException
    {
    	boolean b = false;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from absence where id_p = "+e.getId());
    	if(rs.next())
    	{
    		b = true;
    	}
    	DBInteraction.disconnect();
    	return b;
    }
    public int Nbr_Of_Abcence(Etudiant e) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from absence where id_p = "+e.getId());
    	while(rs.next())
    	{
    		nbr++;
    	}
    	DBInteraction.disconnect();
    	return nbr;
    }
}
