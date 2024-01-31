package web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.Session;

import DAO.DAOAbsence;
import DAO.DAOCour;
import DAO.DAOEnseignant;
import DAO.DAOEtudiant;
import DAO.DAOSalle;
import Models.Absence_Etudiant;
import Models.Cour;
import Models.Enseignant;
import Models.Etudiant;
import Models.Salle;

/**
 * Servlet implementation class enseignants
 */
public class enseignants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enseignants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("Assalamo alikom ostad");
		
		if(request.getParameter("op") != null)
		{
			if(request.getParameter("op").equals("disconnect"))
			{
				HttpSession ses = request.getSession();
				ses.removeAttribute("e");
				ses.invalidate();
				response.sendRedirect("jsp/index.jsp");
			}
		}
		if(request.getParameter("op") != null)
		{
			if(request.getParameter("op").equals("suppCour"))
			{
				out.print("Vous etes dans op = suppCour");
				int id =  Integer.parseInt(request.getParameter("id"));
				DAOCour daoc = new DAOCour();
				DAOEnseignant daoensg = new DAOEnseignant();
				DAOSalle daos = new DAOSalle();
				int nbr = 0;
				try {
					Cour c = daoc.Find_ID(id);
					nbr += daoc.sapprimer(c);
					nbr += daoensg.supprimer_Id_Cour(c);
					nbr += daos.supprimer_By_ID_Cour(c);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.print("le nbr = "+nbr);
				if(nbr != 0 )
				{
					response.sendRedirect("jsp/courses.jsp");
				}
			}
		}
		if(request.getParameter("op") != null)
		{
			if(request.getParameter("op").equals("abs"))
			{
				int idE = Integer.parseInt(request.getParameter("idE"));
				int idG = Integer.parseInt(request.getParameter("idG"));
				
				out.print("     idEtudiant = "+idE);
				HttpSession ses = request.getSession();
				if(ses.getAttribute("ensg") != null)
				{
					Enseignant ensg = (Enseignant) ses.getAttribute("ensg");
					DAOEtudiant daoe = new DAOEtudiant();
					DAOAbsence daoabs = new DAOAbsence();
					LocalDateTime currentDateTime = LocalDateTime.now();
					Etudiant e = null;
					try {
						e = daoe.Find_Id(idE);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Absence_Etudiant abse = new Absence_Etudiant(0, currentDateTime.toString(), e);
				    try {
						out.print("                ,L'etat d'absence est : "+daoabs.CreeAbsence_Etudiant(abse));
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    response.sendRedirect("jsp/groupe.jsp?op=consulter&idGroup="+idG);   
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
		out.print("Assalamo alikom");
		
		if(request.getParameter("save") != null)
		{
			out.print("                    request.getParameter(\"save\") != null");
			int id = Integer.parseInt(request.getParameter("id"));
			out.print("   id = "+id);
			String nom = request.getParameter("nome");
			out.print("   nome = "+nom);
			String niveau = request.getParameter("niveau");
			out.print("   niveau = "+niveau);
			int heur = Integer.parseInt(request.getParameter("heur"));
			out.print("   heur = "+heur);
			String dateD = request.getParameter("dateD");
			out.print("   dateD = "+dateD);
			String dateF = request.getParameter("dateF");
			out.print("   dateF = "+dateF);
			int prix = Integer.parseInt(request.getParameter("prix"));
			out.print("   prix = "+prix);
			DAOCour daoc = new DAOCour();
			Cour c1 = null;
			try {
				c1 = daoc.Find_ID(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cour c2 = new Cour(id, nom, niveau, heur, dateD, dateF, prix);
			int nbr = 0;
			try {
			    nbr = daoc.Modifier(c1, c2);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print("Le nbr = "+nbr);
			response.sendRedirect("jsp/courses.jsp");
			
			
			//out.print(nom+"  ,  "+heur+"  ,  "+dateD+"  ,  "+dateF+"   ,  "+prix);
		}
		if(request.getParameter("ajouter") != null)
		{
			out.print("                    request.getParameter(\"ajouter\") != null");
			
			
			String nom = request.getParameter("nome");
			out.print("   nome = "+nom);
			String niveau = request.getParameter("niveau");
			out.print("   niveau = "+niveau);
			int heur = Integer.parseInt(request.getParameter("heur"));
			out.print("   heur = "+heur);
			String dateD = request.getParameter("dateD");
			out.print("   dateD = "+dateD);
			String dateF = request.getParameter("dateF");
			out.print("   dateF = "+dateF);
			int prix = Integer.parseInt(request.getParameter("prix"));
			out.print("   prix = "+prix);
			int idSalle = Integer.parseInt(request.getParameter("idSalle"));
			out.print("    isSalle = "+idSalle);
		    
			
			DAOCour daoc = new DAOCour();
			Cour c = new Cour(0, nom, niveau, heur, dateD, dateF, prix);
			try {
				out.print(daoc.CreeCour(c));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DAOSalle daos = new DAOSalle();
		    try {
				Salle s = daos.Find_Salle_Id(idSalle);
				out.print("   nom du salle est "+s.getNom());
				List<Cour> lc = new ArrayList<Cour>();
				c = daoc.Find_Cour_Id(c);
				lc.add(c);
				out.print("    lc != null : "+lc);
				s.setLc(lc);
				out.print("    s.getLc() != null : "+s.getLc());
				daos.CreeSalle(s);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		    
			try {
				c = daoc.Find_Cour_Id(c);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession ses = request.getSession();
			Enseignant ensg =(Enseignant) ses.getAttribute("ensg");
			DAOEnseignant daoensg = new DAOEnseignant();
			out.print("       Le nom du Enseignanat est : "+ensg.getNom());
			try {
				daoensg.ADD_Cour(ensg, c);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("jsp/courses.jsp");
			
		}
	}

}
