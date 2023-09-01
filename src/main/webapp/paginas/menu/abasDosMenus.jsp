<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Início</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-5.0.2/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/estilo/menu.css" type="text/css">
</head>
<body>
	<div class="menu">
		<ul>
			<li><a
				href="<%=request.getContextPath()%>/MenuServlet?acao=listarMenu">Menu</a></li>
			<li><a
				href="<%=request.getContextPath()%>/PerfilServlet?acao=listarPerfil">Perfil</a></li>
			<li><a
				href="<%=request.getContextPath()%>/UsuarioServlet?acao=listarUsuario">Usuário</a></li>
		</ul>
	</div>
</body>
</html>