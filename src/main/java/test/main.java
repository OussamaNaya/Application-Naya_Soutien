package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import DAO.DAOAbsence;
import DAO.DAOAdmin;
import DAO.DAOCour;
import DAO.DAODirecteur;
import DAO.DAOEmplois;
import DAO.DAOEnseignant;
import DAO.DAOEtudiant;
import DAO.DAOGroupe;
import DAO.DAOPaiement;
import DAO.DAOPaquet;
import DAO.DAOSalle;
import Models.Absence_Enseignant;
import Models.Absence_Etudiant;
import Models.Admin;
import Models.Cour;
import Models.Directeur;
import Models.Emplois;
import Models.Enseignant;
import Models.Etudiant;
import Models.Groupe;
import Models.Paiement_Enseignant;
import Models.Paiement_Etudiant;
import Models.Paquite;
import Models.Salle;
import DAO.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Assalamo alikom");
 
//        System.out.println("---------------------------------------------------La partie du Paquet : ");
//        DAOPaquet daop1 = new DAOPaquet();
//        try {
//			List<Paquite> lp = daop1.All();
//			System.out.println("---------------------------------");
//			for (Paquite paquite : lp) {
//				System.out.println("-->Sallam :");
//				System.out.println("Le nom est : "+paquite.getNom());
//				System.out.println("cours est : "+paquite.getLc());
//				System.out.println("--------------");
//			}
//		} catch (ClassNotFoundException e4) {
//			// TODO Auto-generated catch block
//			e4.printStackTrace();
//		} catch (SQLException e4) {
//			// TODO Auto-generated catch block
//			e4.printStackTrace();
//		}
//        
//        try {
//			Paquite paq = daop1.get_Paquit3("SVT");
//			System.out.println("Cours : ");
//			for (Cour c : paq.getLc()) {
//				System.out.println("--> "+c);
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        Etudiant s = new Etudiant(0, "oussama", "naya", "@", "homee", "0000000000", "111111", "oussama", "123");
//        DAOEtudiant dao = new DAOEtudiant();
//        try {
//			System.out.println(" -> "+dao.CreeCompte(s));
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        DAOEmplois d = new DAOEmplois();
        Groupe g = new Groupe(1, "groupe 1", "BAC MATH", 10);
        try {
			for (Emplois emplois : d.Emplois_By_Group(g)) {
				Map<String,Cour> courses = emplois.getCourses();
				for(String key : courses.keySet())
				{
				    System.out.println(key+" = "+courses.get(key).getNom());	
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      DAOGroupe daog = new DAOGroupe();
      try {
		for(Groupe g1 : daog.All_Niveau("BAC SVT"))
		{
			System.out.println("Le nom est : "+g1.getNom());
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      DAODirecteur d1 = new DAODirecteur();
      try {
		System.out.println("     -->  "+d1.authentifie(new Directeur("oussama", "123"))); 
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
   
}
