<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/cssFile.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <head>
            <nav>
                <ul>
                    <li><a href="Controller">Home</a></li>
                    <li id="actual"><a href="Controller?action=ProductOverview">Products</a></li>
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


        <form method="post" action="Controller?action=DeleteProductConfirmation&productId=${product.getProductId()}" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            </p>
            <p><label for="name">Name</label><input type="text" id="name" name="name"
                                                    required
                                                    value="${requestScope.product.getName()}">
            </p>
            <p><label for="description">Description</label><input type="text" id="description" name="description"
                                                                  required
                                                                  value="${requestScope.product.getDescription()}">
            </p>
            <p><label for="price">Price</label><input type="email" id="price" name="price" required
                                                      value="${requestScope.product.getPrice()}">
            </p>
            <p><input type="submit" id="update" value="Update"></p>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
