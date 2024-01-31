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
import java.sql.SQLException;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.mysql.cj.Session;

import DAO.DAOAdmin;
import DAO.DAOContact;
import DAO.DAODirecteur;
import DAO.DAOEnseignant;
import DAO.DAOEtudiant;
import Models.Admin;
import Models.Contact;
import Models.Cour;
import Models.Directeur;
import Models.Enseignant;
import Models.Etudiant;

/**
 * Servlet implementation class etudiants
 */
public class etudiants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public etudiants() {
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
		if(request.getParameter("contact") != null)
		{
			String name = request.getParameter("name");
		    String email = request.getParameter("email");
		    String subject = request.getParameter("subject");
		    String msg = request.getParameter("msg");
		    Contact c = new Contact(0, name, email, subject, msg);
		    DAOContact daoc = new DAOContact();
		    String repense = "";
		    try {
				if(daoc.CreeContact(c))
				{
					repense = "Merci pour votre Message !";
				}
				else
				{
					repense = "Essayer une autre fois  !";
				}
				response.sendRedirect("jsp/contact.jsp?response="+repense);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("op") != null && request.getParameter("op").equals("valider"))
		{
			HttpSession ses = request.getSession();
			if(ses.getAttribute("e") != null)
			{
				Etudiant e = (Etudiant) ses.getAttribute("e");
				List<Cour> lc = (List<Cour>) ses.getAttribute("lc");
				out.print("L'etudiant est : "+e.getNom());
				out.print("Courses : ");
				for (Cour cour : lc) {
					out.print(cour);
				}
				DAOEtudiant daoe = new DAOEtudiant();
				for (Cour cour : lc) {
					try {
						daoe.ajouter_Cour(e, cour);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				response.sendRedirect("jsp/Done.jsp");
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Assslamo Alikom");
		DAOEtudiant daoetu = new DAOEtudiant();
		DAOEnseignant daoensg = new DAOEnseignant();
		DAOAdmin daoadm = new DAOAdmin();
		
		if(request.getParameter("signup") != null)
		{
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String genre = request.getParameter("genre");
			String tele = request.getParameter("tele");
			String telP = request.getParameter("teleP");
			String gmail = request.getParameter("gmail");
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			out.println("\nDone signup.....");
			out.print(fname+" ,  "+lname+"   ,   "+genre+"  ,   "+"  ,  "+tele+"  ,  "+telP+"    ,   "+login+"     ,    "+pass);
			
			Etudiant e = new Etudiant(0,fname, lname, gmail, genre, tele, telP, login, pass);
			int nbr = 0;
			try {
				
				daoetu.CreeCompte(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.sendRedirect("jsp/login.jsp?m=succeRegister");
		}
		if(request.getParameter("signin") != null)
		{
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			String role = request.getParameter("role");
			out.print("signin Done ....");
			out.print(login+"   ,    "+pass);
			if(role.equals("Etudiant"))
			{
				Etudiant e = new Etudiant(login,pass);
				try {
					e = daoetu.authentifie(e);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(e == null)
				{
					response.sendRedirect("jsp/login.jsp?m=echecIn");
				}
				else
				{
					HttpSession ses = request.getSession();
					ses.setAttribute("e", e);
					response.sendRedirect("jsp/index.jsp");
				}
			}
			if(role.equals("Enseignant"))
			{
				Enseignant ensg = new Enseignant(login, pass);
				try {
					ensg = daoensg.authentifie(ensg);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(ensg == null)
				{
					response.sendRedirect("jsp/login.jsp?m=echecIn");
				}
				else
				{
					HttpSession ses = request.getSession();
					ses.setAttribute("ensg", ensg);
					response.sendRedirect("jsp/index.jsp");
				}
			}
			if(role.equals("Admin"))
			{
				Admin adm = new Admin(login, pass);
				try {
					adm = daoadm.authentifie(adm);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(adm == null)
				{
					response.sendRedirect("jsp/login.jsp?m=echecIn");
				}
				else
				{
					HttpSession ses = request.getSession();
					ses.setAttribute("adm", adm);
					response.sendRedirect("jsp/index.jsp");
				}
			}
			if(role.equals("Directeur"))
			{
				out.print("              role.equals(\"Dericteur\")");
				Directeur d = new Directeur(login, pass);
				out.print("            d.getLogin() = "+d.getLogin());
				out.print("            d.getPass() = "+d.getPass());
				DAODirecteur daod = new DAODirecteur();
				try {
					d = daod.authentifie(d);

					if(d == null)
					{
						response.sendRedirect("jsp/login.jsp?m=echecIn");
					}
					else
					{
						//out.print(" id  =  "+d.getId());
						out.print(" nom  =  "+d.getNom());
						out.print(" prenom  =  "+d.getPrenom());
						out.print(" login  =  "+d.getLogin());
						out.print(" pass  =  "+d.getPass());
						HttpSession ses = request.getSession();
						ses.setAttribute("dir", d);
						response.sendRedirect("jsp/index.jsp");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
