<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Check Persoon</title>
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
        <c:if test="${user==null}">
        <p>Log in</p>

            <form method="post" action="Controller?action=LogIn" novalidate="novalidate">
                <!-- novalidate in order to be able to run tests correctly -->
                <p>User id
                    <input type="text" name="userid">
                </p>

                <p>password
                    <input type="password" name="password">
                </p>
                <p>
                    <input type="submit" name="Login" value="Log in">
                </p>

            </form>
        </c:if>

        <c:if test="${user!=null}">
            <p>U bent aangemeld als ${user.firstName}</p>
            <form method="post" action="Controller?action=LogOut">
                <input type="submit" name="logout" value="LogOut">
            </form>
        </c:if>

        <c:if test="${message!=null}">
            <br><br>
            <p><b>${requestScope.message}</b></p>
        </c:if>

    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
