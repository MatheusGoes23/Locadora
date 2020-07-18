package locadora.Model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import locadora.Model.VO.LocacaoVO;

public class LocacaoDAO extends ConectarBD {

	// Métodos

	// Cadastra todos os dados de uma locação no Banco de Dados
	public void inserir(LocacaoVO locacao) {
		connection = getConnection();
		String sql = "insert into locacao(dataLocacao, dataDevolucao, cliente, produto, valorLocacao, multa, desconto, valorPago, pago) values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptst = connection.prepareStatement(sql);
			ptst.setDate(1, new Date(locacao.getDataDaLocacao().getTimeInMillis()));
			ptst.setDate(2, new Date(locacao.getDataDaDevolucao().getTimeInMillis()));
			ptst.setLong(3, locacao.getCliente().getIdCliente());
			ptst.setLong(4, locacao.getProduto().getIdProduto());
			ptst.setDouble(5, locacao.getValorLocacao());
			ptst.setDouble(6, locacao.getMulta());
			ptst.setDouble(7, locacao.getDesconto());
			ptst.setDouble(8, locacao.getValorPago());
			ptst.setBoolean(9, locacao.isPago());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterarLocacao() {
		// toDo
	}

	/* Remove todos os dados de uma locação específica no Banco de Dados
	   a partir do IdLocacao informado */
	public void removerById(LocacaoVO locacao) {
		connection = getConnection();
		String sql = "DELETE FROM locacao WHERE idLocacao=?";
		try {
			PreparedStatement ptst = connection.prepareStatement(sql);
			ptst.setLong(1, locacao.getIdLocacao());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void pesquisarLocacao() {
		// toDo
	}

	public void imprimirFaturamentoMes() {
		// Lista dos itens alugados num determinado mês com os valores somados
		// toDo
	}

	public void imprimirLocacaoData() {
		// Lista de itens alugados num determinado período
		// toDo
	}

	// Lista todos os dados das locações existentes no Banco de Dados
	public List<LocacaoVO> listar() {
		connection = getConnection();
		String sql = "SELECT * FROM locacao";
		Statement st;
		ResultSet resultado;
		List<LocacaoVO> locacoes = new ArrayList<LocacaoVO>();

		try {
			st = connection.createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				LocacaoVO loc = new LocacaoVO();
				loc.setIdLocacao(resultado.getLong("IdLocacao"));
//                loc.setDataDaLocacao(resultado.getDate("dataLocacao"));
//                loc.setDataDaDevolucao(resultado.getString("nomeBanda"));
				loc.getCliente().setIdCliente(resultado.getLong("cliente"));
				loc.getProduto().setIdProduto(resultado.getLong("produto"));
				loc.setValorLocacao(resultado.getDouble("valorLocacao"));
				loc.setMulta(resultado.getDouble("multa"));
				loc.setDesconto(resultado.getDouble("desconto"));
				loc.setValorPago(resultado.getDouble("valorPago"));
				loc.setPago(resultado.getBoolean("pago"));
				locacoes.add(loc);
			}
		} catch (SQLException ex) {
			System.out.println("deu mal");
		}
		return locacoes;
	}

	public void imprimirComprovanteLocacao() {
		// Um recibo para locação
		// toDo
	}
}