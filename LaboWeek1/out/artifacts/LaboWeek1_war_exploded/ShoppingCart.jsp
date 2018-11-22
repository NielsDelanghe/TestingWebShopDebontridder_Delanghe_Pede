<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Product Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <jsp:include page="header.jsp"></jsp:include>
        <h2>${param.title}</h2>

    </header>
    <main>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach var="product" items="${cart}">
                <tr>
                    <td><a href="Controller?action=ProductUpdate&productId=${product.productId}">${product.name}</a> </td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td><a href="Controller?action=RemoveProductFromCart&productId=${product.productId}"> Remove(werkt niet)</a></td>
                </tr>
            </c:forEach>
        </table>

        <br>
        <p><b>Total price: ${requestScope.totalPrice}</b></p>


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