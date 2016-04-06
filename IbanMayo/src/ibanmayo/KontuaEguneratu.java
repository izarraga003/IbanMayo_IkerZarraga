package ibanmayo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;


public class KontuaEguneratu extends HttpServlet {
private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() KontuaEguneratu");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() KontuaEguneratu");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() KontuaEguneratu");
    	
    	
    	String name = request.getParameter("name");
		String surname1 = request.getParameter("surname1");
		String surname2 = request.getParameter("surname2");
		String kalea = request.getParameter("kalea");
		String city = request.getParameter("city");
		String zenbakia = request.getParameter("zenbakia");
		String nan = request.getParameter("nan");
		String taldea = request.getParameter("taldea");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String email = mySQLdb.getEmail(username);
		String password = mySQLdb.getPassword(username);
		String lizentzia = mySQLdb.getLizentzia(username);
		System.out.println("     Extracting request parameters: " + name + " " + surname1 + " " + surname2 + " " + kalea + " " + city + " " + zenbakia + " " + nan + " " + taldea);
		
		mySQLdb.setUserInfoEguneratu(email, password, username, name, surname1, surname2, kalea, city, zenbakia, nan, taldea, lizentzia);
		System.out.println("     Updating users table in the database");
		
		System.out.println("     Redirecting the user to nagusia.html");
		response.sendRedirect("/IbanMayo/html/nagusia.html");
		
        System.out.println("---> Exiting doPost() KontuaEguneratu");
    }
}

