package br.com.loja.assistec.controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;
import br.com.loja.assistec.view.CadastrarUsuariosView;
import br.com.loja.assistec.view.MessagemView;

public class CadastrarUsuarioController {
	
	private CadastrarUsuariosView cadastrarView;
	private ListarUsuarioController listarController;
	private Usuario usuarioSelecionado; 
	
	public CadastrarUsuarioController(ListarUsuarioController listarUsuarioController, Usuario user) {
		
		this.usuarioSelecionado = user;
		this.listarController = listarUsuarioController;
		cadastrarView = new CadastrarUsuariosView(user);
		cadastrarView.setLocationRelativeTo(null);
		cadastrarView.setVisible(true);
		configurarListeners();
	}
	
	private void configurarListeners() {
		cadastrarView.addCadastrarUsuariosLiteners(new CadastrarUsuarioListener());
		cadastrarView.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e){
				if(usuarioSelecionado!=null) {
					cadastrarView.preencherCampos(usuarioSelecionado);
					cadastrarView.habilitarBotaoExcluir(true);
				}
			}
		});
	}
	private class CadastrarUsuarioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch (e.getActionCommand()) {
			case "BotaoFecharAction":
				cadastrarView.dispose();
			break;
			case "BotaoExcluirAction":
				Excluir();
				break;
			case "BotaoIncluirAction":
				try {
					NovoOuAlterar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			}
		}
		
		private void NovoOuAlterar() throws SQLException {
			// TODO Auto-generated method stub
			String perfil = (String) cadastrarView.getPerfilSelecionado();
			if (usuarioSelecionado == null) {
				incluir(cadastrarView.getNome(), cadastrarView.getFone(), 
						cadastrarView.getLogin(), cadastrarView.getSenha(), perfil);
				new MessagemView("Registro inserido com sucesso", 3);
			}else {
				alterar(usuarioSelecionado.getIduser(), cadastrarView.getNome(),
						cadastrarView.getFone(), cadastrarView.getLogin(), cadastrarView.getSenha(), perfil);
				new MessagemView("Usuario Alterado!", 3);
			}
			atualizarListaUsuarios();
		}

		private void alterar(long iduser, String nome, String fone, String login, String senha, String perfil) throws SQLException {
			// TODO Auto-generated method stub
			Usuario user = new Usuario(iduser, nome, fone, login, senha, perfil);
			new UsuarioDAO().alterar(user);
		}

		private void incluir(String nome, String fone, String login, String senha, String perfil) throws SQLException {
			// TODO Auto-generated method stub
			Usuario user = new Usuario(nome, fone, login, senha, perfil);
			new UsuarioDAO().salvar(user);
		}

		private void atualizarListaUsuarios() throws SQLException {
			ArrayList<Usuario> novosUsuarios = listarController.listarUsuarios(); 
			listarController.atualizarTabela(novosUsuarios);
		}

		private void Excluir() {
			// TODO Auto-generated method stub
			MessagemView mv = new MessagemView("Tem Certeza que quer Excluir?");
			int confirma = mv.getResposta();
			if(confirma ==1) {
				try {
					excluir(usuarioSelecionado.getIduser());
					new MessagemView("Usuario Excluido", 3);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					new MessagemView("Erro ao Excluir Usuario", 0);
				}
			}
		}

		private void excluir(long iduser) throws SQLException{
			// TODO Auto-generated method stub
			new UsuarioDAO().excluir(iduser);
		}
		
		
	}
}
