package br.com.loja.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.Assistec.model.LoginDAO;
import br.com.loja.Assistec.model.Usuario;

public class LoginController {

	public LoginController() {

		
	}
	public Boolean verificarBancoOnLine() throws SQLException {
		LoginDAO  dao = new LoginDAO();
		return dao.bancoOnLine();
	}
	
	public ArrayList<String> autenticar(String login, String senha) throws SQLException{
		
		ArrayList<String> listaDados = new ArrayList();
		LoginDAO dao = new LoginDAO();
		Usuario user = dao.autenticar(login, senha);
		listaDados.add(0, user.getNome());
		listaDados.add(1, user.getPerfil());
		
		
		return listaDados;
	}
}
