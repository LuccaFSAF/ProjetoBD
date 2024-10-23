package br.com.loja.Assistec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import br.com.loja.controller.UsuarioController;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CadastrarUserView extends JFrame {
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtLogin;
	private final JLabel lblNewLabel_5 = new JLabel("Perfil:");
	private JPasswordField password;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUserView frame = new CadastrarUserView();
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
	public CadastrarUserView() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelUp = new JPanel();
		getContentPane().add(panelUp, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelUp.add(lblNewLabel);
		
		JPanel panelDown = new JPanel();
		getContentPane().add(panelDown, BorderLayout.SOUTH);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equalsIgnoreCase(txtLogin.getText()) &&(!"".equalsIgnoreCase(new String(password.getPassword())))) {
					UsuarioController uc = new UsuarioController();
					String perfil = (String) comboBox.getSelectedItem();
					try {
						uc.salvar(txtNome.getText(), txtFone.getText(), txtLogin.getText(), 
								 new String(password.getPassword()), perfil);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		panelDown.add(btnIncluir);
		
		JButton btnDelete = new JButton("Excluir");
		panelDown.add(btnDelete);
		
		JButton btnNewButton_2 = new JButton("Fechar");
		panelDown.add(btnNewButton_2);
		
		JPanel panelCentral = new JPanel();
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		panelCentral.add(lblNewLabel_2);
		
		txtNome = new JTextField();
		panelCentral.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fone:");
		panelCentral.add(lblNewLabel_1);
		
		txtFone = new JTextField();
		panelCentral.add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Login:");
		panelCentral.add(lblNewLabel_3);
		
		txtLogin = new JTextField();
		panelCentral.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha:");
		panelCentral.add(lblNewLabel_4);
		
		password = new JPasswordField();
		panelCentral.add(password);
		panelCentral.add(lblNewLabel_5);
		
		comboBox = new JComboBox();
		panelCentral.add(comboBox);

	}

}
