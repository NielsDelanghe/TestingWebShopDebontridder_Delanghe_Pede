<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Sign Up</title>
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
        <div class="alert-danger">
            <ul>
                <li>Some error</li>
                <c:forEach var="error" items="${errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>

        <form method="post" action="Controller?action=SignUp" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="userid">User id</label><input type="text" id="userid" name="userid"
                                                         required
                                                         value="<c:out value='${requestScope.PreId !=null ? requestScope.PreId:""}'/>">
            </p>
            <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName"
                                                               required
                                                               value="<c:out value='${requestScope.PreFname !=null ? requestScope.PreFname:""}'/>">
            </p>
            <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName"
                                                             required
                                                             value="<c:out value=' ${requestScope.PreLname !=null ? requestScope.PreLname:""}'/>">
            </p>
            <p><label for="email">Email</label><input type="email" id="email" name="email" required
                                                      value="<c:out value=' ${requestScope.PreEmail !=null ? requestScope.PreEmail:""}'/>">
            </p>
            <p><label for="password">Password</label><input type="password" id="password" name="password"
                                                            required
                                                            value="<c:out value='${requestScope.PrePass !=null ? requestScope.PrePass:""}'/>">
            </p>
            <p><input type="submit" id="signUp" value="Sign Up"></p>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
