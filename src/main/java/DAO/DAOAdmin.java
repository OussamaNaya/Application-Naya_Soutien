package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.*;
import tools.DBInteraction;

public class DAOAdmin {
	public boolean CreeCompte(Admin a) throws ClassNotFoundException, SQLException
    {
    	DBInteraction.connect();
    	int nb = DBInteraction.Maj("insert into admin values(null,'"+a.getNom()+"','"+a.getPrenom()+"',"+a.getAge()+",'"+a.getGmail()+"','"+a.getGenre()+"',"+a.getTele()+",'"+a.getLogin()+"','"+a.getPass()+"')");
    	if(nb != 0)
    	{
    		return true;
    	}
    	DBInteraction.disconnect();
    	return false;
    }
	public Admin authentifie(Admin a) throws SQLException, ClassNotFoundException
    {
    	Admin a1 = null;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from admin where login = '"+a.getLogin()+"' and pass = '"+a.getPass()+"'");
    	if(rs.next())
    	{
    		
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String prenom = rs.getString(3);
    		int age = rs.getInt(4);
    		String gmail = rs.getString(5);
    		String genre = rs.getString(6);
    		String tele = rs.getString(7);
    		String login = rs.getString(8);
    		String pass = rs.getString(9);
    		
    		a1 = new Admin(id, nom, prenom, age, gmail, genre, tele, login, pass);
    	}
    	DBInteraction.disconnect();
    	return a1;
     } 
    public List<Admin> All() throws ClassNotFoundException, SQLException
    {
    	List<Admin> la = new ArrayList<Admin>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from admin");
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String prenom = rs.getString(3);
    		int age = rs.getInt(4);
    		String gmail = rs.getString(5);
    		String genre = rs.getString(6);
    		String tele = rs.getString(7);
    		String login = rs.getString(7);
    		String pass = rs.getString(7);
    		
    		Admin a1 = new Admin(id, nom, prenom, age, gmail, genre, tele, login, pass);
    		la.add(a1);
    	}
    	DBInteraction.disconnect();
    	return la;
    }
    public Admin Find_Id(int Id) throws SQLException, ClassNotFoundException
    {
    	Admin a = null;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from admin where id = "+Id);
    	if(rs.next())
    	{
    		
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String prenom = rs.getString(3);
    		int age = rs.getInt(4);
    		String gmail = rs.getString(5);
    		String genre = rs.getString(6);
    		String tele = rs.getString(7);
    		String login = rs.getString(7);
    		String pass = rs.getString(7);
    		
    		a = new Admin(id, nom, prenom, age, gmail, genre, tele, login, pass);
    	}
    	DBInteraction.disconnect();
    	return a;
     }
    public int Modifier(Admin a1,Admin a2) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	nbr = DBInteraction.Maj("update admin set nom ='"+a2.getNom()+"',prenom ='"+a2.getPrenom()+"',age ="+a2.getAge()+",gmail ='"+a2.getGmail()+"',genre ='"+a2.getGenre()+"',tele ='"+a2.getTele()+"',login ='"+a2.getLogin()+"',pass ='"+a2.getPass()+"' where id = "+a1.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }
    public int sapprimer(Admin a) throws ClassNotFoundException, SQLException
    {
    	int nbr = 0;
    	DBInteraction.connect();
    	nbr = DBInteraction.Maj("delete from admin where id = "+a.getId());
    	DBInteraction.disconnect();
    	return nbr;
    }
}
