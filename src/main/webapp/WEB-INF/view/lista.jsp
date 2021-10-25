<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
		<br />
	</div>
	<div>
		<form action="lista" method="post">
			<table>
			<tr>
				<td><input type="number" id="codigoReserva" name="codigoReserva" min="0" placeholder="Código" required="required"></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="Buscar" id="button" name="button"></td>
			</tr>			
			</table>
			<br /><br />
			
			<c:if test="${not empty listaPratoReserva }">
			<table border="1">
				<thead>
					<tr>
						<th>ID Prato</th>
						<th>Nome Prato</th>
						<th>Valor Prato</th>
						<th>Quantidade</th>
					</tr>
				</thead>
				<c:forEach items="${listaPratoReserva }" var="pr">
				<tr>
					<td><c:out value="${pr.prato.id }" /></td>
					<td><c:out value="${pr.prato.prato }" /></td>
					<td><c:out value="${pr.prato.valor }" /></td>
					<td><c:out value="${pr.quantidade }" /></td>
				</tr>
				</c:forEach>
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