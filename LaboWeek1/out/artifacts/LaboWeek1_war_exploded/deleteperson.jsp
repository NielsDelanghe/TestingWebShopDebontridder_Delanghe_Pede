<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Verwijder persoon</title>
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

        <p>Bent u zeker dat u deze persoon wilt verwijderen?</p>
        <p>${person.firstName} ${person.lastName}</p>


        <form method="post" action="Controller?action=DeletePersonConfirmation&userid=${person.userid}" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            <p>
                <input type="submit" name="submit" value="Ja"> <input
                    type="submit" name="submit" value="Neen">
            </p>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
