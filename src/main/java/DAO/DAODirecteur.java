package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Admin;
import Models.Directeur;
import tools.DBInteraction;

public class DAODirecteur {
	public Directeur authentifie(Directeur D) throws SQLException, ClassNotFoundException
    {
    	Directeur d = null;
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from directeur where login = '"+D.getLogin()+"' and pass = '"+D.getPass()+"'");
    	if(rs.next())
    	{
    		
    		int id = rs.getInt(1);
    		String nom = rs.getString(2);
    		String prenom = rs.getString(3);
    		int age = rs.getInt(4);
    		String login = rs.getString(5);
    		String pass = rs.getString(6);
    		
    		d = new Directeur(id, nom, prenom, age, login, pass);
    	}
    	DBInteraction.disconnect();
    	return d;
     } 
}
