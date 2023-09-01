<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Início</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-5.0.2/css/bootstrap.min.css"
	type="text/css">
</head>
<body>
	<div class="container-fluid">
		<%@include file="/paginas/banner.jsp"%>
		<%@include file="/paginas/menu/abasDosMenus.jsp"%>

		<div class="text-center">${mensagem}</div>
		<h2 class="text-center">Página Inicial</h2>
	</div>
</body>
</html>