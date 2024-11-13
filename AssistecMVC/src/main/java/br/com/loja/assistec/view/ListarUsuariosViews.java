package br.com.loja.assistec.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

import br.com.loja.assistec.controller.ListarUsuarioController;
import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioTableModel;

public class ListarUsuariosViews extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLocalizar;
	private JButton btnCadastrar;
	private JButton btnFechar;
	private JTable tabela;
	private ArrayList<Usuario> usuariosList;
	private ListarUsuariosViews listarUsusariosView;
	private UsuarioTableModel usuarioTableModel;
	private TableRowSorter<UsuarioTableModel> rowSorter;
	private JScrollPane scrolPane;

	public ListarUsuariosViews() {
		iniciarlizarComponentes();
		configurarJanela();
	}

	public void iniciarlizarComponentes() {
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(39, 34, 117, 23);
		btnCadastrar.setActionCommand("BotaoCadastrarAction");
		
		txtLocalizar = new JTextField();
		txtLocalizar.setBounds(139, 12, 252, 20);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBounds(189, 216, 89, 23);
		btnFechar.setActionCommand("BotaoFecharAction");
		
		tabela = new JTable();
		scrolPane = new JScrollPane(tabela);
		scrolPane.setBounds(39, 95, 350, 215);
		
		getContentPane().setLayout(null);
		getContentPane().add(btnCadastrar);
		getContentPane().add(btnFechar);
		getContentPane().add(txtLocalizar);
		getContentPane().add(scrolPane);
		
	}
	
	public void configurarJanela() { 
		setTitle("Listagem de usuários");
		setBounds(100, 100, 650, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addListarUsuariosListener(ActionListener listener) {
		
		btnCadastrar.addActionListener(listener);
		btnFechar.addActionListener(listener);
	}
}