package br.com.loja.controller;

import java.sql.SQLException;

import br.com.loja.Assistec.model.LoginDAO;

public class LoginController {

	public LoginController() {

		
	}
	public Boolean verificarBancoOnLine() throws SQLException {
		LoginDAO  dao = new LoginDAO();
		return dao.bancoOnLine();
	}
}
