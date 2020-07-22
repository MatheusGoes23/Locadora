package locadora.Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;
import locadora.Model.VO.UsuarioVO;

public class LivroDAO<VO extends LivroVO> extends ProdutoDAO<VO> implements LivroInterDAO<VO> {

	// Métodos

	// Cadastra os dados de um livro no Banco de Dados
	public void inserir(VO livro) {
		String sql = "insert into livro(titulo, autor, genero, anoLancamento, qtdExemplares, qtdPaginas, valorAluguel) values(?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, livro.getTitulo());
			ptst.setString(2, livro.getAutor());
			ptst.setString(3, livro.getGenero());
			ptst.setInt(4, livro.getAnoDeLancamento());
			ptst.setInt(5, livro.getQtdExemplares());
			ptst.setInt(6, livro.getQtdPaginas());
			ptst.setDouble(7, livro.getValorDoAluguel());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				livro.setIdProduto(generatedKeys.getLong(1));
			} else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Altera o valor do aluguel de um livro específico no Banco de Dados a partir
	 * do id do livro informado
	 */
	public void alterarValor(VO livro) {
		String sql = "UPDATE livro SET valorAluguel=? WHERE idLivro=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, livro.getValorDoAluguel());
			ptst.setLong(2, livro.getIdProduto());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Altera a quantidade de exemplares de um livro específico no Banco de Dados a
	 * partir do id do livro informado
	 */
	public void alterarQuantidade(VO livro) {
		String sql = "UPDATE livro SET qtdExemplares=? WHERE idLivro=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, livro.getQtdExemplares());
			ptst.setLong(2, livro.getIdProduto());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Remove os dados de um livro específico no Banco de Dados a partir do id do
	 * livro informado
	 */
	public void remover(VO livro) {
		String sql = "DELETE FROM livro WHERE idLivro=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, livro.getIdProduto());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Lista todos os dados dos livros existentes no Banco de Dados
	public List<LivroVO> listar() {
		String sql = "SELECT * FROM livro";
		Statement st;
		ResultSet resultado = null;
		List<LivroVO> livros = new ArrayList<LivroVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				LivroVO liv = new LivroVO();
				liv.setIdProduto(resultado.getLong("idLivro"));
				liv.setTitulo(resultado.getString("titulo"));
				liv.setAutor(resultado.getString("autor"));
				liv.setGenero(resultado.getString("genero"));
				liv.setAnoDeLancamento(resultado.getInt("anoLancamento"));
				liv.setQtdExemplares(resultado.getInt("qtdExemplares"));
				liv.setQtdPaginas(resultado.getInt("qtdPaginas"));
				liv.setValorDoAlulguel(resultado.getDouble("valorAluguel"));
				livros.add(liv);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return livros;
	}

	/*
	 * Busca os dados de um livro expecífico no Banco de Bados a partir do id do
	 * livro informado
	 */
	public ResultSet buscar(VO livro) {
		String sql = "SELECT * FROM livro WHERE idLivro=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, livro.getIdProduto());
			resultado = ptst.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	/*
	 * Busca os dados de um livro expecífico no Banco de Bados a partir do titulo do
	 * livro informado
	 */
	public ResultSet buscarByTitle(VO livro) {
		String sql = "SELECT * FROM livro WHERE titulo=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, livro.getTitulo());
			resultado = ptst.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Recebe um titulo e faz uma pesquisa e retorna os dados do livro com esse
	// titulo
	public List<LivroVO> pesquisar(VO livro) {
		String sql = "SELECT * FROM livro WHERE titulo=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<LivroVO> livros = new ArrayList<LivroVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, livro.getTitulo());
			resultado = st.executeQuery();
			while (resultado.next()) {
				LivroVO liv = new LivroVO();
				liv.setIdProduto(resultado.getLong("idLivro"));
				liv.setTitulo(resultado.getString("titulo"));
				liv.setAutor(resultado.getString("autor"));
				liv.setGenero(resultado.getString("genero"));
				liv.setAnoDeLancamento(resultado.getInt("anoLancamento"));
				liv.setQtdExemplares(resultado.getInt("qtdExemplares"));
				liv.setQtdPaginas(resultado.getInt("qtdPaginas"));
				liv.setValorDoAlulguel(resultado.getDouble("valorAluguel"));
				livros.add(liv);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return livros;
	}
}
