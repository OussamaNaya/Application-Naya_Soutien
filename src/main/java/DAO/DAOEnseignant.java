package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Cour;
import Models.Enseignant;
import Models.Etudiant;
import Models.Groupe;
import tools.DBInteraction;

public class DAOEnseignant {
	
	public boolean CreeCompte(Enseignant e) throws ClassNotFoundException, SQLException
    {
    	DBInteraction.connect();
    	int nb = DBInteraction.Maj("insert into enseignant values(null,'"+e.getNom()+"','"+e.getPrenom()+"',"+e.getAge()+",'"+e.getMatiere()+"','"+e.getGenre()+"','"+e.getTele()+"',null,null,'"+e.getLogin()+"','"+e.getPass()+"')");
    	//DBInteraction.Maj("update utilisateur set etat = 0 where idU = "+u.getIdU());
    	if(nb != 0)
    	{
    		return true;
    	}
    	DBInteraction.disconnect();
    	return false;
    }
	public boolean ADD_Cour(Enseignant e,Cour c) throws ClassNotFoundException, SQLException
    {
    	DBInteraction.connect();
    	int nb = DBInteraction.Maj("insert into enseignant values(null,'"+e.getNom()+"','"+e.getPrenom()+"',"+e.getAge()+",'"+e.getMatiere()+"','"+e.getGenre()+"','"+e.getTele()+"',null,"+c.getId()+",null,null)");
    	//DBInteraction.Maj("update utilisateur set etat = 0 where idU = "+u.getIdU());
    	if(nb != 0)
    	{
    		return true;
    	}
    	DBInteraction.disconnect();
    	return false;
    }
    public Enseignant authentifie(Enseignant e) throws SQLException, ClassNotFoundException
    {
    	Enseignant en = null;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from enseignant where login = '"+e.getLogin()+"' and pass = '"+e.getPass()+"'");
    	if(rs.next())
    	{
    		
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String prenom = rs.getString(3);
    		int age = rs.getInt(4);
    		String matier = rs.getString(5);
    		String genre = rs.getString(6);
    		String tele = rs.getString(7);
    		String login = rs.getString(10);
    		String pass = rs.getString(11);
    		
    		
    		en = new Enseignant(id,nom,prenom,age,matier,genre,tele,login,pass);
    	}
    	DBInteraction.disconnect();
    	return en;
     }
    public List<Enseignant> All() throws ClassNotFoundException, SQLException
    {
    	List<Enseignant> le = new ArrayList<Enseignant>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from enseignant");
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String prenom = rs.getString(3);
    		int age = rs.getInt(4);
    		String matier = rs.getString(5);
    		String genre = rs.getString(6);
    		String tele = rs.getString(7);
    		String login = rs.getString(10);
    		String pass = rs.getString(11);
    		Enseignant e = new Enseignant(id, nom, prenom, age, matier, genre, tele, login, pass);
    		le.add(e);
    	}
    	DBInteraction.disconnect();
    	return le;
    }
    public List<Cour> Find_Courses(Enseignant ensg) throws ClassNotFoundException, SQLException
    {
    	List<Cour> le = new ArrayList<Cour>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from enseignant where nom = '"+ensg.getNom()+"' and prenom = '"+ensg.getPrenom()+"'");
    	while(rs.next())
    	{
    		DAOCour daoc = new DAOCour();
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String prenom = rs.getString(3);
    		int age = rs.getInt(4);
    		String matier = rs.getString(5);
    		String genre = rs.getString(6);
    		String tele = rs.getString(7);
    		int id_groupe = rs.getInt(8);
    		int id_cour = rs.getInt(9);
    		String login = rs.getString(10);
    		String pass = rs.getString(11);
    		if(id_cour !=  -1)
    		{
    			Cour c = daoc.Find_ID(id_cour);
        		le.add(c);
    		}
    		
    	}
    	DBInteraction.disconnect();
    	return le;
    }
    public Enseignant Find_Id(int Id) throws SQLException, ClassNotFoundException
    {
    	Enseignant en = null;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from enseignant where id = "+Id);
    	if(rs.next())
    	{
    		
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String prenom = rs.getString(3);
    		int age = rs.getInt(4);
    		String matier = rs.getString(5);
    		String genre = rs.getString(6);
    		String tele = rs.getString(7);
    		String login = rs.getString(10);
    		String pass = rs.getString(11);
    		
    		
    		en = new Enseignant(id,nom,prenom,age,matier,genre,tele,login,pass);
    	}
    	DBInteraction.disconnect();
    	return en;
     }
    public Enseignant Find_Cour_Id(int Id) throws SQLException, ClassNotFoundException
    {
    	Enseignant en = null;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from enseignant where id_cour = "+Id);
    	if(rs.next())
    	{
    		
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String prenom = rs.getString(3);
    		int age = rs.getInt(4);
    		String matier = rs.getString(5);
    		String genre = rs.getString(6);
    		String tele = rs.getString(7);
    		String login = rs.getString(10);
    		String pass = rs.getString(11);
    		int id_groupe = rs.getInt(8);
    		int id_cour = rs.getInt(9);
    		if (id_groupe != -1 || id_cour != -1 )
    		{
    			en = new Enseignant(id_cour, nom, prenom, age, matier, pass, genre, tele, null, null, false, false);
    		}
    		else
    		{
    			en = new Enseignant(id,nom,prenom,age,matier,genre,tele,login,pass);
    		}

    	}
    	DBInteraction.disconnect();
    	return en;
     }
    public int Modifier(Enseignant e1,Enseignant e2) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	int id_paquit;
    	int id_groupe;
    	if(e2.getGroupe() == null)
    	{
        	if(e2.getLc() == null)
        	{
            	nbr = DBInteraction.Maj("update enseignant set nom ='"+e2.getNom()+"',prenom ='"+e2.getPrenom()+"',age ="+e2.getAge()+",matier ='"+e2.getMatiere()+"',genre ='"+e2.getGenre()+"',tele ='"+e2.getTele()+"',id_groupe =null, id_cour=null ,login ='"+e2.getLogin()+"',pass ='"+e2.getPass()+"'  where id = "+e1.getId()+"");
        	}
        	else
        	{
            	nbr = DBInteraction.Maj("update enseignant set nom ='"+e2.getNom()+"',prenom ='"+e2.getPrenom()+"',age ="+e2.getAge()+",matier ='"+e2.getMatiere()+"',genre ='"+e2.getGenre()+"',tele ='"+e2.getTele()+"',id_groupe =null, id_cour=null ,login ='"+e2.getLogin()+"',pass ='"+e2.getPass()+"'  where id = "+e1.getId()+"");

        	}
    	}
    	else {
    		if(e2.getLc() == null)
        	{
            	nbr = DBInteraction.Maj("update enseignant set nom ='"+e2.getNom()+"',prenom ='"+e2.getPrenom()+"',age ="+e2.getAge()+",matier ='"+e2.getMatiere()+"',genre ='"+e2.getGenre()+"',tele ='"+e2.getTele()+"',id_groupe =null, id_cour=null ,login ='"+e2.getLogin()+"',pass ='"+e2.getPass()+"'  where id = "+e1.getId()+"");
        	}
        	else
        	{
            	nbr = DBInteraction.Maj("update enseignant set nom ='"+e2.getNom()+"',prenom ='"+e2.getPrenom()+"',age ="+e2.getAge()+",matier ='"+e2.getMatiere()+"',genre ='"+e2.getGenre()+"',tele ='"+e2.getTele()+"',id_groupe =null, id_cour=null ,login ='"+e2.getLogin()+"',pass ='"+e2.getPass()+"'  where id = "+e1.getId()+"");

        	}
    	}
    	
    	DBInteraction.disconnect();
    	return nbr;
    }
    public int Off_Groupe(Groupe g) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	DBInteraction.Maj("update  enseignant set id_groupe=-1 where id_groupe = "+g.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }
    public int supprimer(Enseignant e) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	DBInteraction.Maj("delete from enseignant where id = "+e.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }   
    public int supprimer_Id_Cour(Cour c) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	DBInteraction.Maj("delete from  enseignant  where id_cour = "+c.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }
    public int supprimer_Id_Groupe(Groupe g) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	DBInteraction.Maj("delete from  enseignant  where id_groupe = "+g.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }

}
