package br.com.loja.assistec.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MessagemView extends JDialog {

	private static final long serialVersionUID = 1L;
	private int resposta;
	
	public MessagemView(String mensagem, int tipo) {

		setTitle("Mensagem");
		setModal(true);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);

		JLabel lblMensagem = new JLabel(mensagem, SwingConstants.CENTER);
		panel.add(lblMensagem, BorderLayout.CENTER);

		String iconPath;
		switch (tipo) {
		case 0: // Erro
			iconPath = "/br/com/loja/assistec/icones/erro.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 1: // Informação
			iconPath = "/br/com/loja/assistec/icones/info.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 2: // Atenção
			iconPath = "/br/com/loja/assistec/icones/alerta.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 3: // Sucesso
			iconPath = "/br/com/loja/assistec/icones/sucesso.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 10: // Assistec
			iconPath = "/br/com/loja/assistec/icones/assistec.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}

		JPanel panelsul = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelsul.add(new JPanel());
		JButton btnOK = new JButton("OK");
		btnOK.setPreferredSize(new Dimension(100, 30));
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		panelsul.add(btnOK);
		panelsul.add(new JPanel());
		panelsul.setBorder(new EmptyBorder(10, 10, 20, 20));
		getRootPane().setDefaultButton(btnOK);
		panel.add(panelsul, BorderLayout.SOUTH);
		setSize(350, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public MessagemView(String pergunta) {
		setTitle("Mensagem");
		setModal(true);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);
		
		JLabel lblPergunta = new JLabel(pergunta, SwingConstants.CENTER);
		String iconPath = "/br/com/loja/assistec/icones/question.png";
		lblPergunta.setIcon(new ImageIcon(getClass().getResource(iconPath)));
		panel.add(lblPergunta, BorderLayout.CENTER);
		
		JPanel panelsul = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		
		JButton btnSim = new JButton("Sim");
		btnSim.setPreferredSize(new Dimension(100, 30));
		btnSim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resposta = 1;
				setVisible(false);
			}
		});
		panelsul.add(btnSim);
		
		JButton btnNao = new JButton("Não");
		btnNao.setPreferredSize(new Dimension(100, 30));
		btnNao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resposta = 0;
				setVisible(false);
			}
		});
		panelsul.add(btnNao);
		
		panelsul.setBorder(new EmptyBorder(10, 10, 20, 20));
		panel.add(panelsul, BorderLayout.SOUTH);
		setSize(400, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public int getResposta() {
		return resposta;
	}
}