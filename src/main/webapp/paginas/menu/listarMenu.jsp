<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Menus</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-5.0.2/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/dataTables-1.13.4/css/jquery.dataTables.min.css"
	type="text/css" />

<script type="text/javascript">
	function confirmarExclusao(idMenu, nome) {
		var confirmarExclusaoMenu = confirm("Deseja realmente remover o Menu "
				+ nome + "?");
		if (confirmarExclusaoMenu == true) {
			location.href = "MenuServlet?acao=removerMenu&idMenu=" + idMenu;
		}
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<%@include file="/paginas/banner.jsp"%>
		<%@include file="/paginas/menu/abasDosMenus.jsp"%>

		<div class="text-center">${mensagem}</div>
		<h3 class="text-center">Listagem de Menus</h3>

		<table id="idListaMenu"
			class="table table-hover table-striped table-bordered display">
			<thead>
				<tr>
					<th class="text-center">Nome</th>
					<th class="text-center">Link</th>
					<th class="text-center">Exibir?</th>
					<th class="text-center">Editar</th>
					<th class="text-center">Remover</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="menu" items="${menus}">
					<tr>
						<td class="text-center"><c:out value="${menu.nome}" /></td>
						<td class="text-center"><c:out value="${menu.link}" /></td>
						<td class="text-center"><c:if test="${menu.exibir == 1}">Sim</c:if>
							<c:if test="${menu.exibir == 2}">Não</c:if></td>
						<td class="text-center"><a
							href="MenuServlet?acao=mostrarEditarMenu&idMenu=<c:out value="${menu.idMenu}"/>"><img
								src="<%=request.getContextPath()%>/icons/pencil.svg"
								alt="Atualizar Menu" title="Atualizar Menu"></a></td>
						<td class="text-center"><a
							onclick="confirmarExclusao('${menu.idMenu}','${menu.nome}')">
								<img src="<%=request.getContextPath()%>/icons/trash.svg"
								alt="Remover Menu" title="Remover Menu">
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<script type="text/javascript"
			src="<%=request.getContextPath()%>/dataTables-1.13.4/jQuery-3.6.0/jquery-3.6.0.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/dataTables-1.13.4/js/jquery.dataTables.min.js"></script>

		<script type="text/javascript">
			$(document)
					.ready(
							function() {
								$("#idListaMenu")
										.dataTable(
												{
													"bJQueryUI" : true,
													"oLanguage" : {
														"sProcessing" : "Processando...",
														"sLengthMenu" : "Mostar _MENU_ de registros",
														"sZeroRecords" : "Não foram encontrados resultados",
														"sInfo" : "Mostrar de _START_ até _END_ de _TOTAL_ de registros",
														"sInfoEmpty" : "Mostrando de 0 até 0 de 0 registros",
														"sInfoFiltered" : "",
														"sInfoPostFix" : "",
														"sSearch" : "Pesquisar",
														"sUrl" : "",
														"oPaginate" : {
															"sFirst" : "Primeiro",
															"sPrevious" : "Anterior",
															"sNext" : "Próximo",
															"sLast" : "Último"
														}
													}
												});
							});
		</script>

		<a
			href="<%=request.getContextPath()%>/MenuServlet?acao=mostrarCriarMenu"
			class="btn btn-primary">Adicionar Novo Menu</a>
	</div>
</body>
</html>