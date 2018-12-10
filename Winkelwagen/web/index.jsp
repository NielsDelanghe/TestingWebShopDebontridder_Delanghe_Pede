<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <title>Home</title>
  <link rel="stylesheet" type="text/css" href="css/cssFile.css">
</head>
<body>
<div id="container">
  <header>
    <h1>
      <span>Web shop</span>
    </h1>
    <head>
      <nav>
        <ul>
          <li id="actual"><a href="Controller">Home</a></li>
          <li><a href="Controller?action=ProductOverview">Products</a></li>
          <c:if test="${sessionScope.user.role == 'ADMIN'}">
            <li><a href="Controller?action=PersonOverview">Overview</a></li>
          </c:if>
          <li><a href="signUp.jsp">Sign up</a></li>
          <c:if test="${sessionScope.user.role == 'ADMIN'}">
            <li><a href="Controller?action=AddPage">Voeg Toe</a></li>
          </c:if>
          <li><a href="Controller?action=Cart">Shopping cart</a></li>
          <li><a href="LogIn.jsp">Log in</a></li>
        </ul>
      </nav>
    </head>
  </header>
  <main>

    <c:if test="${notAuthorized!=null }">
      <p class="alert-danger">${notAuthorized }</p>
    </c:if>

    <h2>Welkom bij onze webshop</h2>
    <br>
    <p>Bij deze webshop kan je een variatie van producten kopen en bekijken. Alle producten worden wereldwijd verscheept over heel de wereld.</p>
    <p>Om producten te bestellen moet je aangemeld zijn, dit kan je doen door naar ons inlog formulier te gaan. Als je nog geen account hebt kan je er altijd één aanmaken bij het sign up formulier.</p>
    <p>Alvast bedankt voor het gebruik maken van deze website.</p>

    <c:if test="${user!=null}">
      <p>Welkom ${user.firstName} ${user.getRole()}</p>
    </c:if>
  </main>
  <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
</div>
<br>

</body>
</html>