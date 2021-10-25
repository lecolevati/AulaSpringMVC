<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reserva</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
		<br />
	</div>
	<div>
		<form action="reserva" method="post">
			<c:if test="${not empty listaPratos }">
			<td><input type="number" id="codigoReserva" name="codigoReserva" min="0" placeholder="Código" required="required"></td>
			<br /><br />
			<table>
				<c:forEach items="${listaPratos }" var="p">
				<tr>
					<td><c:out value="${p.id }" /></td>
					<td><c:out value="${p.prato }" /></td>
					<td><c:out value="${p.valor }" /></td>
					<td><input type="number" id=${p.id } name=${p.id } min="0" size="5"></td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4"><input type="submit" value="Finalizar" id="button" name="button"></td>
				</tr>
			</table>
			</c:if>
		</form>
	</div>
	<div>
		<c:if test="${not empty erro }">
			<H2 style="color: red"><c:out value="${erro }" /></H2>
		</c:if>
	</div>
</body>
</html>