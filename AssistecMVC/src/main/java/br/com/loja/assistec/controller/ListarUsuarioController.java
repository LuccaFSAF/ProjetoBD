package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;
import br.com.loja.assistec.view.ListarUsuariosViews;

public class ListarUsuarioController {
	private ListarUsuariosViews listarView;
	
		public ListarUsuarioController() {
			listarView = new ListarUsuariosViews();
			listarView.setLocationRelativeTo(null);
			listarView.setResizable(true);
			configurarListener();
			carregarUsuarios();
		}
		
		public void configurarListener();{
			listarView.addListarUsuariosListener(new ListarUsuariosListener());
			listarView.addWindowListener(new JanelaAberturaListener());
		}
		public void carregarUsuarios() {
			
		}
		
		private class ListarUsuariosListenre implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				
				String comando = e.getActionCommand();
				switch (comando) {
				case "BotaoCadastrarAction": 
					abrirComandoListener(null);
				break;
				case "BotaoFecharListener":
					listarView.dispose();
				break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + comando);
				}
			}
		}

}