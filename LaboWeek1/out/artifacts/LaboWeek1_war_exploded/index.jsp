<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		<header>
			<h1>
				<span>Web shop</span>
			</h1>
			<jsp:include page="header.jsp"></jsp:include>
			<h2>${param.title}</h2>

		</header>
		<main> Sed ut perspiciatis unde omnis iste natus error sit
		voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque
		ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae
		dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
		aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos
		qui ratione voluptatem sequi nesciunt.<br><br>

            <form method="post" action="Controller?action=ShowQuote">
                <p>Do you want to see a quote?</p>
               <p> <input type="radio" name="quote" value="Yes" ${YesChecked}> Yes
				<input type="radio" name="quote" value="No" ${NoChecked}> No</p>
				<p><input type="submit" name="showQuote" value="Send"></p>
            </form>

            <c:if test="${quote=='Yes'}">
                <p><b>Zelfkennis is het begin van alle wijsheid</b></p>
            </c:if>
			<c:if test="${user!=null}">
				<p>Welkom ${user.firstName}</p>
			</c:if>
        </main>
		<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
	</div>
    <br>

</body>
</html>