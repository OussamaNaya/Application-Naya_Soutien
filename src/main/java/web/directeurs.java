package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import DAO.DAOAdmin;
import DAO.DAODirecteur;
import DAO.DAOEnseignant;
import DAO.DAOEtudiant;
import DAO.DAOPaiement;
import Models.Admin;
import Models.Directeur;
import Models.Enseignant;
import Models.Etudiant;
import Models.Paiement_Admin;
import Models.Paiement_Enseignant;
import Models.Paiement_Etudiant;

/**
 * Servlet implementation class directeurs
 */
public class directeurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public directeurs() {
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
			if(request.getParameter("op").equals("supprimerAdmin"))
			{
				out.print(" request.getParameter(\"op\").equals(\"supprimerAdmin\")     ");
				int idAdmin = Integer.parseInt(request.getParameter("idAdmin"));
				out.print("     , idAdmin = "+idAdmin);
				DAOAdmin daoa = new DAOAdmin();
				try {
					daoa.sapprimer(daoa.Find_Id(idAdmin));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("jsp/admins.jsp");
			}
			if(request.getParameter("op").equals("modiferEtat"))
			{
				if(request.getParameter("idAdmin") != null)
				{
					int idAdmin = Integer.parseInt(request.getParameter("idAdmin"));
					out.print("        idAdmin = "+idAdmin);
					DAOAdmin daoa = new DAOAdmin();
					DAOPaiement daop = new DAOPaiement();
					try {
						Admin a = daoa.Find_Id(idAdmin);
						out.print("        a.id = "+a.getId());
						LocalDate dateActuelle = LocalDate.now();
						Paiement_Admin p = new Paiement_Admin(idAdmin,""+dateActuelle , a, idAdmin);
						daop.Admin(p);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					response.sendRedirect("jsp/paiement.jsp?m=admin");
				}
				if(request.getParameter("idEnseignant") != null)
				{
					int idEnseignant = Integer.parseInt(request.getParameter("idEnseignant"));
					out.print("        idEnseignant = "+idEnseignant);
					DAOEnseignant daoe = new DAOEnseignant();
					DAOPaiement daop = new DAOPaiement();
					try {
						Enseignant e = daoe.Find_Id(idEnseignant);
						out.print("        e.id = "+e.getId());
						LocalDate dateActuelle = LocalDate.now();
						Paiement_Enseignant p = new Paiement_Enseignant(idEnseignant,""+dateActuelle , e, idEnseignant);
						daop.Enseignant(p);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					response.sendRedirect("jsp/paiement.jsp?m=enseignant");
				}
				if(request.getParameter("idEtudiant") != null)
				{
					int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
					out.print("        idEtudiant = "+idEtudiant);
					DAOEtudiant daoe = new DAOEtudiant();
					DAOPaiement daop = new DAOPaiement();
					try {
						Etudiant e = daoe.Find_Id(idEtudiant);
						out.print("        e.id = "+e.getId());
						LocalDate dateActuelle = LocalDate.now();
						Paiement_Etudiant p = new Paiement_Etudiant(idEtudiant,""+dateActuelle , e, idEtudiant);
						daop.Etudiant(p);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					response.sendRedirect("jsp/paiement.jsp?m=etudiant");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("Assalmao Alikom");
		if(request.getParameter("ajouterAdmin") != null)
		{
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));
			String gmail = request.getParameter("gmail");
			String genre = request.getParameter("genre");
			String tele = request.getParameter("tele");
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			
			DAOAdmin daoa  = new DAOAdmin();
			try {
				daoa.CreeCompte(new Admin(0, nom, prenom, age, gmail, genre, tele, login, pass));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("jsp/admins.jsp");
		}
		if(request.getParameter("modiferAdmin") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));
			String gmail = request.getParameter("gmail");
			String genre = request.getParameter("genre");
			String tele = request.getParameter("tele");
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			
			Admin a = new Admin(id, nom, prenom, age, gmail, genre, tele, login, pass); 
			DAOAdmin daoa = new DAOAdmin();
			try {
				daoa.Modifier(a, a);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("jsp/admins.jsp");
		}
	}

}
