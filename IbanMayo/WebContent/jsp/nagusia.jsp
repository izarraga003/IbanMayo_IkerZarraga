<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String username = (String) session.getAttribute("username");
   ServletContext context = request.getServletContext();
   HashMap<String, String> loggedinUsers = (HashMap) context.getAttribute("loggedin_users"); %>
<html>
	<head>
		<title>nagusia</title>
		<link href="/IbanMayo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>IBAN MAYO TXIRRINDULARITZA ELKARTEA</h1>
			<h3>Orrialde Nagusia</h3>
		</header>
		<section>
		<a href="/IbanMayo/servlet/MainServlet?action=logout" style="text-decoration: none">
				<font color="white">Logout</font>
		</a>
		<table>		
					<th>
					Aukeratu egin nahi duzuna ;)
					</th>
					<tr>
						<td>
						<a href="/IbanMayo/html/pasahitzaAldatu.html" style="text-decoration: none">
						<font color="white">Pasahitza aldatu</font>
						</a>
						</td>
					</tr>
					<tr>
						<td>
						<a href="/IbanMayo/jsp/eguneratu.jsp" style="text-decoration: none">
						<font color="white">Zure kontua eguneratu</font>
						</a>
						</td>
					</tr>
					<tr>
						<td>
						<a href="/IbanMayo/servlet/PdfServlet" style="text-decoration: none">
						<font color="white">PDF zertifikatua lortu</font>
						</a>
						</td>
					</tr>
					<tr>
						<td>
						<a href="/IbanMayo/html/lizentzia.html" style="text-decoration: none">
						<font color="white">Lizentzia berria eskatu edo eguneratu</font>
						</a>
						</td>
					</tr>
	 			</table>
		</section>
		<footer>Askatasuna Kalea 6, Igorre</footer> 
	</body>
</html>