package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.DAOCour;
import DAO.DAOEmplois;
import DAO.DAOEnseignant;
import DAO.DAOEtudiant;
import DAO.DAOGroupe;
import DAO.DAOSalle;
import Models.Cour;
import Models.Enseignant;
import Models.Etudiant;
import Models.Groupe;
import Models.Salle;

/**
 * Servlet implementation class admins
 */
public class admins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admins() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("Assalmao Alikom");
		if(request.getParameter("op") != null)
		{
			out.print("         request.getParameter(\"op\") != null      ");
			if(request.getParameter("op").equals("supprimerGroupe"))
			{
				int idGroup = Integer.parseInt(request.getParameter("idGroup"));
				DAOGroupe daog = new DAOGroupe();
				DAOEtudiant daoe = new DAOEtudiant();
				DAOEnseignant daoensg = new DAOEnseignant();
				DAOEmplois daoemplois = new DAOEmplois();
				int nbr = 0;
				try {
					Groupe g = daog.Find_ID(idGroup);										
					nbr += daoe.supprimer_where_Id_Groupe(g);					
					nbr += daoensg.Off_Groupe(g);
					nbr += daoemplois.supprimer_where_Id_Groupe(g);
					nbr += daog.supprimer(g);
					out.print("  , nbr = "+nbr);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    response.sendRedirect("jsp/groupe.jsp");
				
			}
			if(request.getParameter("op").equals("supprimerEtudiant"))
			{
				DAOEtudiant daoe = new DAOEtudiant();
				int idE = Integer.parseInt(request.getParameter("idE"));
				int idGroup = Integer.parseInt(request.getParameter("idGroup"));
			    try {
					Etudiant e = daoe.Find_Id(idE);
					daoe.supprimer(e);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    response.sendRedirect("jsp/groupe.jsp?op=consulter&idGroup="+idGroup);
			    
			}
			if(request.getParameter("op").equals("supprimerEnseignant"))
			{
				out.print(" request.getParameter(\"op\").equals(\"supprimerEnseignant\")     ");
				int idEnseignant = Integer.parseInt(request.getParameter("idEnseignant"));
				out.print("     , idEnseignant = "+idEnseignant);
				DAOEnseignant daoensg = new DAOEnseignant();
				try {
					Enseignant ensg = daoensg.Find_Id(idEnseignant);
					out.print("l'enseignant s'appelle = "+ensg.getNom());
					daoensg.supprimer(ensg);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("jsp/enseignant.jsp");
			}
			if(request.getParameter("op").equals("supprimerSalle"))
			{
				int idSalle = Integer.parseInt(request.getParameter("idSalle"));
				out.print("   idSalle = "+idSalle);
				DAOSalle daos = new DAOSalle();
				Salle s = new Salle();
				try {
					s = daos.Find_Salle_Id(idSalle);
					out.print("   s.getId() = "+s.getId());
					daos.supprimer(s);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("jsp/salle.jsp");
			}
			if(request.getParameter("op").equals("supprimerCourSAlle"))
			{
				int idSalle = Integer.parseInt(request.getParameter("idSalle"));
				int idCour = Integer.parseInt(request.getParameter("idCour"));
				DAOSalle daos = new DAOSalle();
				DAOCour daoc = new DAOCour();
				try {
					Cour c = daoc.Find_ID(idCour);
					Salle s = daos.Find_Salle_Id(idSalle);
					daos.Supprimer_CourAffecter(s,c);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("jsp/salle.jsp?op=consulter&idSalle="+idSalle);
			}
			if(request.getParameter("op").equals("affecterCourSalle"))
			{
				int idSalle = Integer.parseInt(request.getParameter("idSalle"));
				int idCour = Integer.parseInt(request.getParameter("idCour"));
				DAOSalle daos = new DAOSalle();
				DAOCour daoc = new DAOCour();
				try {
					Cour c = daoc.Find_ID(idCour);
					Salle s = daos.Find_Salle_Id(idSalle);
					daos.affecter_Cour(s, c);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("jsp/salle.jsp?op=consulter&idSalle="+idSalle+"&op2=affecterCour");
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("Assalamo Alikom doPost");
		if(request.getParameter("ajouterGroupe") != null)
		{
			String nom = request.getParameter("nom");
			String niveau = request.getParameter("niveau");
			int capacite = Integer.parseInt(request.getParameter("capacite"));
			out.print("   , nom = "+nom);
			out.print("   , niveau = "+niveau);
			out.print("   , capacite = "+capacite);
			DAOGroupe daog = new DAOGroupe();
			try {
				daog.CreeGroupe(new Groupe(0, nom, niveau, capacite));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("jsp/groupe.jsp");
		}
		if(request.getParameter("saveG") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String niveau = request.getParameter("niveau");
			int capacite = Integer.parseInt(request.getParameter("capacite"));
			out.print("  id = "+id);
			out.print("  nom = "+nom);
			out.print("  niveau = "+niveau);
			out.print("  capacite = "+capacite);
			DAOGroupe daog = new DAOGroupe();
			Groupe g1 = new Groupe(id, nom, niveau, capacite);
			Groupe g2 = new Groupe(id, nom, niveau, capacite);
			try {
				daog.Modifier(g1, g2);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("jsp/groupe.jsp");
		}
		if(request.getParameter("ajouterEtudiant") != null)
		{
			out.print("           request.getParameter(\"ajouterEtudiant\") != null");
			DAOEtudiant daoe = new DAOEtudiant();
			DAOGroupe daog = new DAOGroupe();
			int id_groupe = Integer.parseInt(request.getParameter("id_groupe"));
			String nom = request.getParameter("nom");			
			String prenom = request.getParameter("prenom");
			String gmail = request.getParameter("gmail");
			String genre = request.getParameter("genre");
			String tele = request.getParameter("phone");
			String teleP = request.getParameter("phoneP");
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			out.print(" id_groupe = "+id_groupe);
			out.print(" nom = "+nom);
			out.print(" prenom = "+prenom);
			out.print(" gmail = "+gmail);
			out.print(" genre = "+genre);
			out.print(" tele = "+tele);
			out.print(" teleP = "+teleP);
			out.print(" login = "+login);
			out.print(" pass = "+pass);
			try {
				Groupe g = daog.Find_ID(id_groupe);
				Etudiant e = new Etudiant(0, nom, prenom, gmail, genre, tele, teleP, login, pass, null, g);
				daoe.CreeCompte_Whid_Groupe(e);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			response.sendRedirect("jsp/groupe.jsp?op=consulter&idGroup="+id_groupe);
		}
		if(request.getParameter("modifierEtudiant") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String gmail = request.getParameter("gmail");
			String genre = request.getParameter("genre");
			String tele = request.getParameter("tele");
			String teleP = request.getParameter("teleP");
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			int id_groupe = Integer.parseInt(request.getParameter("id_groupe"));
			
			DAOEtudiant daoe = new DAOEtudiant();
			DAOGroupe daog = new DAOGroupe();
			try {
				daoe.Modifier(new Etudiant(id, nom, prenom, gmail, genre, tele, teleP, login, pass), new Etudiant(id, nom, prenom, gmail, genre, tele, teleP, login, pass));
				daoe.affecter_Groupe(new Etudiant(id, nom, prenom, gmail, genre, tele, teleP, login, pass), daog.Find_ID(id_groupe));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("jsp/groupe.jsp?op=consulter&idGroup="+id_groupe);
			
		}
		if(request.getParameter("ajouterEnseignant") != null)
		{
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));
			String matier = request.getParameter("matier");
			String genre = request.getParameter("genre");
			String tele = request.getParameter("tele");
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			
			DAOEnseignant daoensg = new DAOEnseignant();
			try {
				daoensg.CreeCompte(new Enseignant(0, nom, prenom, age, matier, genre, tele, login, pass));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("jsp/enseignant.jsp");
		}
		if(request.getParameter("modiferEnseignant") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));
			String genre = request.getParameter("genre");
			String tele = request.getParameter("tele");
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			Enseignant e1 = new Enseignant(id, nom, prenom, age, null, genre, tele, login, pass);
			DAOEnseignant daoensg = new DAOEnseignant();
			try {
				daoensg.Modifier(e1, e1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("jsp/enseignant.jsp");
		}
		if(request.getParameter("ajouterSalle") != null)
		{
			String nom = request.getParameter("nom");
			int capaciter = Integer.parseInt(request.getParameter("capaciter"));
			DAOSalle daos = new DAOSalle();
			Salle s = new Salle(0, nom, capaciter);
			try {
				daos.CreeSalle(s);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("jsp/salle.jsp");
		}
		if(request.getParameter("modifierSalle") != null)
		{
			String nom = request.getParameter("nom");
			int capaciter = Integer.parseInt(request.getParameter("capaciter"));
			int id = Integer.parseInt(request.getParameter("id"));
			Salle s = new Salle(id, nom, capaciter);
			DAOSalle daos = new DAOSalle();
			try {
				daos.Modifier(s, s);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("jsp/salle.jsp");
		}
	}

}
