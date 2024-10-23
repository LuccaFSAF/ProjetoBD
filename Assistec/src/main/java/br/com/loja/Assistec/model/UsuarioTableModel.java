package br.com.loja.Assistec.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] colunas = { "ID", "Nome", "Telefone", "Login", "Perfil" };
	private ArrayList<Usuario> usuariosList;

	public UsuarioTableModel(ArrayList<Usuario> usuarios) {
		this.usuariosList = usuarios;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return usuariosList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Usuario user = usuariosList.get(rowIndex);
		if (columnIndex == 0) {
			return user.getIduser();
		} else if (columnIndex == 1) {
			return user.getNome();
		} else if (columnIndex == 2) {
			return user.getFone();
		} else if (columnIndex == 3) {
			return user.getLogin();
		} else if (columnIndex == 4) {
			return user.getPerfil();
		} else {
			return null;
		}

	}

	public String getCollumnName(int coluna) {
		return colunas[coluna];
	}
}
