<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Pasahitza aldatu</title>
		<link href="/IbanMayo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>IBAN MAYO TXIRRINDULARITZA ELKARTEA</h1>
			<h3>Pasahitza aldatu:</h3>
		</header>
		<%
			if ((boolean) request.getAttribute("pasahitz okerra")){
		%>
		<section>
		<h1>Pasahitz okerra sartu duzu, ostabere saiatu:</h1>
		<h2>Ez hutsi hutsik!</h2>
		</section> <%
		}
		%>
			<form method="POST" action="/IbanMayo/servlet/PasahitzaAldatu">
				<table>
	   				<tr>
	   					<td>Pasahitz zaharra:</td>
	   					<td><input type="password" name="password1"/></td>
	   				</tr>				
	   				<tr>
	   					<td>Pasahitz berria:</td>
	   					<td><input type="password" name="password2"/></td>
	   				</tr>
	   				<tr>
	 			</table>
				<button>Aldatu</button>
			</form>
		</section>
		<footer>Askatasuna Kalea 6, Igorre</footer> 
	</body>
</html>