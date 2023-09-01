package com.joaomaciel.project.carrinho.compra.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoUtil {

	private static final String URL_CONEXAO = "jdbc:mysql://localhost:3306/project_carrinho_compra?useTimezone=true&serverTimezone=UTC";
	private static final String USUARIO = "joao";
	private static final String SENHA = "Joao09011997!";

	private static Connection conexao = null;

	public ConexaoUtil() {

	}

	public static Connection conectar() {
		try {
			if (conexao == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return conexao;
	}
}