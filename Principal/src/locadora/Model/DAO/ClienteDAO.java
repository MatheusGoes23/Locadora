package locadora.Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import locadora.Model.VO.ClienteVO;

public class ClienteDAO<VO extends ClienteVO> extends ConectarBD {

	// Métodos

	// Lista todos os dados dos clientes existentes no Banco de Dados
	public ResultSet listar() {
		connection = getConnection();
		String sql = "SELECT * FROM cliente";
		Statement st;
		ResultSet resultado = null;

		try {
			st = connection.createStatement();
			resultado = st.executeQuery(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	/*
	 * Busca e mostra os dados de um cliente expecífico no Banco de Bados a partir
	 * do cpf informado
	 */
	public ResultSet buscar(VO cliente) {
		String sql = "SELECT * FROM cliente WHERE cpf=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cliente.getCpf());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	/*
	 * Altera o nome de um cliente específico no Banco de Dados a partir do
	 * IdCliente informado
	 */
	public void alterar(VO cliente) {
		String sql = "UPDATE cliente SET nome=? WHERE idCliente=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cliente.getNome());
			ptst.setLong(2, cliente.getIdCliente());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Remove todos os dados de um cliente específico no Banco de Dados a partir do
	 * cpf informado
	 */
	public void removerByCPF(VO cliente) {
		String sql = "DELETE FROM cliente WHERE cpf=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cliente.getCpf());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Remove todos os dados de um cliente específico no Banco de Dados a partir do
	 * IdCliente informado
	 */
	public void removerById(VO cliente) {
		String sql = "DELETE FROM cliente WHERE IdCliente=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, cliente.getIdCliente());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Cadastra todos os dados de um cliente no Banco de Dados
	public void inserir(VO cliente) {
		String sql = "insert into cliente(nome, cpf, telefone, endereco) values(?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, cliente.getNome());
			ptst.setString(2, cliente.getCpf());
			ptst.setString(3, cliente.getTelefone());
			ptst.setString(4, cliente.getEndereco());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				cliente.setIdCliente(generatedKeys.getLong(1));
			} else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
