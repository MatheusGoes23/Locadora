package locadora.Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import locadora.Model.VO.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> extends ConectarBD {

	// M�todos

	// Cadastra os dados de um usu�rio no Banco de Dados
	public void inserir(VO usuario) {
		String sql = "insert into usuario(login, senha, perfil) values(?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, usuario.getLogin());
			ptst.setString(2, usuario.getSenha());
			ptst.setInt(3, usuario.getPerfil());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				usuario.setIdUsuario(generatedKeys.getLong(1));
			} else {
				throw new SQLException("A inser��o falhou. Nenhum id foi retornado.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Altera a senha de um usu�rio espec�fico no Banco de Dados a partir do id do
	 * usuario informado
	 */
	public void alterar(VO usuario) {
		String sql = "UPDATE usuario SET senha=? WHERE idUsuario=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, usuario.getSenha());
			ptst.setLong(2, usuario.getIdUsuario());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Remove os dados de um usu�rio espec�fico no Banco de Dados a partir do id do
	 * usuario informado
	 */
	public void removerById(VO usuario) {
		String sql = "DELETE FROM usuario WHERE idUsuario=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, usuario.getIdUsuario());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Lista os dados dos usu�rios existentes no Banco de Dados
	public ResultSet listar() {
		String sql = "SELECT * FROM usuario";
		Statement st;
		ResultSet resultado = null;

		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}
}
