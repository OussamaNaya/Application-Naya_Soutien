package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Contact;
import Models.Etudiant;
import tools.DBInteraction;

public class DAOContact {
	public boolean CreeContact(Contact c) throws ClassNotFoundException, SQLException
    {
    	DBInteraction.connect();
    	int nb = DBInteraction.Maj("insert into contact values(null,'"+c.getName()+"','"+c.getEmail()+"','"+c.getSubject()+"','"+c.getMessage()+"')");
    	//DBInteraction.Maj("update utilisateur set etat = 0 where idU = "+u.getIdU());
    	if(nb != 0)
    	{
    		return true;
    	}
    	DBInteraction.disconnect();
    	return false;
    }
	public List<Contact> All() throws ClassNotFoundException, SQLException
    {
    	List<Contact> lcontact = new ArrayList<Contact>();
    	DBInteraction.connect();
    	ResultSet rs = DBInteraction.Select("select * from contact");
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String name = rs.getString(2);
    		String email = rs.getString(3);
    		String subject = rs.getString(4);
    		String message = rs.getString(5);
    		Contact c = new Contact(id, name, email, subject, message);
    		lcontact.add(c);
    	}
    	DBInteraction.disconnect();
    	return lcontact;
    }
}
