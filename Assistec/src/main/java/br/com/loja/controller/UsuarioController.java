package br.com.loja.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.Assistec.model.Usuario;
import br.com.loja.Assistec.model.UsuarioDAO;

public class UsuarioController {

	public UsuarioController() {

	}

	public ArrayList<Usuario> listarUsuario() throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.selecionarUsuarios();
	}
	public void salvar(String nome, String fone, String login, String senha, String perfil) throws SQLException {
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setFone(fone);
		user.setLogin(login);
		user.setSenha(senha);
		user.setPerfil(perfil);
		
		new UsuarioDAO().salvar(user);
	}
}