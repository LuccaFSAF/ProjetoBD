package br.com.loja.Assistec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.loja.Assistec.dal.ModuloConexao;

public class UsuarioModel {

	public Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public UsuarioModel() {
		conexao = ModuloConexao.connector();
	}
	
	public String autenticar(String login, String senha) {
		String sql = "select * from usuarios where login = ?" + "and senha = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, login);
			pst.setString(2, senha);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String perfil = rs.getString("perfil");
				return perfil;
			}else {
				return null;
			}
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				return null;
		}
	}
	public void fecharConexao() {
		if(conexao != null) {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
