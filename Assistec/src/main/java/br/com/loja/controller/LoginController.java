package br.com.loja.controller;

import javax.swing.JOptionPane;

import br.com.loja.Assistec.model.UsuarioModel;
import br.com.loja.Assistec.view.LoginView;

public class LoginController {
	
	private LoginView view;
	private UsuarioModel model;
	
	public LoginController(LoginView view) {
		this.view = view;
		this.model = new UsuarioModel();
		
		if(model.conexao != null) {
			view.lblStatus.setText("Conectado ao banco de dados");
			System.out.println("Conectado no Banco");
		}else {
			view.lblStatus.setText("Conectado ao banco de dados");
			System.out.println("Não conectado");
		}
		//this.view.btnLogin.addActionListener(logar());
	}
	
	public void logar() {
		String login = view.txtUsuario.getText();
		String senha = new String(view.password.getPassword());
		String perfil = model.autenticar(login, senha);
		
		if(perfil != null) {
			JOptionPane.showMessageDialog(null, "Dados acessados");
		}else {
			JOptionPane.showMessageDialog(null, "Login ou Senha invalidos");
		}
	}
}
