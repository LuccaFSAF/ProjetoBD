package br.com.loja.Assistec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PrincipalView extends JFrame {

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { PrincipalView frame = new
	 * PrincipalView(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public PrincipalView(String user, String perfil) {
		setTitle("Sistema de Gestão do Fábio");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblUser = new JLabel("");

		JLabel lblPerfil = new JLabel("");

		JLabel lblNewLabel = new JLabel("-");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblUser)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblPerfil)
						.addContainerGap(296, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(214, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblUser)
								.addComponent(lblPerfil).addComponent(lblNewLabel))
						.addContainerGap()));
		getContentPane().setLayout(groupLayout);
		lblUser.setText(user);
		lblPerfil.setText(perfil);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu MenuArq = new JMenu("Arquivo");
		menuBar.add(MenuArq);

		JMenuItem MenuSair = new JMenuItem("Sair");
		MenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, "Tem certexa que vai sair?", "Atenção",
						JOptionPane.YES_NO_OPTION);
				if (sair == 0) {
					System.exit(0);
				}
			}
		});
		MenuArq.add(MenuSair);

		JMenu MenuCadastro = new JMenu("Cadastro");
		MenuCadastro.setEnabled(false);
		menuBar.add(MenuCadastro);

		JMenuItem menuUser = new JMenuItem("Usuarios");
		menuUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuarios();
			}
		});
		MenuCadastro.add(menuUser);

		JMenu MenuRelatorio = new JMenu("Relatorios");
		MenuRelatorio.setEnabled(false);
		menuBar.add(MenuRelatorio);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		MenuRelatorio.add(mntmNewMenuItem);

		JMenu MenuSoS = new JMenu("Ajuda");
		menuBar.add(MenuSoS);

		JMenuItem menuSobre = new JMenuItem("Sobre");
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sistema de Gestão para o Fábio! - Versão Doce de Aboborá");
			}
		});
		MenuSoS.add(menuSobre);

		if ("admin".equalsIgnoreCase(perfil)) {
			MenuCadastro.setEnabled(true);
			MenuRelatorio.setEnabled(true);
		}
	}
	protected void ListarUsuarios() {
		// TODO Auto-generated method stub
		ListarUsersView frame = new ListarUsersView();
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
