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
                    <li><a href="Controller?action=ProductOverview">Products</a></li>
                    <c:if test="${sessionScope.user.role == 'ADMIN'}">
                        <li><a href="Controller?action=PersonOverview">Overview</a></li>
                    </c:if>
                    <li><a href="signUp.jsp">Sign up</a></li>
                    <c:if test="${sessionScope.user.role == 'ADMIN'}">
                        <li><a href="Controller?action=AddPage">Voeg Toe</a></li>
                    </c:if>
                    <li id="actual"><a href="Controller?action=Cart">Shopping cart</a></li>
                    <li><a href="LogIn.jsp">Log in</a></li>
                </ul>
            </nav>
        </head>

    </header>
    <main>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            <c:forEach var="product" items="${cart}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <form method="post" action="Controller?action=UpdateQuantity&productId=${product.productId}" novalidate="novalidate">
                        <td><input min="1" type="number" id="quantity" name="quantity" value="${product.quantity}" /></td>
                        <td><input type="submit" name="updateQuantity" value="Update quantity"></td>
                    </form>
                    <td><a href="Controller?action=RemoveProductFromCart&productId=${product.productId}"> Remove</a></td>
                </tr>
            </c:forEach>
        </table>

        <br>
        <p><b>Total price: ${requestScope.totalPrice}</b></p>
        <p>Aantal items in wagentje: ${requestScope.items}</p>


        <form action="Controller?action=PayCart" method="post">
            <input type="submit" name="Pay" value="Pay Cart">
        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>