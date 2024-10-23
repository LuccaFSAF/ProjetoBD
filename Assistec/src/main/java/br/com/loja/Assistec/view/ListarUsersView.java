package br.com.loja.Assistec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import br.com.loja.Assistec.model.Usuario;
import br.com.loja.Assistec.model.UsuarioTableModel;
import br.com.loja.controller.UsuarioController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ListarUsersView extends JFrame {
	private JTextField txtCadastrar;
	private JTable table;
	private ArrayList<Usuario> usuariosList;
	private UsuarioTableModel usuariosTableModel;
	private ListarUsersView listarUsuariosviews;
	private TableRowSorter<UsuarioTableModel> rowSorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsersView frame = new ListarUsersView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListarUsersView() throws SQLException {
		this.listarUsuariosviews = this;
		usuariosList = new ArrayList();
		UsuarioController uc = new UsuarioController();
		usuariosList = uc.listarUsuario();

		setTitle("Listagem de Doce de Leite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUserView tela = new CadastrarUserView();
				tela.setLocationRelativeTo(tela);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				tela.setVisible(true);
			}
		});

		txtCadastrar = new JTextField();
		txtCadastrar.setColumns(10);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap(198, Short.MAX_VALUE)
										.addComponent(btnFechar).addGap(171))
								.addGroup(groupLayout.createSequentialGroup().addGap(41).addComponent(btnCadastrar)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtCadastrar, GroupLayout.PREFERRED_SIZE, 236,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(66, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(scrollPane)
										.addGap(19)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(33)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCadastrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCadastrar))
						.addGap(18).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnFechar).addContainerGap()));

		usuariosTableModel = new UsuarioTableModel(usuariosList);
		table = new JTable();
		table.setModel(usuariosTableModel);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}