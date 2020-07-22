package locadora.Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;

public class DiscoDAO<VO extends DiscoVO> extends ProdutoDAO<VO> implements DiscoInterDAO<VO> {

	// Métodos

	// Cadastra os dados de um disco no Banco de Dados
	public void inserir(VO disco) {
		String sql = "insert into disco(titulo, nomeBanda, genero, anoLancamento, qtdExemplares, valorAluguel) values(?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, disco.getTitulo());
			ptst.setString(2, disco.getNomeDaBanda());
			ptst.setString(3, disco.getGenero());
			ptst.setInt(4, disco.getAnoDeLancamento());
			ptst.setInt(5, disco.getQtdExemplares());
			ptst.setDouble(6, disco.getValorDoAluguel());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				disco.setIdProduto(generatedKeys.getLong(1));
			} else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Altera o valor do aluguel de um disco específico no Banco de Dados a partir
	 * do id do disco informado
	 */
	public void alterarValor(VO disco) {
		String sql = "UPDATE disco SET valorAluguel=? WHERE idDisco=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, disco.getValorDoAluguel());
			ptst.setLong(2, disco.getIdProduto());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Altera a quantidade de exemplares de um disco específico no Banco de Dados a
	 * partir do id do disco informado
	 */
	public void alterarQuantidade(VO disco) {
		String sql = "UPDATE disco SET qtdExemplares=? WHERE idDisco=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, disco.getQtdExemplares());
			ptst.setLong(2, disco.getIdProduto());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Remove os dados de um disco específico no Banco de Dados a partir do id do
	 * disco informado
	 */
	public void remover(VO disco) {
		String sql = "DELETE FROM disco WHERE idDisco=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, disco.getIdProduto());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Lista os dados dos discos existentes no Banco de Dados
	public List<DiscoVO> listar() {
		String sql = "SELECT * FROM disco";
		Statement st;
		ResultSet resultado = null;
		List<DiscoVO> discos = new ArrayList<DiscoVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				DiscoVO disc = new DiscoVO();
				disc.setIdProduto(resultado.getLong("idDisco"));
				disc.setTitulo(resultado.getString("titulo"));
				disc.setNomeDaBanda(resultado.getString("nomeBanda"));
				disc.setGenero(resultado.getString("genero"));
				disc.setAnoDeLancamento(resultado.getInt("anoLancamento"));
				disc.setQtdExemplares(resultado.getInt("qtdExemplares"));
				disc.setValorDoAlulguel(resultado.getDouble("valorAluguel"));
				discos.add(disc);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return discos;
	}

	/*
	 * Busca os dados de um disco expecífico no Banco de Bados a partir do id do
	 * disco informado
	 */
	public ResultSet buscar(VO disco) {
		String sql = "SELECT * FROM disco WHERE idDisco=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, disco.getIdProduto());
			resultado = ptst.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	/*
	 * Busca os dados de um disco expecífico no Banco de Bados a partir do título do
	 * disco informado
	 */
	public ResultSet buscarByTitle(VO disco) {
		String sql = "SELECT * FROM disco WHERE titulo=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, disco.getTitulo());
			resultado = ptst.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Recebe um titulo e faz uma pesquisa e retorna os dados do disco com esse
	// titulo
	public List<DiscoVO> pesquisar(VO disco) {
		String sql = "SELECT * FROM disco WHERE titulo=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<DiscoVO> discos = new ArrayList<DiscoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, disco.getTitulo());
			resultado = st.executeQuery();
			while (resultado.next()) {
				DiscoVO disc = new DiscoVO();
				disc.setIdProduto(resultado.getLong("idDisco"));
				disc.setTitulo(resultado.getString("titulo"));
				disc.setNomeDaBanda(resultado.getString("nomeBanda"));
				disc.setGenero(resultado.getString("genero"));
				disc.setAnoDeLancamento(resultado.getInt("anoLancamento"));
				disc.setQtdExemplares(resultado.getInt("qtdExemplares"));
				disc.setValorDoAlulguel(resultado.getDouble("valorAluguel"));
				discos.add(disc);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return discos;
	}

}
