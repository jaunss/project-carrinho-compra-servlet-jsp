<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Menus</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-5.0.2/css/bootstrap.min.css"
	type="text/css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/dataTables-1.13.4/jQuery-3.6.0/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<%@include file="/paginas/banner.jsp"%>
		<%@include file="/paginas/menu/abasDosMenus.jsp"%>

		<h3 class="text-center">${mensagem}</h3>
		<h3 class="text-center">Cadastro de Menus</h3>

		<form action="<%=request.getContextPath()%>/MenuServlet"
			class="row g-3 needs-validation" novalidate method="POST">
			<div class="container col-md-5">
				<input type="hidden" id="idMenu" name="idMenu"
					value="<c:out value="${menu.idMenu}"/>" />

				<div class="form-group">
					<label>Nome</label> <input type="text" id="nome" name="nome"
						value="<c:out value="${menu.nome}"/>" class="form-control"
						maxlength="40" required="required" autocomplete="off" />
					<div class="invalid-feedback">Nome do menu é obrigatório!</div>
					<div class="valid-feedback">Ok!</div>
				</div>

				<div class="form-group">
					<label>Link</label> <input type="text" id="link" name="link"
						value="<c:out value="${menu.link}"/>" class="form-control"
						maxlength="100" required="required" autocomplete="off" />
					<div class="invalid-feedback">Link do menu é obrigatório!</div>
					<div class="valid-feedback">Ok!</div>
				</div>

				<div class="form-group">
					<label>Exibir?</label> <select id="exibir" class="form-control"
						name="exibir" required="required">
						<option value="">Selecione se deseja exibir o menu</option>
						<option value="1"
							<c:if test="${menu.exibir == 1}">selected=""</c:if>>Sim</option>
						<option value="2"
							<c:if test="${menu.exibir == 2}">selected=""</c:if>>Não</option>
					</select>
					<div class="invalid-feedback">Exibir do menu é obrigatório!</div>
					<div class="valid-feedback">Ok!</div>
				</div>

				<br />

				<div class="text-center">
					<button type="submit" class="btn btn-success">Salvar Menu</button>
					<a href="<%=request.getContextPath()%>/MenuServlet?acao=listarMenu"
						class="btn btn-warning">Voltar</a>
				</div>
			</div>
		</form>
	</div>

	<script type="text/javascript">
		(function() {
			'use strict'

			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.querySelectorAll('.needs-validation')

			// Loop over them and prevent submission
			Array.prototype.slice.call(forms).forEach(function(form) {
				form.addEventListener('submit', function(event) {
					if (!form.checkValidity()) {
						event.preventDefault()
						event.stopPropagation()
					}

					form.classList.add('was-validated')
				}, false)
			})
		})()
	</script>
</body>
</html>