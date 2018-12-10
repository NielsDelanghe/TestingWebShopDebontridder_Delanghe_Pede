<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Product Overview</title>
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
        <c:if test="${p!=null}">
            <div class="product-added">
                <ul>
                    <li>Product is toegevoegd aan je winkelmandje</li>
                </ul>
            </div>
        </c:if>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <c:if test="${user.getRole() =='ADMIN'}">
                        <td><a href="Controller?action=ProductUpdate&productId=${product.productId}">${product.name}</a> </td>
                        <td><a href="Controller?action=DeleteProduct&productId=${product.productId}"> Delete</a></td>
                    </c:if>
                    <c:if test="${user != null}">
                    <td><a href="Controller?action=AddToCart&productId=${product.productId}">Add to cart</a></td>
                    </c:if>
                </tr>
            </c:forEach>

            <caption>Users Overview</caption>
        </table>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>