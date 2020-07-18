package locadora.Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import locadora.Model.VO.UsuarioVO;

public class UsuarioDAO extends ConectarBD {

	// Métodos
	
	// Cadastra os dados de um usuário no Banco de Dados
	public void inserir(UsuarioVO usuario) {
		connection = getConnection();
		String sql = "insert into usuario(login, senha, perfil) values(?,?,?)";
		try {
			PreparedStatement ptst = connection.prepareStatement(sql);
			ptst.setString(1, usuario.getLogin());
			ptst.setString(2, usuario.getSenha());
			ptst.setInt(3, usuario.getPerfil());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* Altera a senha de um usuário específico no Banco de Dados
	   a partir do IdUsuario informado */
	public void alterar(UsuarioVO usuario) {
		connection = getConnection();
		String sql = "UPDATE usuario SET senha=? WHERE idUsuario=?";
		try {
			PreparedStatement ptst = connection.prepareStatement(sql);
			ptst.setString(1, usuario.getSenha());
			ptst.setLong(2, usuario.getIdUsuario());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("deu mal");
		}
	}

	/* Remove todos os dados de um usuário específico no Banco de Dados
	   a partir do IdUsuario informado */
	public void removerById(UsuarioVO usuario) {
		connection = getConnection();
		String sql = "DELETE FROM usuario WHERE idUsuario=?";
		try {
			PreparedStatement ptst = connection.prepareStatement(sql);
			ptst.setLong(1, usuario.getIdUsuario());
			ptst.executeUpdate();
			System.out.println("Usuário removido!");

		} catch (SQLException ex) {
			System.out.println("deu mal");
		}
	}

	// Lista todos os dados dos usuários existentes no Banco de Dados
	public List<UsuarioVO> listar() {
		connection = getConnection();
		String sql = "SELECT * FROM usuario";
		Statement st;
		ResultSet resultado;
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();

		try {
			st = connection.createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				UsuarioVO usu = new UsuarioVO();
				usu.setIdUsuario(resultado.getLong("IdUsuario"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				usu.setPerfil(resultado.getInt("perfil"));
				usuarios.add(usu);
			}
		} catch (SQLException ex) {
			System.out.println("deu mal");
		}
		return usuarios;
	}
}
