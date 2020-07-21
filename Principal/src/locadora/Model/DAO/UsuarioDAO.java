package locadora.Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import locadora.Model.VO.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> extends ConectarBD<VO> implements UsuarioInterDAO<VO> {

	// Métodos

	// Cadastra os dados de um usuário no Banco de Dados
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
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				usuario.setIdUsuario(generatedKeys.getLong(1));
			} else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Altera a senha de um usuário específico no Banco de Dados a partir do id do
	 * usuario informado
	 */
	public void alterar(VO usuario) {
		String sql = "UPDATE usuario SET senha=? WHERE login=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, usuario.getSenha());
			ptst.setString(2, usuario.getLogin());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Remove os dados de um usuário específico no Banco de Dados a partir do id do
	 * usuario informado
	 */
	public void remover(VO usuario) {
		String sql = "DELETE FROM usuario WHERE login=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, usuario.getLogin());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Busca os dados de um usuario expecífico no Banco de Bados a partir do id
	 * informado
	 */
	public ResultSet buscar(VO usuario) {
		String sql = "SELECT * FROM usuario WHERE login=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, usuario.getLogin());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Lista os dados dos usuários existentes no Banco de Dados
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

	// Autenticar o usuário, se login e senha estão corretos e mostra o perfil do
	// usuário
	public void autenticar(VO usu) {
		String sql = "SELECT * FROM usuario";
		Statement st;
		ResultSet resultado = null;
		String situacao = "Não encontrou usuario";
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			// encontrar usuario

			while (resultado.next()) {
				// existe e senha ok. Descobrir se é proprietário, funcionário ou administrador
				UsuarioVO usuario = new UsuarioVO();
				usuario.setIdUsuario(resultado.getLong("idUsuario"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getNString("senha"));
				usuario.setPerfil(resultado.getInt("Perfil"));
				if ((usuario.getLogin().equals(usu.getLogin()) && (usuario.getSenha().equals(usu.getSenha())))) {
					if (usuario.getPerfil() == 1)
						situacao = "Usuário é o Proprietário";
					else if (usuario.getPerfil() == 2)
						situacao = "Usuário é o Funcionário";
					else if (usuario.getPerfil() == 3)
						situacao = "Usuário é o Administrador";

				}
			}

			System.out.println(situacao);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Deu mal");
		}
	}

}
