package com.joaomaciel.project.carrinho.compra.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joaomaciel.project.carrinho.compra.dao.MenuDAO;
import com.joaomaciel.project.carrinho.compra.model.Menu;

@WebServlet(name = "/MenuServlet", urlPatterns = { "/MenuServlet" })
public class MenuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Menu menu = null;
	private MenuDAO menuDAO = null;
	private String mensagem = "";

	public MenuServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		menu = new Menu();
		menuDAO = new MenuDAO();

		if (acao.equalsIgnoreCase("mostrarCriarMenu")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/paginas/menu/criarMenu.jsp");
			requestDispatcher.forward(request, response);

		} else if (acao.equalsIgnoreCase("mostrarEditarMenu")) {
			String idMenu = request.getParameter("idMenu");

			menu.setIdMenu(idMenu != null && !idMenu.isEmpty() ? Integer.parseInt(idMenu) : null);
			menu = menuDAO.listarMenuPorId(menu.getIdMenu());

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/paginas/menu/criarMenu.jsp");
			request.setAttribute("menu", menu);
			requestDispatcher.forward(request, response);

		} else if (acao.equalsIgnoreCase("removerMenu")) {
			String idMenu = request.getParameter("idMenu");

			menu.setIdMenu(idMenu != null && !idMenu.isEmpty() ? Integer.parseInt(idMenu) : null);

			if (menu.getIdMenu() != null) {
				menuDAO.removerMenuPorId(menu.getIdMenu());
				mensagem = "Menu removido com sucesso!";

			} else {
				mensagem = "Ocorreu um problema ao tentar remover o Menu!";
			}

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/paginas/menu/listarMenu.jsp");
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("menus", menuDAO.listarTodosOsMenus());
			requestDispatcher.forward(request, response);

		} else if (acao.equalsIgnoreCase("listarMenu")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/paginas/menu/listarMenu.jsp");
			request.setAttribute("menus", menuDAO.listarTodosOsMenus());
			requestDispatcher.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		menu = new Menu();
		menuDAO = new MenuDAO();

		String idMenu = request.getParameter("idMenu");
		String nome = request.getParameter("nome");
		String link = request.getParameter("link");
		String exibir = request.getParameter("exibir");

		menu.setIdMenu(idMenu != null && !idMenu.isEmpty() ? Integer.parseInt(idMenu) : null);
		menu.setNome(nome);
		menu.setLink(link);
		menu.setExibir(exibir != null && !exibir.isEmpty() ? Integer.parseInt(exibir) : null);

		if (menu != null) {

			if (menu.getIdMenu() != null) {
				menuDAO.inserirOuAtualizarMenu(menu);
				mensagem = "Menu atualizado com sucesso!";

			} else {
				menuDAO.inserirOuAtualizarMenu(menu);
				mensagem = "Menu inserido com sucesso!";
			}

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/paginas/menu/listarMenu.jsp");
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("menus", menuDAO.listarTodosOsMenus());
			requestDispatcher.forward(request, response);

		} else {
			mensagem = "Não foi possível adicionar o Menu!";

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/paginas/menu/criarMenu.jsp");
			request.setAttribute("mensagem", mensagem);
			requestDispatcher.forward(request, response);
		}
	}
}