
package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;
import br.com.loja.assistec.view.ListarUsuariosViews;
import br.com.loja.assistec.view.MessagemView;
import br.com.loja.assistec.controller.CadastrarUsuarioController;


public class ListarUsuarioController {
	private ListarUsuariosViews listarView;

	public ListarUsuarioController() throws SQLException {
		listarView = new ListarUsuariosViews();
		listarView.setLocationRelativeTo(null);
		listarView.setVisible(true);
		configurarListeners();
		carregarUsuarios();
	}

	public void configurarListeners() {
		listarView.addListarUsuariosListener(new ListarUsuariosListener());
		listarView.addWindowListener(new JanelaAberturaListener());
		listarView.addMouseListener(new TabelaMouseClickListener());
	}
	
	private class TabelaMouseClickListener extends MouseAdapter{
		public void MouseClicar(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				System.out.println("Clicado!");
			}
		}
	}

	public void carregarUsuarios() throws SQLException {
		ArrayList<Usuario> listaUsuarios = listarUsuarios();

		try {
			if (!listaUsuarios.isEmpty()) {
				listarView.mostrarUsuarioTabela(listaUsuarios);
			}
		} catch (Exception e) {
			// TODO: handle exception
			new MessagemView("Erro ao carregar os usuários", 0);
		}

	}

	public ArrayList<Usuario> listarUsuarios() throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.selecionarUsuarios();
	}

	private class ListarUsuariosListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			switch (comando) {
			case "BotaoCadastrarAction":
				abrirCadastroUsuario(null);
				break;
			case "BotaoFecharAction":
				listarView.dispose();
				break;
			default:
				break;
			}
		}

	}

	public void abrirCadastroUsuario(Usuario usuarioSelecionado) {
		new CadastrarUsuarioController(this, usuarioSelecionado);
	}

	private class JanelaAberturaListener extends WindowAdapter {
		public void windowOpened(WindowEvent e) {
			try {
				carregarUsuarios();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
