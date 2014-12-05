<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>

<html>
<head>My first example using Spring 3 MVC
</head>
<body>
	<h1>
		Welcone message :
		<c:out value="${message}">
		</c:out>
	</h1>
</body>
</html>
