package br.com.loja.Assistec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.loja.Assistec.dal.ConexaoBD;

public class LoginDAO extends GenericDAO {

	public Boolean bancoOnLine() throws SQLException {
			Connection valor = getConnection();
			if (valor != null) {
				try {
					getConnection().close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return true;
			} else
				return false;
	}

	public Usuario autenticar(String login, String senha) throws SQLException {
		String sql = "select * from usuarios where login = ?" + "and senha = ?";
		Usuario usuario = null;
		PreparedStatement pstm = getConnection().prepareStatement(sql);
		pstm.setString(1, login);
		pstm.setString(2, senha);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			usuario = new Usuario();
			usuario.setIduser(rs.getInt("iduser"));
			usuario.setNome(rs.getString("nome"));
			usuario.setFone(rs.getString("fone"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setPerfil(rs.getString("perfil"));
		}
		rs.close();
		pstm.close();
		getConnection().close();

		return usuario;
	}
}
