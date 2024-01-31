<%@page import="DAO.DAOSalle"%>
<%@page import="DAO.DAOGroupe"%>
<%@page import="Models.Emplois"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="DAO.DAOEmplois"%>
<%@page import="Models.Groupe"%>
<%@page import="Models.Cour"%>
<%@page import="Models.Salle"%>
<%@page import="Models.Etudiant"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Naya_Soutien</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="../template/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="../template/lib/animate/animate.min.css" rel="stylesheet">
    <link href="../template/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="../template/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="../template/css/style.css" rel="stylesheet">
    <link href="../template/css/paquit.css" rel="stylesheet">

    <!-- Css of table -->
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../template/table-07/css/style.css">
</head>

<body style="background-color: aliceblue;">
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->

    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
        <a href="index.jsp" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
            <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>Naya_Soutien</h2>
        </a>
        <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <% 
        	if(session.getAttribute("e") != null)
        	{
        		Etudiant e = (Etudiant) session.getAttribute("e");
        %>
		          <div class="collapse navbar-collapse" id="navbarCollapse">
		            <div class="navbar-nav ms-auto p-4 p-lg-0">	         
		                <a href="index.jsp" class="nav-item nav-link active"><%=e.getNom() %></a>
		                <a href="about.jsp" class="nav-item nav-link">About</a>
		                <a href="courses.jsp" class="nav-item nav-link">Courses</a>
		                <div class="nav-item dropdown">
		                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Emplois du Temps</a>
		                    <div class="dropdown-menu fade-down m-0">
		                        <a href="emplois.jsp?m= BAC Math" class="dropdown-item">BAC MATH</a>
		                        <a href="emplois.jsp?m= BAC PC" class="dropdown-item">BAC PC</a>
		                        <a href="emplois.jsp?m= BAC SVT" class="dropdown-item">BAC SVT</a>
		                    </div>
		                </div>
		                <a href="contact.jsp" class="nav-item nav-link ">Contact</a>
		            </div>
		            <a href="../etudiants?op=disconnect" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block ">Disconnect<i
		                    class="fa fa-arrow-right ms-3 "></i></a>
		        </div>
        <% 		
        	}
        	else
        	{
        		
        %>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
                <a href="index.jsp" class="nav-item nav-link active">Home</a>
                <a href="about.jsp" class="nav-item nav-link">About</a>
                <a href="courses.jsp" class="nav-item nav-link">Courses</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Emplois du Temps</a>
                    <div class="dropdown-menu fade-down m-0">
		                        <a href="emplois.jsp?m=BAC Math" class="dropdown-item">BAC MATH</a>
		                        <a href="emplois.jsp?m=BAC PC" class="dropdown-item">BAC PC</a>
		                        <a href="emplois.jsp?m=BAC SVT " class="dropdown-item">BAC SVT</a>
		            </div>
                </div>
                <a href="contact.jsp" class="nav-item nav-link ">Contact</a>
            </div>
            <a href="login.jsp" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block ">Join Now<i
                    class="fa fa-arrow-right ms-3 "></i></a>
        </div>
        <% 
        	}
        %>
    </nav>
    <!-- Navbar End -->

    <!--Liste of Cours Debut-->
    <section class="ftco-section">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                <%
                	String nom = "";
              	    Groupe g = null;
                    if(request.getParameter("gid") != null)
                    {  	
                    	int id = Integer.parseInt(request.getParameter("gid"));
                    	DAOGroupe daog = new DAOGroupe();
                    	g = daog.Find_ID(id);
                    	nom =  g.getNom();
                    }
                %>
                    <h2 class="heading-section" style="color: black;">Emplois du Groupe <%=nom %></h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="table-wrap">
                        <table class="table table-bordered table-dark table-hover">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>8:9</th>
                                    <th>9:10</th>
                                    <th>10:11</th>
                                    <th>11:12</th>
                                    <th>2:3</th>
                                    <th>3:4</th>
                                    <th>4:5</th>
                                    <th>5:6</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                                //g.setId(1);     // j'ai pas le temps pour saisir les autres
                            	DAOEmplois daoemlpois = new DAOEmplois();
                                List<Emplois> le = daoemlpois.Emplois_By_Group(g);
                                DAOSalle daos = new DAOSalle();
                                for(Emplois emplois : le)
                                {	
                                	Map<String,Cour> courses = emplois.getCourses();
                 
                    				    //System.out.println(key+" = "+courses.get(key).getNom());	           		
                    				
                                	%>                             	
                                	<tr>
	                                    <th scope="row"><%=emplois.getJeur()%></th>
	                                    <td>
	                                    	<p style="color: aquamarine;"><%=courses.get("8:9").getNom() %></p>
	                                    	<p><%=courses.get("8:9").getId() %></p>
	                                        <%
	                                            Cour c = courses.get("8:9");
	                                            String nom_salle = "salle...?";
	                                            Salle s = daos.Find_Id(c.getId());
	                                            if(s != null)
	                                            {
	                                            	nom_salle = s.getNom();
	                                            }
	                                        %>
	                                        <p style="color: blanchedalmond;"><%=nom_salle %></p>
	                                    </td>
                                    <td>
	                                    	<p style="color: aquamarine;"><%=courses.get("9:10").getNom() %></p>
	                                    	<p><%=courses.get("9:10").getId() %></p>
	                                        <%
	                                            c = courses.get("9:10");
	                                            nom_salle = "salle...?";
	                                            s = daos.Find_Id(c.getId());
	                                            if(s != null)
	                                            {
	                                            	nom_salle = s.getNom();
	                                            }
	                                        %>
	                                        <p style="color: blanchedalmond;"><%=nom_salle %></p>
	                                    </td>
                                    <td>
	                                    	<p style="color: aquamarine;"><%=courses.get("10:11").getNom() %></p>
	                                    	<p><%=courses.get("9:10").getId() %></p>
	                                        <%
	                                            c = courses.get("10:11");
	                                            nom_salle = "salle...?";
	                                            s = daos.Find_Id(c.getId());
	                                            if(s != null)
	                                            {
	                                            	nom_salle = s.getNom();
	                                            }
	                                        %>
	                                        <p style="color: blanchedalmond;"><%=nom_salle %></p>
	                                    </td>
	                                    <td>
	                                    	<p style="color: aquamarine;"><%=courses.get("11:12").getNom() %></p>
	                                    	<p><%=courses.get("11:12").getId() %></p>
	                                        <%
	                                            c = courses.get("11:12");
	                                            nom_salle = "salle...?";
	                                            s = daos.Find_Id(c.getId());
	                                            if(s != null)
	                                            {
	                                            	nom_salle = s.getNom();
	                                            }
	                                        %>
	                                        <p style="color: blanchedalmond;"><%=nom_salle %></p>
	                                    </td>
	                                    <td>
	                                    	<p style="color: aquamarine;"><%=courses.get("2:3").getNom() %></p>
	                                    	<p><%=courses.get("2:3").getId() %></p>
	                                        <%
	                                            c = courses.get("2:3");
	                                            nom_salle = "salle...?";
	                                            s = daos.Find_Id(c.getId());
	                                            if(s != null)
	                                            {
	                                            	nom_salle = s.getNom();
	                                            }
	                                        %>
	                                        <p style="color: blanchedalmond;"><%=nom_salle %></p>
	                                    </td>
	                                    <td>
	                                    	<p style="color: aquamarine;"><%=courses.get("3:4").getNom() %></p>
	                                    	<p><%=courses.get("3:4").getId() %></p>
	                                        <%
	                                            c = courses.get("3:4");
	                                            nom_salle = "salle...?";
	                                            s = daos.Find_Id(c.getId());
	                                            if(s != null)
	                                            {
	                                            	nom_salle = s.getNom();
	                                            }
	                                        %>
	                                        <p style="color: blanchedalmond;"><%=nom_salle %></p>
	                                    </td>
	                                    <td>
	                                    	<p style="color: aquamarine;"><%=courses.get("4:5").getNom() %></p>
	                                    	<p><%=courses.get("4:5").getId() %></p>
	                                        <%
	                                            c = courses.get("4:5");
	                                            nom_salle = "salle...?";
	                                            s = daos.Find_Id(c.getId());
	                                            if(s != null)
	                                            {
	                                            	nom_salle = s.getNom();
	                                            }
	                                        %>
	                                        <p style="color: blanchedalmond;"><%=nom_salle %></p>
	                                    </td>
	                                    <td>
	                                    	<p style="color: aquamarine;"><%=courses.get("5:6").getNom() %></p>
	                                    	<p><%=courses.get("5:6").getId() %></p>
	                                        <%
	                                            c = courses.get("5:6");
	                                            nom_salle = "salle...?";
	                                            s = daos.Find_Id(c.getId());
	                                            if(s != null)
	                                            {
	                                            	nom_salle = s.getNom();
	                                            }
	                                        %>
	                                        <p style="color: blanchedalmond;"><%=nom_salle %></p>
	                                    </td>
	                                </tr>
                                	
                                	<% 
                                }
                            %>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="../template/table-07/js/jquery.min.js"></script>
    <script src="../template/table-07/js/popper.js"></script>
    <script src="../template/table-07js/bootstrap.min.js"></script>
    <script src="../template/table-07js/main.js"></script>

    <!--Liste of Cours Fin-->

    <!-- Footer Start -->
    <div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
        <div class="container py-5">
            <div class="row g-5">
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Quick Link</h4>
                    <a class="btn btn-link" href="">About Us</a>
                    <a class="btn btn-link" href="">Contact Us</a>
                    <a class="btn btn-link" href="">Privacy Policy</a>
                    <a class="btn btn-link" href="">Terms & Condition</a>
                    <a class="btn btn-link" href="">FAQs & Help</a>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Contact</h4>
                    <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA</p>
                    <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>+012 345 67890</p>
                    <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@example.com</p>
                    <div class="d-flex pt-2">
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Gallery</h4>
                    <div class="row g-2 pt-2">
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="../template/img/course-1.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="../template/img/course-2.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="../template/img/course-3.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="../template/img/course-2.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="../template/img/course-3.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="../template/img/course-1.jpg" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Newsletter</h4>
                    <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
                    <div class="position-relative mx-auto" style="max-width: 400px;">
                        <input class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text" placeholder="Your email">
                        <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="copyright">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        &copy; <a class="border-bottom" href="#">Naya_Soutien</a>, All Right Reserved.

                        <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                    </div>
                    <div class="col-md-6 text-center text-md-end">
                        <div class="footer-menu">
                            <a href="">Home</a>
                            <a href="">Cookies</a>
                            <a href="">Help</a>
                            <a href="">FQAs</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->

    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../template/lib/wow/wow.min.js"></script>
    <script src="../template/lib/easing/easing.min.js"></script>
    <script src="../template/lib/waypoints/waypoints.min.js"></script>
    <script src="../template/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="../template/js/main.js"></script>
</body>

</html>

</html>