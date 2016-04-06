<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*, helper.db.*" %>
<%
	MySQLdb mySQLdb = new MySQLdb();

	String username = (String) session.getAttribute("username");
	String email = mySQLdb.getEmail(username);
	
	ArrayList<Object> userInfo = mySQLdb.getInformazioa(email);
	%>

<html>
	<head>
		<title>Eguneratu</title>
		<link href="/IbanMayo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>IBAN MAYO TXIRRINDULARITZA ELKARTEA</h1>
			<h3>Elkartearen datuak eguneratu:</h3>
		</header>
		<section>
			<form method="POST" action="/IbanMayo/servlet/KontuaEguneratu">
				<table>
	 				<tr>
	   					<td>Izena:</td>
	   					<td><input name="name" value="<%= userInfo.get(0) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Lehenengo abizena:</td>
	   					<td><input name="surname1" value="<%= userInfo.get(1) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Bigarren abizena:</td>
	   					<td><input name="surname2" value="<%= userInfo.get(2) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Kalea:</td>
	   					<td><input name="kalea" value="<%= userInfo.get(3) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Herria:</td>
	   					<td><input name="city" value="<%= userInfo.get(4) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Telefono zenbakia:</td>
	   					<td><input name="zenbakia" value="<%= userInfo.get(5) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>NAN-a:</td>
	   					<td><input name="nan" value="<%= userInfo.get(6) %>"></td>
	   				</tr>
	   				<tr>
	   					<td>Txirrindulari taldea:</td>
	   					<td><input name="taldea" value="<%= userInfo.get(7) %>"></td>
	   				</tr>
	 			</table>
				<button>Bidali</button>
			</form>
		</section>
		<footer>Askatasuna Kalea 6, Igorre</footer> 
	</body>
</html>