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

        <p>Wilt u checken of u password juist is?</p>
        <br>
        <p>${person.firstName} ${person.lastName}</p>

        <c:if test="${requestScope.message==null}">
            <br>
            <p>Fill in the password:</p>

            <form method="post" action="Controller?action=CheckPasswordConfirmation&userid=${person.userid}" novalidate="novalidate">
                <!-- novalidate in order to be able to run tests correctly -->
                <p>
                    <input type="password" name="password">
                </p>
                <p>
                    <input type="submit" name="check" value="Check password">
                </p>

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
