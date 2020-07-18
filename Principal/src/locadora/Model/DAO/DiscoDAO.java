package locadora.Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import locadora.Model.VO.DiscoVO;

public class DiscoDAO extends ConectarBD {

	// Métodos

	// Cadastra todos os dados de um disco no Banco de Dados
	public void inserir(DiscoVO disco) {
		connection = getConnection();
		String sql = "insert into disco(titulo, nomeBanda, genero, anoLancamento, qtdExemplares, valorAluguel) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ptst = connection.prepareStatement(sql);
			ptst.setString(1, disco.getTitulo());
			ptst.setString(2, disco.getNomeDaBanda());
			ptst.setString(3, disco.getGenero());
			ptst.setInt(4, disco.getAnoDeLancamento());
			ptst.setInt(5, disco.getQtdExemplares());
			ptst.setDouble(6, disco.getValorDoAluguel());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* Altera o valor de um disco específico no Banco de Dados
	   a partir do IdDisco informado */
	public void alterarValor(DiscoVO disco) {
		connection = getConnection();
		String sql = "UPDATE disco SET valorAluguel=? WHERE idDisco=?";
		try {
			PreparedStatement ptst = connection.prepareStatement(sql);
			ptst.setDouble(1, disco.getValorDoAluguel());
			ptst.setLong(2, disco.getIdProduto());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/* Altera a quantidade de exemplares de um disco específico no Banco de Dados
	   a partir do IdDisco informado */
	public void alterarQuantidade(DiscoVO disco) {
		connection = getConnection();
		String sql = "UPDATE disco SET qtdExemplares=? WHERE idDisco=?";
		try {
			PreparedStatement ptst = connection.prepareStatement(sql);
			ptst.setDouble(1, disco.getQtdExemplares());
			ptst.setLong(2, disco.getIdProduto());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/* Remove todos os dados de um disco específico no Banco de Dados
	   a partir do IdDisco informado */
	public void removerById(DiscoVO disco) {
		connection = getConnection();
		String sql = "DELETE FROM disco WHERE idDisco=?";
		try {
			PreparedStatement ptst = connection.prepareStatement(sql);
			ptst.setLong(1, disco.getIdProduto());
			ptst.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// Lista todos os dados dos disco existentes no Banco de Dados
	public List<DiscoVO> listar() {
		connection = getConnection();
		String sql = "SELECT * FROM disco";
		Statement st;
		ResultSet resultado;
		List<DiscoVO> discos = new ArrayList<DiscoVO>();

		try {
			st = connection.createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				DiscoVO disc = new DiscoVO();
				disc.setIdProduto(resultado.getLong("IdDisco"));
				disc.setTitulo(resultado.getString("titulo"));
				disc.setNomeDaBanda(resultado.getString("nomeBanda"));
				disc.setGenero(resultado.getString("genero"));
				disc.setAnoDeLancamento(resultado.getInt("anoLancamento"));
				disc.setQtdExemplares(resultado.getInt("qtdExemplares"));
				disc.setValorDoAlulguel(resultado.getDouble("valorAluguel"));
				discos.add(disc);
			}
		} catch (SQLException ex) {
			System.out.println("deu mal");
		}
		return discos;
	}

	/* Busca e mostra os dados de um disco expecífico no 
	   Banco de Bados a partir do IdDisco informado */
	public DiscoVO buscar(DiscoVO disco) {
		connection = getConnection();
		String sql = "SELECT * FROM disco WHERE idDisco=?";
		try {
			PreparedStatement ptst = connection.prepareStatement(sql);
			ptst.setLong(1, disco.getIdProduto());
			ResultSet resultado = ptst.executeQuery();
			if (resultado.next()) {
				disco.setIdProduto(resultado.getLong("IdDisco"));
				disco.setTitulo(resultado.getString("titulo"));
				disco.setNomeDaBanda(resultado.getString("nomeBanda"));
				disco.setGenero(resultado.getString("genero"));
				disco.setAnoDeLancamento(resultado.getInt("anoLancamento"));
				disco.setQtdExemplares(resultado.getInt("qtdExemplares"));
				disco.setValorDoAlulguel(resultado.getDouble("valorAluguel"));
				return disco;
			}
		} catch (SQLException ex) {
			System.out.println("deu mal");
		}
		return disco;
	}
}
