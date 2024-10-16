package br.com.loja.Assistec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarUsersView extends JFrame {
	private JTextField txtCadastrar;

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
	public ListarUsersView() {
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(btnCadastrar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtCadastrar, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(198, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(171))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCadastrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrar))
					.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}
