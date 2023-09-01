package com.joaomaciel.project.carrinho.compra.model;

import java.io.Serializable;
import java.util.Objects;

public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idMenu;
	private String nome;
	private String link;
	private Integer exibir;

	public Menu() {

	}

	public Menu(Integer idMenu, String nome, String link, Integer exibir) {
		this.idMenu = idMenu;
		this.nome = nome;
		this.link = link;
		this.exibir = exibir;
	}

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getExibir() {
		return exibir;
	}

	public void setExibir(Integer exibir) {
		this.exibir = exibir;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMenu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		return Objects.equals(idMenu, other.idMenu);
	}
}