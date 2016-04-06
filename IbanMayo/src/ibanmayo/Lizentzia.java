package ibanmayo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;

/**
 * Servlet implementation class Lizentzia
 */
@WebServlet("/Lizentzia")
public class Lizentzia extends HttpServlet {
private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() Lizentzia");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() Lizentzia");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() Lizentzia");
    	
    	
    	String lizentzia = request.getParameter("lizentzia");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		
				
		
		mySQLdb.lizentziaEguneratu(username, lizentzia);
		System.out.println("     Updating users table in the database");
		
		System.out.println("     Redirecting the user to nagusia.html");
		response.sendRedirect("/IbanMayo/html/nagusia.html");
		
        System.out.println("---> Exiting doPost() Lizentzia");
    }
}

