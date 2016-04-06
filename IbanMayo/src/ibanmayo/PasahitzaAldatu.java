package ibanmayo;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;

/**
 * Servlet implementation class PasahitzaAldatu
 */
@WebServlet("/PasahitzaAldatu")
public class PasahitzaAldatu extends HttpServlet {
private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() SignupServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() SignupServlet");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() SignupServlet");
    	
    	HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String email = mySQLdb.getEmail(username);
		String pass = mySQLdb.getPassword(username);
    	
    	String passwordZ = request.getParameter("password1");
		String passwordB = request.getParameter("password2");
		if (passwordZ.equals(pass) && (!passwordB.equals(""))){
			mySQLdb.pasahitzaEguneratu(email, passwordZ, passwordB);
			response.sendRedirect("/IbanMayo/html/nagusia.html");
			session.invalidate();
		}
		else{
			System.out.println("Pasahitz okerra---> redirecting user to pasahitzaAldatu.html");
			boolean okerra =  true;
			request.setAttribute("pasahitz okerra", okerra);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/pasahitza.jsp");
			rd.forward(request, response);
		}
        System.out.println("---> Exiting doPost() PasahitzaAldatu");
    }
}

