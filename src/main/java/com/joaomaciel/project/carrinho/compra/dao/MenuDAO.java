package com.joaomaciel.project.carrinho.compra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.joaomaciel.project.carrinho.compra.conexao.ConexaoUtil;
import com.joaomaciel.project.carrinho.compra.model.Menu;

public class MenuDAO {

	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private StringBuilder sqlQuery = null;
	private Connection conexao = null;

	public MenuDAO() {
		conexao = ConexaoUtil.conectar();
	}

	public void inserirOuAtualizarMenu(Menu menu) {
		if (menu.getIdMenu() == null) {
			inserirMenu(menu);
		} else {
			atualizarMenu(menu);
		}
	}

	public void inserirMenu(Menu menu) {
		try {
			sqlQuery = new StringBuilder();
			sqlQuery.append("INSERT INTO menu (nome, link, exibir) VALUES (?, ?, ?)");

			preparedStatement = conexao.prepareStatement(sqlQuery.toString());
			preparedStatement.setString(1, menu.getNome());
			preparedStatement.setString(2, menu.getLink());
			preparedStatement.setInt(3, menu.getExibir());

			preparedStatement.executeUpdate();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void atualizarMenu(Menu menu) {
		try {
			sqlQuery = new StringBuilder();
			sqlQuery.append("UPDATE menu SET nome = ?, link = ?, exibir = ? WHERE idMenu = ?");

			preparedStatement = conexao.prepareStatement(sqlQuery.toString());
			preparedStatement.setString(1, menu.getNome());
			preparedStatement.setString(2, menu.getLink());
			preparedStatement.setInt(3, menu.getExibir());
			preparedStatement.setInt(4, menu.getIdMenu());

			preparedStatement.executeUpdate();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void removerMenuPorId(Integer idMenu) {
		try {
			sqlQuery = new StringBuilder();
			sqlQuery.append("DELETE FROM menu m WHERE m.idMenu = ?");

			preparedStatement = conexao.prepareStatement(sqlQuery.toString());
			preparedStatement.setInt(1, idMenu);

			preparedStatement.executeUpdate();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public Set<Menu> listarTodosOsMenus() {
		Set<Menu> menus = new HashSet<Menu>();

		try {
			sqlQuery = new StringBuilder();
			sqlQuery.append("SELECT * FROM vw_menu vm");

			preparedStatement = conexao.prepareStatement(sqlQuery.toString());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Menu menu = new Menu();
				menu.setIdMenu(resultSet.getInt("idMenu"));
				menu.setNome(resultSet.getString("nome"));
				menu.setLink(resultSet.getString("link"));
				menu.setExibir(resultSet.getInt("exibir"));

				menus.add(menu);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return menus;
	}

	public Menu listarMenuPorId(Integer idMenu) {
		Menu menu = null;

		try {
			sqlQuery = new StringBuilder();
			sqlQuery.append("SELECT * FROM vw_menu vm WHERE vm.idMenu = ?");

			preparedStatement = conexao.prepareStatement(sqlQuery.toString());
			preparedStatement.setInt(1, idMenu);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				menu = new Menu();
				menu.setIdMenu(resultSet.getInt("idMenu"));
				menu.setNome(resultSet.getString("nome"));
				menu.setLink(resultSet.getString("link"));
				menu.setExibir(resultSet.getInt("exibir"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return menu;
	}
}