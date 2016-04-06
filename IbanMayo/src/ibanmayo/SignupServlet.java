package ibanmayo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import helper.db.*;

public class SignupServlet extends HttpServlet{
	
	private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() SignupServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() SignupServlet");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() SignupServlet");
    	
    	String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String surname1 = request.getParameter("surname1");
		String surname2 = request.getParameter("surname2");
		String kalea = request.getParameter("kalea");
		String city = request.getParameter("city");
		String zenbakia = request.getParameter("zenbakia");
		String nan = request.getParameter("nan");
		String taldea = request.getParameter("taldea");
		String lizentzia = request.getParameter("lizentzia");
		
		
		System.out.println("     Extracting request parameters: " + email + " " + password + " " + username + " " + name + " " + surname1 + " " + surname2 + " " + kalea + " " + city + " " + zenbakia + " " + nan + " " + taldea);
		
		mySQLdb.setUserInfo(email, password, username, name, surname1, surname2, kalea, city, zenbakia, nan, taldea, lizentzia);
		System.out.println("     Updating users table in the database");
		
		System.out.println("     Redirecting the user to loginForm.html");
		response.sendRedirect("/IbanMayo/html/loginForm.html");
		
        System.out.println("---> Exiting doPost() SignupServlet");
    }
}

