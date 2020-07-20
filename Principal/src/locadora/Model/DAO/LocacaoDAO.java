package locadora.Model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import locadora.Model.VO.LocacaoVO;

public class LocacaoDAO<VO extends LocacaoVO> extends ConectarBD<VO> implements LocacaoInterDAO<VO> {

	// Métodos

	// Cadastra os dados de uma locação já incluindo disco e livro informados, no
	// Banco de Dados
	public void inserir(VO locacao) {
		String sql = "insert into locacao(dataLocacao, dataDevolucao, cliente, produto, valorLocacao, multa, desconto, valorPago, pago) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setDate(1, new Date(locacao.getDataDaLocacao().getTimeInMillis()));
			ptst.setDate(2, new Date(locacao.getDataDaDevolucao().getTimeInMillis()));
			ptst.setLong(3, locacao.getCliente().getIdCliente());
			ptst.setLong(4, locacao.getProduto().getIdProduto());
			ptst.setDouble(5, locacao.getValorLocacao());
			ptst.setDouble(6, locacao.getMulta());
			ptst.setDouble(7, locacao.getDesconto());
			ptst.setDouble(8, locacao.getValorPago());
			ptst.setBoolean(9, locacao.isPago());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				locacao.setIdLocacao(generatedKeys.getLong(1));
			} else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void alterarLocacao() {
		// toDo
	}

	/*
	 * Remove os dados de uma locação específica no Banco de Dados a partir do id da
	 * locacao informado
	 */
	public void remover(VO locacao) {
		String sql = "DELETE FROM locacao WHERE idLocacao=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, locacao.getIdLocacao());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Busca os dados de uma locacão expecífica no Banco de Bados a partir do id da
	 * locação informada
	 */
	public ResultSet buscar(VO locacao) {
		String sql = "SELECT * FROM locacao WHERE idLocacao=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, locacao.getIdLocacao());
			resultado = ptst.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	public void imprimirFaturamentoMes() {
		// Lista dos itens alugados num determinado mês com os valores somados
		// toDo
	}

	public void imprimirLocacaoData() {
		// Lista de itens alugados num determinado período
		// toDo
	}

	// Lista os dados das locações existentes no Banco de Dados
	public ResultSet listar() {
		String sql = "SELECT * FROM locacao";
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

	public void imprimirComprovanteLocacao() {
		// Um recibo para locação
		// toDo
	}
}